package it.modofelice.grandegita.auth.registration;

import it.modofelice.grandegita.auth.registration.emailsender.EmailSender;
import it.modofelice.grandegita.auth.registration.token.ConfirmationToken;
import it.modofelice.grandegita.auth.registration.token.ConfirmationTokenService;
import it.modofelice.grandegita.auth.user.User;
import it.modofelice.grandegita.auth.user.UserRole;
import it.modofelice.grandegita.auth.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class RegistrationService {

    private final UserService service;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;

    public String register(RegistrationRequest registrationRequest) {
        log.debug("Start registration of new user with email {}", registrationRequest.getEmail());
        boolean isValidEmail = emailValidator.test(registrationRequest.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email is not valid");
        }
        User newUser = User.builder()
                .email(registrationRequest.getEmail())
                .password(registrationRequest.getPassword())
                .userRole(UserRole.USER)
                .enabled(false)
                .locked(false)
                .build();
        String token = service.singUpUser(newUser);
        String link = "http://localhost:8083/api/v1/registration/confirm?token=" + token;
        log.debug("New user {} has been successfully created", newUser.getId());
        emailSender.send(newUser.getEmail(), link);
        return link;
    }
    @Transactional
    public String confirmToken(String token){
        log.debug("Request to find token {}", token);
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token)
                .orElseThrow(()-> new IllegalStateException("token not found"));

        if(confirmationToken.getConfirmedAt() != null){
            throw new IllegalStateException("token has been alredy confirmed");
        }

        LocalDateTime expiresAt = confirmationToken.getExpiresAt();
        if(expiresAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("token has expired");
        }
        confirmationTokenService.setConfirmedAt(confirmationToken);

        service.enableUser(confirmationToken.getUser().getEmail());
        return "confirmed";

    }

}
