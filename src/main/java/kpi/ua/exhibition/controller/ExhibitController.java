package kpi.ua.exhibition.controller;

import kpi.ua.exhibition.model.Exhibit;
import kpi.ua.exhibition.service.ExhibitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exhibits")
public class ExhibitController {
    private final ExhibitService exhibitService;

    @Autowired
    public ExhibitController(ExhibitService exhibitService) {
        this.exhibitService = exhibitService;
    }

    @GetMapping
    public List<Exhibit> getAll() {
        return exhibitService.getAll();
    }

    @PostMapping
    public Exhibit add(@RequestBody Exhibit exhibit) {
        return exhibitService.save(exhibit);
    }

    @GetMapping("/id")
    public Exhibit getById(@RequestParam(name = "id") Long id) {
        return exhibitService.getById(id);
    }
}
