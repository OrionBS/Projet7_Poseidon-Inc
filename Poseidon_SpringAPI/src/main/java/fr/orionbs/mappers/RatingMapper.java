package fr.orionbs.mappers;

import fr.orionbs.dtos.RatingDTO;
import fr.orionbs.models.Rating;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RatingMapper {

    public RatingDTO ratingToRatingDTO(Rating rating) {
        RatingDTO ratingDTO = new RatingDTO(rating.getId(), rating.getMoodysRating(), rating.getSAndPRating(), rating.getFitchRating(), rating.getOrderNumber());
        return ratingDTO;
    }

    public Rating ratingDtoToRating(RatingDTO ratingDTO) {
        Rating rating = new Rating();
        rating.setId(ratingDTO.getId());
        rating.setMoodysRating(ratingDTO.getMoodysRating());
        rating.setSAndPRating(ratingDTO.getSAndPRating());
        rating.setFitchRating(ratingDTO.getFitchRating());
        rating.setOrderNumber(ratingDTO.getOrderNumber());
        return rating;
    }

    public List<RatingDTO> ratingToRatingDTOList(List<Rating> ratingList) {
        List<RatingDTO> ratingDTOList = new ArrayList<>();
        for (Rating rating : ratingList) {
            RatingDTO ratingDTO = ratingToRatingDTO(rating);
            ratingDTOList.add(ratingDTO);
        }
        return ratingDTOList;
    }

    public List<Rating> ratingDtoToRatingList(List<RatingDTO> ratingDTOList) {
        List<Rating> ratingList = new ArrayList<>();
        for (RatingDTO ratingDTO : ratingDTOList) {
            Rating rating = ratingDtoToRating(ratingDTO);
            ratingList.add(rating);
        }
        return ratingList;
    }
}
