package fr.orionbs.services;

import fr.orionbs.dtos.RatingDTO;

import java.util.List;

public interface RatingService {
    boolean creatingRating(RatingDTO ratingDTO);
    RatingDTO readingRating(Integer index);
    List<RatingDTO> readingAllRating();
    boolean updatingRating(RatingDTO ratingDTO);
    boolean deletingRating(Integer index);
}
