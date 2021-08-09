package fr.orionbs.controllers;

import fr.orionbs.dataTransferObjects.TradeDTO;
import fr.orionbs.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TradeController {

    @Autowired
    TradeService tradeService;

    @PostMapping(path = "/trade/creating")
    public boolean creatingTrade(TradeDTO tradeDTO) {
        boolean answer = tradeService.creatingTrade(tradeDTO);
        if (answer) {
            return true;
        }
        return false;
    }

    @GetMapping(path = "/trade/reading")
    public TradeDTO readingTrade(Integer index) {
        return tradeService.readingTrade(index);
    }

    @GetMapping(path = "/trade/readingAll")
    public List<TradeDTO> readingAllTrade() {
        return tradeService.readingAllTrade();
    }

    @PutMapping(path = "/trade/updating")
    public boolean updatingTrade(TradeDTO tradeDTO) {
        boolean answer = tradeService.updatingTrade(tradeDTO);
        if (answer) {
            return true;
        }
        return false;
    }

    @DeleteMapping(path = "/trade/deleting")
    public boolean deletingTrade(Integer index) {
        boolean answer = tradeService.deletingTrade(index);
        if (answer) {
            return true;
        }
        return false;
    }
}
