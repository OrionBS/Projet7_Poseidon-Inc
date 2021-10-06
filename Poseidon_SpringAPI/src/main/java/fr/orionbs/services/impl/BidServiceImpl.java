package fr.orionbs.services.impl;

import fr.orionbs.dtos.BidDTO;
import fr.orionbs.mappers.BidMapper;
import fr.orionbs.models.Bid;
import fr.orionbs.repositories.BidRepository;
import fr.orionbs.services.BidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    public boolean creatingBid(BidDTO bidDTO) {
        if (bidDTO == null) {
            log.info("Bid's empty");
            return false;
        }
        BidMapper bidMapper = new BidMapper();

        log.info("Receiving BidDTO, {}", bidDTO);
        Bid bid = bidMapper.bidDtoToBid(bidDTO);
        log.info("Creating Bid, {}", bid);
        bidRepository.save(bid);
        return true;
    }

    @Override
    public BidDTO readingBid(Integer index) {
        log.info("Reading Bid Id {}", index);
        Bid bid = bidRepository.getById(index);
        return bidMapper.bidToBidDto(bid);
    }

    @Override
    public List<BidDTO> readingAllBid() {
        log.info("Reading All Bids");
        return bidMapper.bidToBidDtoList(bidRepository.findAll());
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

        Bid bid = bidMapper.bidDtoToBid(bidDTO);
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
