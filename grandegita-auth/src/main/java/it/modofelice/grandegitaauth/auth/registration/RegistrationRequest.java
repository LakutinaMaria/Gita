package it.modofelice.grandegitaauth.auth.registration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegistrationRequest {
    private final String email;
    private final String password;

    @JsonCreator
    public RegistrationRequest(
        @JsonProperty("email") String email,
        @JsonProperty("password") String password) {
        this.email = email;
        this.password = password;
    }
}
