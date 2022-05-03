package it.modofelice.grandegitaauth.auth.registration.token;

import it.modofelice.grandegitaauth.auth.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmationToken {

    @SequenceGenerator(
            name = "token_sequence",
            sequenceName = "token_sequence",
            allocationSize = 1

    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "token_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "user_id"
    )
    private User user;
}
