package kpi.ua.exhibition.controller;

import kpi.ua.exhibition.model.Exhibition;
import kpi.ua.exhibition.model.Visitor;
import kpi.ua.exhibition.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/visitors")
public class VisitorController {
    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping
    public List<Visitor> getAll() {
        return visitorService.getAll();
    }

    @PostMapping
    public Visitor add(@RequestBody Visitor visitor) {
        return visitorService.save(visitor);
    }

    @PostMapping("/id")
    public Visitor visit(@RequestParam(name = "id") Long visitorId, @RequestBody Exhibition exhibition) {
        return visitorService.visit(visitorId, exhibition);
    }
}
