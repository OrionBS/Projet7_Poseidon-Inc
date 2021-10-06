package fr.orionbs.mappers;

import fr.orionbs.dtos.TradeDTO;
import fr.orionbs.models.Trade;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TradeMapper {

    public TradeDTO tradeToTradeDTO(Trade trade) {
        TradeDTO tradeDTO = new TradeDTO(trade.getId(), trade.getAccount(), trade.getType(), trade.getBuyQuantity());
        return tradeDTO;
    }

    public Trade tradeDtoToTrade(TradeDTO tradeDTO) {
        Trade trade = new Trade();
        trade.setId(tradeDTO.getId());
        trade.setAccount(tradeDTO.getAccount());
        trade.setType(tradeDTO.getType());
        trade.setBuyQuantity(tradeDTO.getBuyQuantity());
        return trade;
    }

    public List<TradeDTO> tradeToTradeDTOList(List<Trade> tradeList) {
        List<TradeDTO> tradeDTOList = new ArrayList<>();
        for (Trade trade : tradeList) {
            TradeDTO tradeDTO = tradeToTradeDTO(trade);
            tradeDTOList.add(tradeDTO);
        }
        return tradeDTOList;
    }

    public List<Trade> tradeDtoToTradeList(List<TradeDTO> tradeDTOList) {
        List<Trade> tradeList = new ArrayList<>();
        for (TradeDTO tradeDTO : tradeDTOList) {
            Trade trade = tradeDtoToTrade(tradeDTO);
            tradeList.add(trade);
        }
        return tradeList;
    }
}
