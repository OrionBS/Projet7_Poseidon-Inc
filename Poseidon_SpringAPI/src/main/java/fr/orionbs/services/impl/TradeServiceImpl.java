package fr.orionbs.services.impl;

import fr.orionbs.dtos.TradeDTO;
import fr.orionbs.mappers.TradeMapper;
import fr.orionbs.mappers.TradeMapper;
import fr.orionbs.models.Trade;
import fr.orionbs.models.Trade;
import fr.orionbs.repositories.TradeRepository;
import fr.orionbs.services.TradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class TradeServiceImpl implements TradeService {

    private final TradeRepository tradeRepository;
    private TradeMapper tradeMapper;

    public TradeServiceImpl(TradeRepository tradeRepository, TradeMapper tradeMapper) {
        this.tradeRepository = tradeRepository;
        this.tradeMapper = tradeMapper;
    }

    @Override
    public boolean creatingTrade(TradeDTO tradeDTO) {
        if (tradeDTO == null) {
            log.info("Trade is empty");
            return false;
        }

        tradeMapper = new TradeMapper();

        log.info("Creating Trade, {}", tradeDTO);
        tradeRepository.save(tradeMapper.tradeDtoToTrade(tradeDTO));
        return true;
    }

    @Override
    public TradeDTO readingTrade(Integer index) {
        log.info("Reading Trade Id {}", index);
        Trade trade = tradeRepository.getById(index);
        if(trade == null) {
            log.warn("Not found Trade Id {}", index);
            return null;
        }
        log.info("Trade found {}", trade);
        tradeMapper = new TradeMapper();
        return tradeMapper.tradeToTradeDTO(trade);
    }

    @Override
    public List<TradeDTO> readingAllTrade() {
        log.info("Reading All Trades");
        tradeMapper = new TradeMapper();
        return tradeMapper.tradeToTradeDTOList(tradeRepository.findAll());
    }

    @Override
    public boolean updatingTrade(TradeDTO tradeDTO) {
        if (tradeDTO == null) {
            log.info("Trade is empty");
            return false;
        }

        Optional<Trade> isTradePresent = tradeRepository.findById(tradeDTO.getId());

        if (isTradePresent == null) {
            log.info("Trade doesn't exist");
            return false;
        }

        Trade oldTrade = isTradePresent.get();

        tradeMapper = new TradeMapper();
        Trade trade = tradeMapper.tradeDtoToTrade(tradeDTO);

        oldTrade.setAccount(trade.getAccount());
        oldTrade.setType(trade.getType());
        oldTrade.setBuyQuantity(trade.getBuyQuantity());

        log.info("Updating Trade, {}", oldTrade);
        tradeRepository.save(oldTrade);
        return true;
    }

    @Override
    public boolean deletingTrade(Integer index) {
        if (tradeRepository.findById(index) == null) {
            log.info("Trade doesn't exist");
            return false;
        }
        tradeRepository.deleteById(index);
        log.info("Deleting Trade {}", index);
        return true;
    }
}
