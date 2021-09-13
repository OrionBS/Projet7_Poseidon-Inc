package fr.orionbs.services;

import fr.orionbs.dto.TradeDTO;

import java.util.List;

public interface TradeService {
    boolean creatingTrade(TradeDTO tradeDTO);

    TradeDTO readingTrade(Integer index);

    List<TradeDTO> readingAllTrade();

    boolean updatingTrade(TradeDTO tradeDTO);

    boolean deletingTrade(Integer index);
}
