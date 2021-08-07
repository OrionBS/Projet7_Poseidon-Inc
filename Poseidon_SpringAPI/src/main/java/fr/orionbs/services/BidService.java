package fr.orionbs.services;

import fr.orionbs.dataTransferObjects.BidDTO;
import fr.orionbs.models.Bid;
import fr.orionbs.repositories.BidRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class BidService {

    @Autowired
    BidRepository bidRepository;

    public void addBid(BidDTO bidDTO) {

        log.info("Bid's Creation, {}", bidDTO);
        Bid bid = bidDTO.bidDtoToBid(bidDTO);

    }

    public BidDTO getOneBid(Integer index) {

        log.info("Fetch Bid Id {}", index);
        Bid bid = bidRepository.getById(index);
        return new BidDTO().bidToBidDto(bid);

    }

    public void updateBid(BidDTO bidDTO) {

        log.info("Update Bid, {}", bidDTO);
        Bid bid = bidDTO.bidDtoToBid(bidDTO);
        bidRepository.save(bid);

    }

    public List<BidDTO> getAllBids() {

        log.info("Fetch All Bids");
        BidDTO bidDTO = BidDTO.builder().build();
        return bidDTO.bidToBidDtoList(bidRepository.findAll());

    }
}
