package ci.digitalacademy.cantine.controllers;

import ci.digitalacademy.cantine.models.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {


    @GetMapping
    public String showHomehPage(){
        return "home/index";
    }
}
