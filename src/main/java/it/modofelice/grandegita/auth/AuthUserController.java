package it.modofelice.grandegita.auth;

import it.modofelice.grandegita.auth.registration.RegistrationRequest;
import it.modofelice.grandegita.auth.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/registration")
@AllArgsConstructor
public class AuthUserController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @PostMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }
}
