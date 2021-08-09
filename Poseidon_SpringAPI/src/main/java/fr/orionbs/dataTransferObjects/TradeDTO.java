package fr.orionbs.dataTransferObjects;

import fr.orionbs.models.Trade;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class TradeDTO {
    private Integer id;
    private String account;
    private String type;
    private Double buyQuantity;

    public TradeDTO tradeToTradeDTO(Trade trade) {
        return new TradeDTO(trade.getId(), trade.getAccount(), trade.getType(), trade.getBuyQuantity());
    }

    public Trade tradeDtoToTrade(TradeDTO tradeDTO) {
        return Trade.builder().id(tradeDTO.getId()).account(tradeDTO.getAccount()).type(tradeDTO.getType()).buyQuantity(tradeDTO.getBuyQuantity()).build();
    }

    public List<TradeDTO> tradeToTradeDTOList(List<Trade> tradeList) {
        List<TradeDTO> tradeDTOList = new ArrayList<>();
        for (Trade trade : tradeList) {
            TradeDTO tradeDTO = new TradeDTO(trade.getId(), trade.getAccount(), trade.getType(), trade.getBuyQuantity());
            tradeDTOList.add(tradeDTO);
        }
        return tradeDTOList;
    }

    public List<Trade> tradeDtoToTradeList(List<TradeDTO> tradeDTOList) {
        List<Trade> tradeList = new ArrayList<>();
        for (TradeDTO tradeDTO : tradeDTOList) {
            Trade trade = Trade.builder().id(tradeDTO.getId()).account(tradeDTO.getAccount()).type(tradeDTO.getType()).buyQuantity(tradeDTO.getBuyQuantity()).build();
            tradeList.add(trade);
        }
        return tradeList;
    }
}
