package it.modofelice.grandegita.auth.registration;

import it.modofelice.grandegita.auth.user.User;
import it.modofelice.grandegita.auth.user.UserRole;
import it.modofelice.grandegita.auth.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RegistrationService {

    private final UserService service;
    private final EmailValidator emailValidator;

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
        String link = service.singUpUser(newUser);
        log.debug("New user {} has been successfully created", newUser.getId());

        //TODO : send email
        return link;
    }

}
