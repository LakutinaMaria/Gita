package it.modofelice.grandegitaauth.auth.registration.token;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ConfirmationTokenService {

    final private ConfirmationTokenRepository repository;

    public void saveConfirmationToken(ConfirmationToken token){
        repository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token){
        log.debug("Request to get token {} in repository" , token);
        Optional<ConfirmationToken> result = repository.findByToken(token);
        log.debug("Token {} is present in repository: {}", token, result.isPresent());
        return result;
    }

    public void setConfirmedAt(ConfirmationToken token){
        log.debug("Request to set confirmation for token {}" , token.getToken());
        token.setConfirmedAt(LocalDateTime.now());
        repository.save(token);
        log.debug("Confirmation has been set for token {} at {}", token.getToken(), token.getConfirmedAt());
    }
}
