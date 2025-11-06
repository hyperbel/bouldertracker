package lgbt.lia.bouldertracker.data;

import jakarta.persistence.*;
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
