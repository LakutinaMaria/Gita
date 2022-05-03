package it.modofelice.grandegitaauth.auth.registration.emailsender;

public interface EmailSender {

    void send(String to, String email);
}
