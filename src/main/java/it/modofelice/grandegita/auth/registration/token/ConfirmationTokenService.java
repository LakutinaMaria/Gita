package it.modofelice.grandegita.auth.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    final private ConfirmationTokenRepository repository;

    public void saveConfirmationToken(ConfirmationToken token){
        repository.save(token);
    }
}
