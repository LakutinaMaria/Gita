package it.modofelice.grandegita.explorer.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class Explorer implements Serializable {

    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String gender;
    private String imageUrl;

}
