package fr.orionbs.ApplicationTest.servicesTest;

import fr.orionbs.dtos.TradeDTO;
import fr.orionbs.models.Trade;
import fr.orionbs.repositories.TradeRepository;
import fr.orionbs.services.impl.TradeServiceImpl;
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
public class TradeServiceTest {

    @InjectMocks
    private TradeServiceImpl tradeService;

    @Mock
    TradeRepository tradeRepository;

    @Test
    public void testCreatingTrade() {
        //GIVEN
        TradeDTO tradeDTO = new TradeDTO(1, "AccountTest", "TypeTest", 10.0);
        Trade trade = new Trade();
        trade.setId(1);
        trade.setAccount("AccountTest");
        trade.setType("TypeTest");
        trade.setBuyQuantity(10.0);

        when(tradeRepository.save(any(Trade.class))).thenReturn(trade);

        //WHEN
        tradeService.creatingTrade(tradeDTO);

        //THEN
        verify(tradeRepository, Mockito.times(1)).save(any(Trade.class));
    }

    @Test
    public void testCreatingEmptyTrade() {
        //GIVEN

        //WHEN
        tradeService.creatingTrade(null);

        //THEN
        verify(tradeRepository, Mockito.times(0)).save(new Trade());
    }

    @Test
    public void testReadingTrade() {
        //GIVEN
        Trade trade = new Trade();
        trade.setId(1);
        trade.setAccount("AccountTest");
        trade.setType("TypeTest");
        trade.setBuyQuantity(10.0);

        when(tradeRepository.getById(1)).thenReturn(trade);

        //WHEN
        tradeService.readingTrade(1);

        //THEN
        verify(tradeRepository, Mockito.times(1)).getById(1);
    }

    @Test
    public void testReadingNotFoundTrade() {
        //GIVEN

        //WHEN
        tradeService.readingTrade(anyInt());

        //THEN
        verify(tradeRepository, Mockito.times(0)).getById(1);
    }

    @Test
    public void testReadingAllTrade() {
        //GIVEN
        List<Trade> tradeList = new ArrayList<>();

        when(tradeRepository.findAll()).thenReturn(tradeList);

        //WHEN
        tradeService.readingAllTrade();

        //THEN
        verify(tradeRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testUpdatingTrade() {
        //GIVEN
        TradeDTO tradeDTO = new TradeDTO(1, "AccountTestUpdated", "TypeTestUpdated", 10.0);
        Trade trade = new Trade();
        trade.setId(1);
        trade.setAccount("AccountTestUpdated");
        trade.setType("TypeTestUpdated");
        trade.setBuyQuantity(10.0);

        Optional<Trade> tradeOptional = Optional.of(trade);

        when(tradeRepository.findById(1)).thenReturn(tradeOptional);
        when(tradeRepository.save(any(Trade.class))).thenReturn(trade);

        //WHEN
        tradeService.updatingTrade(tradeDTO);

        //THEN
        verify(tradeRepository, Mockito.times(1)).findById(1);
        verify(tradeRepository, Mockito.times(1)).save(trade);
    }

    @Test
    public void testUpdatingEmptyTrade() {
        //GIVEN

        //WHEN
        tradeService.updatingTrade(null);

        //THEN
        verify(tradeRepository, Mockito.times(0)).save(new Trade());
    }

    @Test
    public void testUpdatingNotFoundTrade() {
        //GIVEN
        TradeDTO tradeDTO = new TradeDTO(1, "AccountTestUpdated", "TypeTestUpdated", 10.0);

        when(tradeRepository.findById(1)).thenReturn(null);

        //WHEN
        tradeService.updatingTrade(tradeDTO);

        //THEN
        verify(tradeRepository, Mockito.times(1)).findById(1);
        verify(tradeRepository, Mockito.times(0)).save(new Trade());
    }

    @Test
    public void testDeletingTrade() {
        //GIVEN
        Trade trade = new Trade();
        trade.setId(1);
        trade.setAccount("AccountTestUpdated");
        trade.setType("TypeTestUpdated");
        trade.setBuyQuantity(10.0);

        Optional<Trade> tradeOptional = Optional.of(trade);

        when(tradeRepository.findById(1)).thenReturn(tradeOptional);

        //WHEN
        tradeService.deletingTrade(1);

        //THEN
        verify(tradeRepository, Mockito.times(1)).deleteById(1);
    }

    @Test
    public void testDeletingNotFoundTrade() {
        //GIVEN
        when(tradeRepository.findById(1)).thenReturn(null);

        //WHEN
        tradeService.deletingTrade(1);

        //THEN
        verify(tradeRepository, Mockito.times(1)).findById(1);
        verify(tradeRepository, Mockito.times(0)).deleteById(1);

    }
}
