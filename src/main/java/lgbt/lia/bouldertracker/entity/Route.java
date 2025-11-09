package lgbt.lia.bouldertracker.entity;

import jakarta.persistence.*;
import lgbt.lia.bouldertracker.data.Farbe;
import lgbt.lia.bouldertracker.data.Wand;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    private Farbe farbe;
    private char schwierigkeit;
    private Wand wand;
    private boolean flash;
    private LocalDate completionDate;
    //private RoutenTyp typ;
}
