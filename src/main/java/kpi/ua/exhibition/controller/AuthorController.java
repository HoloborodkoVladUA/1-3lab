package kpi.ua.exhibition.controller;

import kpi.ua.exhibition.model.Author;
import kpi.ua.exhibition.model.Exhibit;
import kpi.ua.exhibition.model.Material;
import kpi.ua.exhibition.model.Picture;
import kpi.ua.exhibition.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @PostMapping
    public Author add(@RequestBody Author author) {
        return authorService.save(author);
    }

    @GetMapping("/id")
    public Author getById(@RequestParam(name = "id") Long id) {
        return authorService.getById(id);
    }

    @PostMapping("/id/picture")
    Exhibit createPicture(@RequestParam(name = "id") Long id, String title) {
        return authorService.createPicture(id, title);
    }

    @PostMapping("/id/sculpture")
    Exhibit createSculpture(@RequestParam(name = "id") Long id, Material material, String title) {
        return authorService.createSculpture(id, material, title);
    }

    @GetMapping("/surname")
    Author getBySurname(String surname) {
        return authorService.getBySurname(surname);
    }

    @GetMapping("/pictures")
    List<Picture> getPictures(Long authorId) {
        return authorService.getPictures(authorId);
    }

}
