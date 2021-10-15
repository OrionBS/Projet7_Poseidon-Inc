package fr.orionbs.ApplicationTest.unitTests.servicesTest;

import fr.orionbs.dtos.RatingDTO;
import fr.orionbs.models.Rating;
import fr.orionbs.repositories.RatingRepository;
import fr.orionbs.services.impl.RatingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RatingServiceTest {

    @InjectMocks
    private RatingServiceImpl ratingService;

    @Mock
    RatingRepository ratingRepository;

    @Test
    public void testCreatingRating() {
        //GIVEN
        RatingDTO ratingDTO = new RatingDTO(null,"MoodysTest","SAndPRatingTest","FitchTest",12);
        Rating rating = new Rating();
        rating.setId(null);
        rating.setMoodysRating("MoodysTest");
        rating.setSAndPRating("SAndPRatingTest");
        rating.setFitchRating("FitchTest");
        rating.setOrderNumber(12);

        when(ratingRepository.save(any(Rating.class))).thenReturn(rating);

        //WHEN
        ratingService.creatingRating(ratingDTO);

        //THEN
        verify(ratingRepository, Mockito.times(1)).save(any(Rating.class));
    }

    @Test
    public void testCreatingEmptyRating() {
        //GIVEN

        //WHEN
        ratingService.creatingRating(null);

        //THEN
        verify(ratingRepository, Mockito.times(0)).save(new Rating());
    }

    @Test
    public void testReadingRating() {
        //GIVEN
        Rating rating = new Rating();
        rating.setId(1);
        rating.setMoodysRating("MoodysTest");
        rating.setSAndPRating("SAndPRatingTest");
        rating.setFitchRating("FitchTest");
        rating.setOrderNumber(12);

        when(ratingRepository.getById(1)).thenReturn(rating);

        //WHEN
        ratingService.readingRating(1);

        //THEN
        verify(ratingRepository, Mockito.times(1)).getById(1);
    }

    @Test
    public void testReadingNotFoundRating() {
        //GIVEN

        //WHEN
        ratingService.readingRating(anyInt());

        //THEN
        verify(ratingRepository, Mockito.times(0)).getById(1);
    }

    @Test
    public void testReadingAllRating() {
        //GIVEN
        List<Rating> ratingList = new ArrayList<>();

        when(ratingRepository.findAll()).thenReturn(ratingList);

        //WHEN
        ratingService.readingAllRating();

        //THEN
        verify(ratingRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testUpdatingRating() {
        //GIVEN
        RatingDTO ratingDTO = new RatingDTO(1, "MoodysTestUpdated", "SAndPRatingTestUpdated", "FitchTestUpdated",12);
        Rating rating = new Rating();
        rating.setId(1);
        rating.setMoodysRating("MoodysTestUpdated");
        rating.setSAndPRating("SAndPRatingTestUpdated");
        rating.setFitchRating("FitchTestUpdated");
        rating.setOrderNumber(12);

        Optional<Rating> ratingOptional = Optional.of(rating);

        when(ratingRepository.findById(1)).thenReturn(ratingOptional);
        when(ratingRepository.save(any(Rating.class))).thenReturn(rating);

        //WHEN
        ratingService.updatingRating(ratingDTO);

        //THEN
        verify(ratingRepository, Mockito.times(1)).findById(1);
        verify(ratingRepository, Mockito.times(1)).save(rating);
    }

    @Test
    public void testUpdatingEmptyRating() {
        //GIVEN

        //WHEN
        ratingService.updatingRating(null);

        //THEN
        verify(ratingRepository, Mockito.times(0)).save(new Rating());
    }

    @Test
    public void testUpdatingNotFoundRating() {
        //GIVEN
        RatingDTO ratingDTO = new RatingDTO(1, "MoodysTestUpdated", "SAndPRatingTestUpdated", "FitchTestUpdated",12);

        when(ratingRepository.findById(1)).thenReturn(null);

        //WHEN
        ratingService.updatingRating(ratingDTO);

        //THEN
        verify(ratingRepository, Mockito.times(1)).findById(1);
        verify(ratingRepository, Mockito.times(0)).save(new Rating());
    }

    @Test
    public void testDeletingRating() {
        //GIVEN
        Rating rating = new Rating();
        rating.setId(1);
        rating.setMoodysRating("MoodysTest");
        rating.setSAndPRating("SAndPRatingTest");
        rating.setFitchRating("FitchTest");
        rating.setOrderNumber(12);

        Optional<Rating> ratingOptional = Optional.of(rating);

        when(ratingRepository.findById(1)).thenReturn(ratingOptional);

        //WHEN
        ratingService.deletingRating(1);

        //THEN
        verify(ratingRepository, Mockito.times(1)).deleteById(1);
    }

    @Test
    public void testDeletingNotFoundRating() {
        //GIVEN
        when(ratingRepository.findById(1)).thenReturn(null);

        //WHEN
        ratingService.deletingRating(1);

        //THEN
        verify(ratingRepository, Mockito.times(1)).findById(1);
        verify(ratingRepository, Mockito.times(0)).deleteById(1);

    }
}
