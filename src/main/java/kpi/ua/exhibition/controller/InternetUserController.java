package kpi.ua.exhibition.controller;

import kpi.ua.exhibition.model.InternetUser;
import kpi.ua.exhibition.service.InternetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class InternetUserController {
    private final InternetUserService internetUserService;

    @Autowired
    public InternetUserController(InternetUserService internetUserService) {
        this.internetUserService = internetUserService;
    }

    @GetMapping("/email")
    public InternetUser getByEmail(@RequestParam(name = "email") String email) {
        return internetUserService.getByEmail(email);
    }

    @PostMapping
    public InternetUser save(@RequestBody InternetUser user) {
        return internetUserService.save(user);
    }
}
