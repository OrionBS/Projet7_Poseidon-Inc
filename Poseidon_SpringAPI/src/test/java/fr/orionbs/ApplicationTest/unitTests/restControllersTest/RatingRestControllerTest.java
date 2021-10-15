package fr.orionbs.ApplicationTest.unitTests.restControllersTest;

import fr.orionbs.dtos.RatingDTO;
import fr.orionbs.dtos.RatingDTO;
import fr.orionbs.restControllers.RatingRestController;
import fr.orionbs.services.impl.RatingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RatingRestControllerTest {

    @InjectMocks
    RatingRestController ratingRestController;

    @Mock
    RatingServiceImpl ratingService;

    @Test
    public void testCreatingRating() {
        //GIVEN
        RatingDTO ratingDTO = new RatingDTO(0, "moodysTest", "sAndPTest", "fitchTest", 10);
        when(ratingService.creatingRating(any(RatingDTO.class))).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = ratingRestController.creatingRating(ratingDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.CREATED));
        verify(ratingService, Mockito.times(1)).creatingRating(ratingDTO);
    }

    @Test
    public void testCreatingRatingIdFilled() {
        //GIVEN
        RatingDTO ratingDTO = new RatingDTO(1, "moodysTest", "sAndPTest", "fitchTest", 10);
        when(ratingService.creatingRating(any(RatingDTO.class))).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = ratingRestController.creatingRating(ratingDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.BAD_REQUEST));
        verify(ratingService, Mockito.times(1)).creatingRating(ratingDTO);
    }

    @Test
    public void testReadingRating() {
        //GIVEN
        RatingDTO ratingDTO = new RatingDTO(1, "moodysTest", "sAndPTest", "fitchTest", 10);
        when(ratingService.readingRating(1)).thenReturn(ratingDTO);

        //WHEN
        ResponseEntity<RatingDTO> answer = ratingRestController.readingRating(1);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(ratingDTO, HttpStatus.OK));
        verify(ratingService, Mockito.times(1)).readingRating(1);
    }

    @Test
    public void testReadingNullIdRating() {
        //GIVEN
        when(ratingService.readingRating(null)).thenReturn(null);

        //WHEN
        ResponseEntity<RatingDTO> answer = ratingRestController.readingRating(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        verify(ratingService, Mockito.times(1)).readingRating(null);
    }

    @Test
    public void testReadingAllRating() {
        //GIVEN
        RatingDTO ratingDTO = new RatingDTO(1, "moodysTest", "sAndPTest", "fitchTest", 10);
        RatingDTO ratingDTO2 = new RatingDTO(2, "moodysTest2", "sAndPTest2", "fitchTest2", 12);
        when(ratingService.readingAllRating()).thenReturn(Arrays.asList(ratingDTO, ratingDTO2));

        //WHEN
        ResponseEntity<List<RatingDTO>> answer = ratingRestController.readingAllRating();

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(Arrays.asList(ratingDTO, ratingDTO2), HttpStatus.OK));
        verify(ratingService, Mockito.times(1)).readingAllRating();
    }

    @Test
    public void testUpdatingRating() {
        //GIVEN
        RatingDTO ratingDTO = new RatingDTO(1, "moodysTest", "sAndPTest", "fitchTest", 10);
        when(ratingService.updatingRating(ratingDTO)).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = ratingRestController.updatingRating(ratingDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.OK));
        verify(ratingService, Mockito.times(1)).updatingRating(ratingDTO);
    }

    @Test
    public void testUpdatingNotFoundRating() {
        //GIVEN
        when(ratingService.updatingRating(null)).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = ratingRestController.updatingRating(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.NOT_FOUND));
        verify(ratingService, Mockito.times(1)).updatingRating(null);
    }

    @Test
    public void testDeletingRating() {
        //GIVEN
        when(ratingService.deletingRating(1)).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = ratingRestController.deletingRating(1);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.OK));
        verify(ratingService, Mockito.times(1)).deletingRating(1);
    }

    @Test
    public void testDeletingNotFoundRating() {
        //GIVEN
        when(ratingService.deletingRating(null)).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = ratingRestController.deletingRating(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.NOT_FOUND));
        verify(ratingService, Mockito.times(1)).deletingRating(null);
    }

}
