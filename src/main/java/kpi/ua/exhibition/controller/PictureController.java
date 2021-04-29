package kpi.ua.exhibition.controller;

import kpi.ua.exhibition.model.Picture;
import kpi.ua.exhibition.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pictures")
public class PictureController {
    private final PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @PostMapping
    public Picture save(@RequestBody Picture picture) {
        return pictureService.save(picture);
    }

    @GetMapping("/title")
    public Picture getByTitle(@RequestParam(name = "title") String title) {
        return pictureService.getByTitle(title);
    }
}
