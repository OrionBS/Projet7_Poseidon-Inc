package fr.orionbs.services.impl;

import com.sun.istack.NotNull;
import fr.orionbs.dtos.BidDTO;
import fr.orionbs.mappers.BidMapper;
import fr.orionbs.models.Bid;
import fr.orionbs.repositories.BidRepository;
import fr.orionbs.services.BidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class BidServiceImpl implements BidService {

    private BidRepository bidRepository;
    private BidMapper bidMapper;

    public BidServiceImpl(BidRepository bidRepository, BidMapper bidMapper) {
        this.bidRepository = bidRepository;
        this.bidMapper = bidMapper;
    }

    @Override
    public boolean creatingBid(@NotNull BidDTO bidDTO) {
        if (bidDTO == null) {
            log.error("Bid's empty");
            return false;
        }
        if (bidDTO.getId() != null) {
            log.error("Warning Id {} isn't null.", bidDTO.getId());
            return false;
        }
        bidMapper = new BidMapper();

        log.debug("Receiving BidDTO, {}", bidDTO);
        Bid bid = bidMapper.bidDtoToBid(bidDTO);
        log.info("Creating Bid, {}", bid);
        bidRepository.save(bid);
        return true;
    }

    @Override
    public BidDTO readingBid(Integer index) {
        log.info("Reading Bid Id {}", index);
        Bid bid = bidRepository.getById(index);
        if(bid == null) {
            log.warn("Not found Bid Id {}", index);
            return null;
        }
        log.info("Bid found {}", bid);
        bidMapper = new BidMapper();
        return bidMapper.bidToBidDto(bid);
    }

    @Override
    public List<BidDTO> readingAllBid() {
        log.info("Reading All Bids");
        bidMapper = new BidMapper();
        return bidMapper.bidToBidDtoList(bidRepository.findAll());
    }

    @Override
    public boolean updatingBid(BidDTO bidDTO) {
        if (bidDTO == null) {
            log.info("Bid's empty");
            return false;
        }

        Optional<Bid> isBidPresent = bidRepository.findById(bidDTO.getId());

        if (isBidPresent == null) {
            log.error("Bid doesn't exist");
            return false;
        }

        Bid oldBid = isBidPresent.get();

        bidMapper = new BidMapper();
        Bid bid = bidMapper.bidDtoToBid(bidDTO);

        oldBid.setAccount(bid.getAccount());
        oldBid.setType(bid.getType());
        oldBid.setBidQuantity(bid.getBidQuantity());

        log.info("Updating Bid, {}", oldBid);
        bidRepository.save(oldBid);
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
