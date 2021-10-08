package fr.orionbs.ApplicationTest.servicesTest;

import fr.orionbs.dtos.BidDTO;
import fr.orionbs.models.Bid;
import fr.orionbs.repositories.BidRepository;
import fr.orionbs.services.impl.BidServiceImpl;
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
public class BidServiceTest {

    @InjectMocks
    private BidServiceImpl bidService;

    @Mock
    BidRepository bidRepository;

    @Test
    public void testCreatingBid() {
        //GIVEN
        BidDTO bidDTO = new BidDTO(null,"AccountTest", "TypeTest", 10.0);
        Bid bid = new Bid();
        bid.setAccount("AccountTest");
        bid.setType("TypeTest");
        bid.setBidQuantity(10.0);

        when(bidRepository.save(any(Bid.class))).thenReturn(bid);

        //WHEN
        bidService.creatingBid(bidDTO);

        //THEN
        verify(bidRepository, Mockito.times(1)).save(any(Bid.class));
    }

    @Test
    public void testCreatingEmptyBid() {
        //GIVEN

        //WHEN
        bidService.creatingBid(null);

        //THEN
        verify(bidRepository, Mockito.times(0)).save(new Bid());
    }

    @Test
    public void testReadingBid() {
        //GIVEN
        Bid bid = new Bid();
        bid.setId(1);
        bid.setAccount("AccountTest");
        bid.setType("TypeTest");
        bid.setBidQuantity(10.0);

        when(bidRepository.getById(1)).thenReturn(bid);

        //WHEN
        bidService.readingBid(1);

        //THEN
        verify(bidRepository, Mockito.times(1)).getById(1);
    }

    @Test
    public void testReadingNotFoundBid() {
        //GIVEN

        //WHEN
        bidService.readingBid(anyInt());

        //THEN
        verify(bidRepository, Mockito.times(0)).getById(1);
    }

    @Test
    public void testReadingAllBid() {
        //GIVEN
        List<Bid> bidList = new ArrayList<>();

        when(bidRepository.findAll()).thenReturn(bidList);

        //WHEN
        bidService.readingAllBid();

        //THEN
        verify(bidRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testUpdatingBid() {
        //GIVEN
        BidDTO bidDTO = new BidDTO(1, "AccountTestUpdated", "TypeTestUpdated", 10.0);
        Bid bid = new Bid();
        bid.setId(1);
        bid.setAccount("AccountTestUpdated");
        bid.setType("TypeTestUpdated");
        bid.setBidQuantity(10.0);

        Optional<Bid> bidOptional = Optional.of(bid);

        when(bidRepository.findById(1)).thenReturn(bidOptional);
        when(bidRepository.save(any(Bid.class))).thenReturn(bid);

        //WHEN
        bidService.updatingBid(bidDTO);

        //THEN
        verify(bidRepository, Mockito.times(1)).findById(1);
        verify(bidRepository, Mockito.times(1)).save(bid);
    }

    @Test
    public void testUpdatingEmptyBid() {
        //GIVEN

        //WHEN
        bidService.updatingBid(null);

        //THEN
        verify(bidRepository, Mockito.times(0)).save(new Bid());
    }

    @Test
    public void testUpdatingNotFoundBid() {
        //GIVEN
        BidDTO bidDTO = new BidDTO(1, "AccountTestUpdated", "TypeTestUpdated", 10.0);

        when(bidRepository.findById(1)).thenReturn(null);

        //WHEN
        bidService.updatingBid(bidDTO);

        //THEN
        verify(bidRepository, Mockito.times(1)).findById(1);
        verify(bidRepository, Mockito.times(0)).save(new Bid());
    }

    @Test
    public void testDeletingBid() {
        //GIVEN
        Bid bid = new Bid();
        bid.setId(1);
        bid.setAccount("AccountTestUpdated");
        bid.setType("TypeTestUpdated");
        bid.setBidQuantity(10.0);

        Optional<Bid> bidOptional = Optional.of(bid);

        when(bidRepository.findById(1)).thenReturn(bidOptional);

        //WHEN
        bidService.deletingBid(1);

        //THEN
        verify(bidRepository, Mockito.times(1)).deleteById(1);
    }

    @Test
    public void testDeletingNotFoundBid() {
        //GIVEN
        when(bidRepository.findById(1)).thenReturn(null);

        //WHEN
        bidService.deletingBid(1);

        //THEN
        verify(bidRepository, Mockito.times(1)).findById(1);
        verify(bidRepository, Mockito.times(0)).deleteById(1);

    }

}
