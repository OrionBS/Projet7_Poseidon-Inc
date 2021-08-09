package fr.orionbs.controllers;

import fr.orionbs.dataTransferObjects.UserDTO;
import fr.orionbs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/user/creating")
    public boolean creatingUser(UserDTO userDTO) {
        boolean answer = userService.creatingUser(userDTO);
        if (answer) {
            return true;
        }
        return false;
    }

    @GetMapping(path = "/user/reading")
    public UserDTO readingUser(Integer index) {
        return userService.readingUser(index);
    }

    @GetMapping(path = "/user/readingAll")
    public List<UserDTO> readingAllUser() {
        return userService.readingAllUser();
    }

    @PutMapping(path = "/user/updating")
    public boolean updatingUser(UserDTO userDTO) {
        boolean answer = userService.updatingUser(userDTO);
        if (answer) {
            return true;
        }
        return false;
    }

    @DeleteMapping(path = "/user/deleting")
    public boolean deletingUser(Integer index) {
        boolean answer = userService.deletingUser(index);
        if (answer) {
            return true;
        }
        return false;
    }
}
