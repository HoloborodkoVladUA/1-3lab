package kpi.ua.exhibition.controller;

import kpi.ua.exhibition.model.Exhibition;
import kpi.ua.exhibition.model.Picture;
import kpi.ua.exhibition.model.Visitor;
import kpi.ua.exhibition.service.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exhibitions")
public class ExhibitionController {
    private final ExhibitionService exhibitionService;

    @Autowired
    public ExhibitionController(ExhibitionService exhibitionService) {
        this.exhibitionService = exhibitionService;
    }

    @GetMapping
    public List<Exhibition> getAll() {
        return exhibitionService.getAll();
    }

    @PostMapping
    public Exhibition add(@RequestBody Exhibition exhibition) {
        return exhibitionService.save(exhibition);
    }

    @GetMapping("/id")
    public Exhibition getById(@RequestParam(name = "id") Long id) {
        return exhibitionService.getById(id);
    }

    @PostMapping("/id")
    public Exhibition addPicture(@RequestParam(name = "id") Long id, @RequestBody Picture picture) {
        return exhibitionService.addPicture(id, picture);
    }

    @GetMapping("/id/remove-picture")
    Exhibition extractPicture(@RequestParam(name = "id") Long id, @RequestBody Picture picture) {
        return exhibitionService.extractPicture(id, picture);
    }

    @GetMapping("/id/let-visitor")
    Exhibition letVisitorInto(@RequestParam(name = "id") Long id, @RequestBody Visitor visitor) {
        return exhibitionService.letVisitorInto(id, visitor);
    }

    @GetMapping("/id/let-visitor-out")
    Exhibition letVisitorOut(@RequestParam(name = "id") Long id, @RequestBody Visitor visitor) {
        return exhibitionService.letVisitorOut(id, visitor);
    }
}
