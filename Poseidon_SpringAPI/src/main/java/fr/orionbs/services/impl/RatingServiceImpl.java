package fr.orionbs.services.impl;

import fr.orionbs.dtos.RatingDTO;
import fr.orionbs.mappers.BidMapper;
import fr.orionbs.mappers.RatingMapper;
import fr.orionbs.models.Bid;
import fr.orionbs.models.Rating;
import fr.orionbs.repositories.RatingRepository;
import fr.orionbs.services.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private RatingMapper ratingMapper;

    public RatingServiceImpl(RatingRepository ratingRepository, RatingMapper ratingMapper) {
        this.ratingRepository = ratingRepository;
        this.ratingMapper = ratingMapper;
    }

    @Override
    public boolean creatingRating(RatingDTO ratingDTO) {
        if (ratingDTO == null) {
            log.info("Rating is empty");
            return false;
        }
        ratingMapper = new RatingMapper();

        log.info("Creating Rating, {}", ratingDTO);
        ratingRepository.save(ratingMapper.ratingDtoToRating(ratingDTO));
        return true;
    }

    @Override
    public RatingDTO readingRating(Integer index) {
        log.info("Reading Rating Id {}", index);
        Rating rating = ratingRepository.getById(index);
        if(rating == null) {
            log.warn("Not found Rating Id {}", index);
            return null;
        }
        log.info("Rating found {}", rating);
        ratingMapper = new RatingMapper();
        return ratingMapper.ratingToRatingDTO(rating);
    }

    @Override
    public List<RatingDTO> readingAllRating() {
        log.info("Reading All Ratings");
        ratingMapper = new RatingMapper();
        return ratingMapper.ratingToRatingDTOList(ratingRepository.findAll());
    }

    @Override
    public boolean updatingRating(RatingDTO ratingDTO) {
        if (ratingDTO == null) {
            log.info("Rating is empty");
            return false;
        }

        Optional<Rating> isRatingPresent = ratingRepository.findById(ratingDTO.getId());

        if (isRatingPresent == null) {
            log.info("Rating doesn't exist");
            return false;
        }

        Rating oldRating = isRatingPresent.get();

        ratingMapper = new RatingMapper();
        Rating rating = ratingMapper.ratingDtoToRating(ratingDTO);

        oldRating.setMoodysRating(rating.getMoodysRating());
        oldRating.setSAndPRating(rating.getSAndPRating());
        oldRating.setFitchRating(rating.getFitchRating());
        oldRating.setOrderNumber(rating.getOrderNumber());

        log.info("Updating Rating, {}", oldRating);
        ratingRepository.save(oldRating);
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
