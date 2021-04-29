package kpi.ua.exhibition.controller;

import kpi.ua.exhibition.model.Sculpture;
import kpi.ua.exhibition.service.SculptureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sculptures")
public class SculptureController {
    private final SculptureService sculptureService;

    @Autowired
    public SculptureController(SculptureService sculptureService) {
        this.sculptureService = sculptureService;
    }

    @PostMapping
    public Sculpture save(@RequestBody Sculpture sculpture) {
        return sculptureService.save(sculpture);
    }

    @GetMapping("/title")
    public Sculpture getByTitle(@RequestParam(name = "title") String title) {
        return sculptureService.getByTitle(title);
    }
}
