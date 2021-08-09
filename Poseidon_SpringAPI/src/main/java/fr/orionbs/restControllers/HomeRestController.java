package fr.orionbs.restControllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {

    @GetMapping(path = "")
    public String home() {
        return "Poseidon Spring API !";
    }
}
