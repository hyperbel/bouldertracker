package lgbt.lia.bouldertracker.controller;

import lgbt.lia.bouldertracker.data.RouteDTO;
import lgbt.lia.bouldertracker.data.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RouteController {
    @Autowired
    private RouteService routeService;

    @GetMapping
    public String mainMenu(Model model) {
        return "main-menu";
    }

    @GetMapping("add-route")
    public String addRoute(Model model) {
        model.addAttribute("routeData", new RouteDTO());
        return "add-route";
    }

    @PostMapping("add-route")
    public String addRouteForm(@ModelAttribute RouteDTO routeData) {
        routeService.completed(routeData);
        return "main-menu";
    }

    @GetMapping("list-routes")
    public String listRoutes(Model model) {
        model.addAttribute("routes", routeService.getAll());
        return "list-routes";
    }
}