package lgbt.lia.bouldertracker.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.time.LocalDate;
import java.util.List;

@Service
@ApplicationScope
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    public void completed(RouteDTO routeData) {
        Route route = new Route.RouteBuilder()
                .flash(routeData.isFlash())
                .wand(routeData.getWand())
                .farbe(routeData.getFarbe())
                .schwierigkeit(routeData.getSchwierigkeit())
                .completionDate(LocalDate.now())
                .build();
        routeRepository.save(route);
    }

    public List<RouteDTO> getAll() {
        return routeRepository.findAll().stream()
                .map(route -> new RouteDTO.RouteDTOBuilder()
                        .completionDate(route.getCompletionDate())
                        .farbe(route.getFarbe())
                        .flash(route.isFlash())
                        .schwierigkeit(route.getSchwierigkeit())
                        .wand(route.getWand())
                        .build()
                ).toList();
    }
}
