package lgbt.lia.bouldertracker.service;

import lgbt.lia.bouldertracker.entity.Route;
import lgbt.lia.bouldertracker.repository.RouteRepository;
import lgbt.lia.bouldertracker.dto.RouteDTO;
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
        Route route = Route.builder()
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
                .map(route -> RouteDTO.builder()
                        .completionDate(route.getCompletionDate())
                        .farbe(route.getFarbe())
                        .flash(route.isFlash())
                        .schwierigkeit(route.getSchwierigkeit())
                        .wand(route.getWand())
                        .build()
                ).toList();
    }
}
