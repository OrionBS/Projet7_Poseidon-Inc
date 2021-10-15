package fr.orionbs.ApplicationTest.unitTests.restControllersTest;

import fr.orionbs.dtos.TradeDTO;
import fr.orionbs.dtos.TradeDTO;
import fr.orionbs.restControllers.TradeRestController;
import fr.orionbs.services.impl.TradeServiceImpl;
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
public class TradeRestControllerTest {

    @InjectMocks
    TradeRestController tradeRestController;

    @Mock
    TradeServiceImpl tradeService;

    @Test
    public void testCreatingTrade() {
        //GIVEN
        TradeDTO tradeDTO = new TradeDTO(0, "AccountTest", "TypeTest", 10.0);
        when(tradeService.creatingTrade(any(TradeDTO.class))).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = tradeRestController.creatingTrade(tradeDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.CREATED));
        verify(tradeService, Mockito.times(1)).creatingTrade(tradeDTO);
    }

    @Test
    public void testCreatingTradeIdFilled() {
        //GIVEN
        TradeDTO tradeDTO = new TradeDTO(1, "AccountTest", "TypeTest", 10.0);
        when(tradeService.creatingTrade(any(TradeDTO.class))).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = tradeRestController.creatingTrade(tradeDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.BAD_REQUEST));
        verify(tradeService, Mockito.times(1)).creatingTrade(tradeDTO);
    }

    @Test
    public void testReadingTrade() {
        //GIVEN
        TradeDTO tradeDTO = new TradeDTO(1, "AccountTest", "TypeTest", 10.0);
        when(tradeService.readingTrade(1)).thenReturn(tradeDTO);

        //WHEN
        ResponseEntity<TradeDTO> answer = tradeRestController.readingTrade(1);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(tradeDTO, HttpStatus.OK));
        verify(tradeService, Mockito.times(1)).readingTrade(1);
    }

    @Test
    public void testReadingNullIdTrade() {
        //GIVEN
        when(tradeService.readingTrade(null)).thenReturn(null);

        //WHEN
        ResponseEntity<TradeDTO> answer = tradeRestController.readingTrade(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        verify(tradeService, Mockito.times(1)).readingTrade(null);
    }

    @Test
    public void testReadingAllTrade() {
        //GIVEN
        TradeDTO tradeDTO = new TradeDTO(1, "AccountTest", "TypeTest", 10.0);
        TradeDTO tradeDTO2 = new TradeDTO(2, "AccountTest2", "TypeTest2", 12.0);
        when(tradeService.readingAllTrade()).thenReturn(Arrays.asList(tradeDTO, tradeDTO2));

        //WHEN
        ResponseEntity<List<TradeDTO>> answer = tradeRestController.readingAllTrade();

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(Arrays.asList(tradeDTO, tradeDTO2), HttpStatus.OK));
        verify(tradeService, Mockito.times(1)).readingAllTrade();
    }

    @Test
    public void testUpdatingTrade() {
        //GIVEN
        TradeDTO tradeDTO = new TradeDTO(1, "AccountTest", "TypeTest", 10.0);
        when(tradeService.updatingTrade(tradeDTO)).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = tradeRestController.updatingTrade(tradeDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.OK));
        verify(tradeService, Mockito.times(1)).updatingTrade(tradeDTO);
    }

    @Test
    public void testUpdatingNotFoundTrade() {
        //GIVEN
        when(tradeService.updatingTrade(null)).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = tradeRestController.updatingTrade(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.NOT_FOUND));
        verify(tradeService, Mockito.times(1)).updatingTrade(null);
    }

    @Test
    public void testDeletingTrade() {
        //GIVEN
        when(tradeService.deletingTrade(1)).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = tradeRestController.deletingTrade(1);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.OK));
        verify(tradeService, Mockito.times(1)).deletingTrade(1);
    }

    @Test
    public void testDeletingNotFoundTrade() {
        //GIVEN
        when(tradeService.deletingTrade(null)).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = tradeRestController.deletingTrade(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.NOT_FOUND));
        verify(tradeService, Mockito.times(1)).deletingTrade(null);
    }
    
}
