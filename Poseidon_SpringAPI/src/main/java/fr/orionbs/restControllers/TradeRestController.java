package fr.orionbs.restControllers;

import fr.orionbs.dtos.TradeDTO;
import fr.orionbs.services.TradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/trade")
public class TradeRestController {

    private final TradeService tradeService;

    public TradeRestController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping
    public ResponseEntity<Boolean> creatingTrade(@RequestBody TradeDTO tradeDTO) {

        boolean answer = tradeService.creatingTrade(tradeDTO);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/{index}")
    public ResponseEntity<TradeDTO> readingTrade(@PathVariable(value = "index") Integer index) {

        TradeDTO tradeDTO = tradeService.readingTrade(index);

        if (tradeDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tradeDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TradeDTO>> readingAllTrade() {

        List<TradeDTO> tradeDTOList = tradeService.readingAllTrade();

        return new ResponseEntity<>(tradeDTOList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Boolean> updatingTrade(@RequestBody TradeDTO tradeDTO) {

        boolean answer = tradeService.updatingTrade(tradeDTO);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deletingTrade(@RequestParam(value = "index") Integer index) {

        boolean answer = tradeService.deletingTrade(index);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
