package it.modofelice.grandegita.adventure.dto;

import it.modofelice.grandegita.adventure.model.AdventureStatus;
import it.modofelice.grandegita.spot.dto.SpotDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data @Builder
public class AdventureDto {
    private UUID id;
    private LocalDateTime dateTime;
    private LocalDateTime finishDateTime;
    private AdventureStatus adventureStatus;
    private SpotDto spot;
}
