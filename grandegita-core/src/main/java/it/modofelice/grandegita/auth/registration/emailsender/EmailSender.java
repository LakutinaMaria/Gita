package it.modofelice.grandegita.auth.registration.emailsender;

public interface EmailSender {

    void send(String to, String email);
}
