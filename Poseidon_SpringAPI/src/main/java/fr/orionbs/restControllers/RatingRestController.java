package fr.orionbs.restControllers;

import fr.orionbs.dto.RatingDTO;
import fr.orionbs.services.RatingService;
import fr.orionbs.services.impl.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/rating")
public class RatingRestController {

    @Autowired
    RatingService ratingService;

    @PostMapping
    public ResponseEntity<Boolean> creatingRating(@RequestBody RatingDTO ratingDTO) {

        boolean answer = ratingService.creatingRating(ratingDTO);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/{index}")
    public ResponseEntity<RatingDTO> readingRating(@PathVariable(value = "index") Integer index) {

        RatingDTO ratingDTO = ratingService.readingRating(index);

        if (ratingDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ratingDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RatingDTO>> readingAllRating() {

        List<RatingDTO> ratingDTOList = ratingService.readingAllRating();

        return new ResponseEntity<>(ratingDTOList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Boolean> updatingRating(@RequestBody RatingDTO ratingDTO) {

        boolean answer = ratingService.updatingRating(ratingDTO);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deletingRating(@RequestParam(value = "index") Integer index) {

        boolean answer = ratingService.deletingRating(index);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
