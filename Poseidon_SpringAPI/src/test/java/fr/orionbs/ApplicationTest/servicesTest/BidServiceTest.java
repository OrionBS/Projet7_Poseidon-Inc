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

import static org.mockito.ArgumentMatchers.*;
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
        BidDTO bidDTO = new BidDTO(1, "AccountTest", "TypeTest", 10.0);
        Bid bid = new Bid();
        bid.setId(1);
        bid.setAccount("AccountTest");
        bid.setType("TypeTest");
        bid.setBidQuantity(10.0);

        when(bidRepository.save(any(Bid.class))).thenReturn(bid);

        //WHEN
        bidService.creatingBid(bidDTO);

        //THEN
        verify(bidRepository, Mockito.times(1)).save(any(Bid.class));
    }

}
