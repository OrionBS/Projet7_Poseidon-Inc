package fr.orionbs.services.impl;

import fr.orionbs.dto.BidDTO;
import fr.orionbs.models.Bid;
import fr.orionbs.repositories.BidRepository;
import fr.orionbs.services.BidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class BidServiceImpl implements BidService {

    private BidRepository bidRepository;

    public BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
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

    @Override
    public BidDTO readingBid(Integer index) {
        log.info("Reading Bid Id {}", index);
        Bid bid = bidRepository.getById(index);
        return new BidDTO().bidToBidDto(bid);
    }

    @Override
    public List<BidDTO> readingAllBid() {
        log.info("Reading All Bids");
        BidDTO bidDTO = BidDTO.builder().build();
        return bidDTO.bidToBidDtoList(bidRepository.findAll());
    }

    @Override
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

    @Override
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
