package fr.orionbs.restControllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "")
public class HomeRestController {

    @GetMapping
    public String home() {
        return "Poseidon Spring API !";
    }
}
