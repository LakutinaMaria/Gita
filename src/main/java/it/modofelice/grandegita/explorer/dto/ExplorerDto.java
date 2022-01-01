package it.modofelice.grandegita.explorer.dto;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Getter @Setter @ToString
public class ExplorerDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String gender;
    private String imageUrl;
}
