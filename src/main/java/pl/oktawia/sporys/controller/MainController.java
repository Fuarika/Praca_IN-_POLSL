package pl.oktawia.sporys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class MainController {

    public static final String MAIN_PAGE = "index";

    @RequestMapping
    public String mainPage() {
        return MAIN_PAGE;
    }
}
