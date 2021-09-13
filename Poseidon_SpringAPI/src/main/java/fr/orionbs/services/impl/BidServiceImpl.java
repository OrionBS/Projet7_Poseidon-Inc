package fr.orionbs.services.impl;

import fr.orionbs.dtos.BidDTO;
import fr.orionbs.models.Bid;
import fr.orionbs.repositories.BidRepository;
import fr.orionbs.services.BidService;
import fr.orionbs.services.MapperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class BidServiceImpl implements BidService {

    private BidRepository bidRepository;
    private MapperService mapperService;

    public BidServiceImpl(BidRepository bidRepository,MapperService mapperService) {
        this.bidRepository = bidRepository;
        this.mapperService = mapperService;
    }

    @Override
    public boolean creatingBid(BidDTO bidDTO) {
        if (bidDTO == null) {
            log.info("Bid's empty");
            return false;
        }

        log.info("Creating Bid, {}", bidDTO);
        Bid bid = mapperService.bidDtoToBid(bidDTO);
        bidRepository.save(bid);
        return true;
    }

    @Override
    public BidDTO readingBid(Integer index) {
        log.info("Reading Bid Id {}", index);
        Bid bid = bidRepository.getById(index);
        return mapperService.bidToBidDto(bid);
    }

    @Override
    public List<BidDTO> readingAllBid() {
        log.info("Reading All Bids");
        return mapperService.bidToBidDtoList(bidRepository.findAll());
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

        Bid bid = mapperService.bidDtoToBid(bidDTO);
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
