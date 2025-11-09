package lgbt.lia.bouldertracker.dto;

import lgbt.lia.bouldertracker.data.Farbe;
import lgbt.lia.bouldertracker.data.Wand;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteDTO {
    private Farbe farbe;
    private Wand wand;
    private char schwierigkeit;
    private boolean flash;
    private LocalDate completionDate;
    //private RoutenTyp typ;
}
