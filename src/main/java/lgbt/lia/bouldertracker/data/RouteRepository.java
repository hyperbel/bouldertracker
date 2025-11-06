package lgbt.lia.bouldertracker.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
public interface RouteRepository extends JpaRepository<Route, Long> {
}
