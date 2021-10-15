package fr.orionbs.ApplicationTest.unitTests.restControllersTest;

import fr.orionbs.dtos.BidDTO;
import fr.orionbs.restControllers.BidRestController;
import fr.orionbs.services.impl.BidServiceImpl;
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
public class BidRestControllerTest {

    @InjectMocks
    BidRestController bidRestController;

    @Mock
    BidServiceImpl bidService;

    @Test
    public void testCreatingBid() {
        //GIVEN
        BidDTO bidDTO = new BidDTO(0, "AccountTest", "TypeTest", 10.0);
        when(bidService.creatingBid(any(BidDTO.class))).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = bidRestController.creatingBid(bidDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.CREATED));
        verify(bidService, Mockito.times(1)).creatingBid(bidDTO);
    }

    @Test
    public void testCreatingBidIdFilled() {
        //GIVEN
        BidDTO bidDTO = new BidDTO(1, "AccountTest", "TypeTest", 10.0);
        when(bidService.creatingBid(any(BidDTO.class))).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = bidRestController.creatingBid(bidDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.BAD_REQUEST));
        verify(bidService, Mockito.times(1)).creatingBid(bidDTO);
    }

    @Test
    public void testReadingBid() {
        //GIVEN
        BidDTO bidDTO = new BidDTO(1, "AccountTest", "TypeTest", 10.0);
        when(bidService.readingBid(1)).thenReturn(bidDTO);

        //WHEN
        ResponseEntity<BidDTO> answer = bidRestController.readingBid(1);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(bidDTO, HttpStatus.OK));
        verify(bidService, Mockito.times(1)).readingBid(1);
    }

    @Test
    public void testReadingNullIdBid() {
        //GIVEN
        when(bidService.readingBid(null)).thenReturn(null);

        //WHEN
        ResponseEntity<BidDTO> answer = bidRestController.readingBid(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        verify(bidService, Mockito.times(1)).readingBid(null);
    }

    @Test
    public void testReadingAllBid() {
        //GIVEN
        BidDTO bidDTO = new BidDTO(1, "AccountTest", "TypeTest", 10.0);
        BidDTO bidDTO2 = new BidDTO(2, "AccountTest2", "TypeTest2", 12.0);
        when(bidService.readingAllBid()).thenReturn(Arrays.asList(bidDTO, bidDTO2));

        //WHEN
        ResponseEntity<List<BidDTO>> answer = bidRestController.readingAllBid();

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(Arrays.asList(bidDTO, bidDTO2), HttpStatus.OK));
        verify(bidService, Mockito.times(1)).readingAllBid();
    }

    @Test
    public void testUpdatingBid() {
        //GIVEN
        BidDTO bidDTO = new BidDTO(1, "AccountTest", "TypeTest", 10.0);
        when(bidService.updatingBid(bidDTO)).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = bidRestController.updatingBid(bidDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.OK));
        verify(bidService, Mockito.times(1)).updatingBid(bidDTO);
    }

    @Test
    public void testUpdatingNotFoundBid() {
        //GIVEN
        when(bidService.updatingBid(null)).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = bidRestController.updatingBid(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.NOT_FOUND));
        verify(bidService, Mockito.times(1)).updatingBid(null);
    }

    @Test
    public void testDeletingBid() {
        //GIVEN
        when(bidService.deletingBid(1)).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = bidRestController.deletingBid(1);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.OK));
        verify(bidService, Mockito.times(1)).deletingBid(1);
    }

    @Test
    public void testDeletingNotFoundBid() {
        //GIVEN
        when(bidService.deletingBid(null)).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = bidRestController.deletingBid(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.NOT_FOUND));
        verify(bidService, Mockito.times(1)).deletingBid(null);
    }

}
