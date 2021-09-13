package fr.orionbs.services.impl;

import fr.orionbs.dtos.RatingDTO;
import fr.orionbs.models.Rating;
import fr.orionbs.repositories.RatingRepository;
import fr.orionbs.services.MapperService;
import fr.orionbs.services.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Transactional
@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final MapperService mapperService;

    public RatingServiceImpl(RatingRepository ratingRepository, MapperService mapperService) {
        this.ratingRepository = ratingRepository;
        this.mapperService = mapperService;
    }

    @Override
    public boolean creatingRating(RatingDTO ratingDTO) {
        if (ratingDTO == null) {
            log.info("Rating is empty");
            return false;
        }

        log.info("Creating Rating, {}", ratingDTO);
        ratingRepository.save(mapperService.ratingDtoToRating(ratingDTO));
        return true;
    }

    @Override
    public RatingDTO readingRating(Integer index) {
        log.info("Reading Rating Id {}", index);
        Rating rating = ratingRepository.getById(index);
        return mapperService.ratingToRatingDTO(rating);
    }

    @Override
    public List<RatingDTO> readingAllRating() {
        log.info("Reading All Ratings");
        return mapperService.ratingToRatingDTOList(ratingRepository.findAll());
    }

    @Override
    public boolean updatingRating(RatingDTO ratingDTO) {
        if (ratingDTO == null) {
            log.info("Rating is empty");
            return false;
        }

        if (ratingRepository.findById(ratingDTO.getId()) == null) {
            log.info("Rating doesn't exist");
            return false;
        }

        Rating rating = mapperService.ratingDtoToRating(ratingDTO);
        log.info("Updating Rating, {}", ratingDTO);
        ratingRepository.save(rating);
        return true;
    }

    @Override
    public boolean deletingRating(Integer index) {
        if (ratingRepository.findById(index) == null) {
            log.info("Rating doesn't exist");
            return false;
        }
        ratingRepository.deleteById(index);
        log.info("Deleting Rating {}", index);
        return true;
    }
}
