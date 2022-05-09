package it.modofelice.grandegita.adventure.model;

import com.sun.istack.NotNull;
import it.modofelice.grandegita.spot.model.Spot;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data @Builder
@Table(name = "adventure", schema = "core")
public class Adventure implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDateTime dateTime;
    private LocalDateTime finishDateTime;
    @Enumerated(EnumType.STRING)
    private AdventureStatus adventureStatus;

    @ManyToOne
    @JoinColumn(name = "spot_id")
    @NotNull
    private Spot spot;

    @Override
    public String toString() {
        return "Adventure{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", finishDateTime=" + finishDateTime +
                ", spot=" + spot +
                '}';
    }
}
