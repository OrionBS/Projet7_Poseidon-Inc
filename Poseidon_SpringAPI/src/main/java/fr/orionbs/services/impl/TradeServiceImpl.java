package fr.orionbs.services.impl;

import fr.orionbs.dtos.TradeDTO;
import fr.orionbs.mappers.TradeMapper;
import fr.orionbs.models.Trade;
import fr.orionbs.repositories.TradeRepository;
import fr.orionbs.services.TradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class TradeServiceImpl implements TradeService {

    private final TradeRepository tradeRepository;
    private final TradeMapper tradeMapper;

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

        log.info("Creating Trade, {}", tradeDTO);
        tradeRepository.save(tradeMapper.tradeDtoToTrade(tradeDTO));
        return true;
    }

    @Override
    public TradeDTO readingTrade(Integer index) {
        log.info("Reading Trade Id {}", index);
        Trade trade = tradeRepository.getById(index);
        return tradeMapper.tradeToTradeDTO(trade);
    }

    @Override
    public List<TradeDTO> readingAllTrade() {
        log.info("Reading All Trades");
        return tradeMapper.tradeToTradeDTOList(tradeRepository.findAll());
    }

    @Override
    public boolean updatingTrade(TradeDTO tradeDTO) {
        if (tradeDTO == null) {
            log.info("Trade is empty");
            return false;
        }

        if (tradeRepository.findById(tradeDTO.getId()) == null) {
            log.info("Trade doesn't exist");
            return false;
        }

        Trade trade = tradeMapper.tradeDtoToTrade(tradeDTO);
        log.info("Updating Trade, {}", tradeDTO);
        tradeRepository.save(trade);
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
