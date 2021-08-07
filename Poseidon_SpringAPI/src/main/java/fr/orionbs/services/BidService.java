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

    public boolean creatingBid(BidDTO bidDTO) {

        if (bidDTO == null) {
            log.info("Bid's empty");
            return false;
        }

        log.info("Creating Bid, {}", bidDTO);
        Bid bid = bidDTO.bidDtoToBid(bidDTO);
        bidRepository.save(bid);
        return true;
    }

    public BidDTO readingBid(Integer index) {

        log.info("Reading Bid Id {}", index);
        Bid bid = bidRepository.getById(index);
        return new BidDTO().bidToBidDto(bid);
    }

    public List<BidDTO> readingAllBid() {

        log.info("Reading All Bids");
        BidDTO bidDTO = BidDTO.builder().build();
        return bidDTO.bidToBidDtoList(bidRepository.findAll());
    }

    public boolean updatingBid(BidDTO bidDTO) {

        if (bidDTO == null) {
            log.info("Bid's empty");
            return false;
        }

        if (bidRepository.findById(bidDTO.getId()) == null) {
            log.info("Bid doesn't exist");
            return false;
        }

        Bid bid = bidDTO.bidDtoToBid(bidDTO);
        log.info("Updating Bid, {}", bidDTO);
        bidRepository.save(bid);
        return true;
    }

    public boolean deletingBid(Integer index) {

        if (bidRepository.findById(index) == null) {
            log.info("Bid doesn't exist");
            return false;
        }
        bidRepository.deleteById(index);
        log.info("Deleting Bid {}", index);
        return true;
    }
}
