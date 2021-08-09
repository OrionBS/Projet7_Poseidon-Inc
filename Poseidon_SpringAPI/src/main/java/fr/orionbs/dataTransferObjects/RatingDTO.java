package fr.orionbs.dataTransferObjects;

import fr.orionbs.models.Rating;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class RatingDTO {
    private Integer id;
    private String moodysRating;
    private String sAndPRating;
    private String fitchRating;
    private Integer orderNumber;

    public RatingDTO ratingToRatingDTO(Rating rating) {
        return new RatingDTO(rating.getId(), rating.getMoodysRating(), rating.getSAndPRating(), rating.getFitchRating(), rating.getOrderNumber());
    }

    public Rating ratingDtoToRating(RatingDTO ratingDTO) {
        return Rating.builder().id(ratingDTO.getId()).moodysRating(ratingDTO.getMoodysRating()).sAndPRating(ratingDTO.getSAndPRating()).fitchRating(ratingDTO.getFitchRating()).orderNumber(ratingDTO.getOrderNumber()).build();
    }

    public List<RatingDTO> ratingToRatingDTOList(List<Rating> ratingList) {
        List<RatingDTO> ratingDTOList = new ArrayList<>();
        for (Rating rating : ratingList) {
            RatingDTO ratingDTO = new RatingDTO(rating.getId(), rating.getMoodysRating(), rating.getSAndPRating(), rating.getFitchRating(), rating.getOrderNumber());
            ratingDTOList.add(ratingDTO);
        }
        return ratingDTOList;
    }

    public List<Rating> ratingDtoToRatingList(List<RatingDTO> ratingDTOList) {
        List<Rating> ratingList = new ArrayList<>();
        for (RatingDTO ratingDTO : ratingDTOList) {
            Rating rating = Rating.builder().id(ratingDTO.getId()).moodysRating(ratingDTO.getMoodysRating()).sAndPRating(ratingDTO.getSAndPRating()).fitchRating(ratingDTO.getFitchRating()).orderNumber(ratingDTO.getOrderNumber()).build();
            ratingList.add(rating);
        }
        return ratingList;
    }
}
