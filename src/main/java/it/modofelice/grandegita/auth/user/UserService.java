package it.modofelice.grandegita.auth.user;

import it.modofelice.grandegita.auth.registration.token.ConfirmationToken;
import it.modofelice.grandegita.auth.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "User with email %s not found";
    private final static String EMAIL_TAKEN = "Email %s  already taken";

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.debug("Attempt to load user by email: {}" , email);
        var user = userRepository.findByEmail(email).orElseThrow(
                ()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
        log.debug("Loaded user {} by email {}", user.getId(), email);
        return user;
    }

    public String singUpUser(User user){
        log.debug("Start singing up user: {}" , user);
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();
        if(userExists){
            throw new IllegalStateException(String.format(EMAIL_TAKEN, user.getEmail()));
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        ConfirmationToken token = ConfirmationToken.builder()
                .token(UUID.randomUUID().toString())
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(30))
                .user(user)
                .build();
        userRepository.save(user);
        log.debug("New token has been created for user {}", user.getId());
        confirmationTokenService.saveConfirmationToken(token);
        return token.getToken();
    }
}
