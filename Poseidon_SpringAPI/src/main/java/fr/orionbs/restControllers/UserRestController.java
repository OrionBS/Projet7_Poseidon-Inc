package fr.orionbs.restControllers;

import fr.orionbs.dto.UserDTO;
import fr.orionbs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/user")
public class UserRestController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<Boolean> creatingUser(@RequestBody UserDTO userDTO) {

        boolean answer = userService.creatingUser(userDTO);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/{index}")
    public ResponseEntity<UserDTO> readingUser(@PathVariable(value = "index") Integer index) {

        UserDTO userDTO = userService.readingUser(index);

        if (userDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> readingAllUser() {

        List<UserDTO> userDTOList = userService.readingAllUser();

        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Boolean> updatingUser(@RequestBody UserDTO userDTO) {

        boolean answer = userService.updatingUser(userDTO);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deletingUser(@RequestParam(value = "index") Integer index) {

        boolean answer = userService.deletingUser(index);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
