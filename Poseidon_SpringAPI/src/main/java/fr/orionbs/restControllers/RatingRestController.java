package fr.orionbs.restControllers;

import fr.orionbs.dataTransferObjects.RatingDTO;
import fr.orionbs.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RatingRestController {

    @Autowired
    RatingService ratingService;

    @PostMapping(path = "/rating/creating")
    public boolean creatingRating(RatingDTO ratingDTO) {
        boolean answer = ratingService.creatingRating(ratingDTO);
        if (answer) {
            return true;
        }
        return false;
    }

    @GetMapping(path = "/rating/reading")
    public RatingDTO readingRating(Integer index) {
        return ratingService.readingRating(index);
    }

    @GetMapping(path = "/rating/readingAll")
    public List<RatingDTO> readingAllRating() {
        return ratingService.readingAllRating();
    }

    @PutMapping(path = "/rating/updating")
    public boolean updatingRating(RatingDTO ratingDTO) {
        boolean answer = ratingService.updatingRating(ratingDTO);
        if (answer) {
            return true;
        }
        return false;
    }

    @DeleteMapping(path = "/rating/deleting")
    public boolean deletingRating(Integer index) {
        boolean answer = ratingService.deletingRating(index);
        if (answer) {
            return true;
        }
        return false;
    }
}
