package it.modofelice.grandegita.spot.dto;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter @ToString @Builder
public class SpotDto {
    private UUID id;
    private String description;
    private Long parentId;
}
