package it.modofelice.grandegita.auth.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "User with email %s not found";
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.debug("Authorization attempt by email: {}" , email);
        var user = userRepository.findByEmail(email).orElseThrow(
                ()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
        log.debug("Loaded user {} by email {}", user.getId(), email);
        return user;
    }
}
