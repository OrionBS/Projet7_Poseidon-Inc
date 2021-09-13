package fr.orionbs.restControllers;

import fr.orionbs.dtos.BidDTO;
import fr.orionbs.services.BidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/bid")
public class BidRestController {

    private final BidService bidService;

    public BidRestController(BidService bidService) {
        this.bidService = bidService;
    }

    @PostMapping
    public ResponseEntity<Boolean> creatingBid(@RequestBody BidDTO bidDTO) {

        boolean answer = bidService.creatingBid(bidDTO);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{index}")
    public ResponseEntity<BidDTO> readingBid(@PathVariable(value = "index") Integer index) {

        BidDTO bidDTO = bidService.readingBid(index);

        if (bidDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bidDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BidDTO>> readingAllBid() {

        List<BidDTO> bidDTOList = bidService.readingAllBid();

        return new ResponseEntity<>(bidDTOList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Boolean> updatingBid(@RequestBody BidDTO bidDTO) {

        boolean answer = bidService.updatingBid(bidDTO);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deletingBid(@RequestParam(value = "index") Integer index) {

        boolean answer = bidService.deletingBid(index);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
