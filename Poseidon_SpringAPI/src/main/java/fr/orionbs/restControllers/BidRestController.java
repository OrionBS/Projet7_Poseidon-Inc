package fr.orionbs.restControllers;

import fr.orionbs.dataTransferObjects.BidDTO;
import fr.orionbs.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BidRestController {

    @Autowired
    BidService bidService;

    @PostMapping(path = "/bid/creating")
    public boolean creatingBid(BidDTO bidDTO) {
        boolean answer = bidService.creatingBid(bidDTO);
        if (answer) {
            return true;
        }
        return false;
    }

    @GetMapping(path = "/bid/reading")
    public BidDTO readingBid(Integer index) {
        return bidService.readingBid(index);
    }

    @GetMapping(path = "/bid/readingAll")
    public List<BidDTO> readingAllBid() {
        return bidService.readingAllBid();
    }

    @PutMapping(path = "/bid/updating")
    public boolean updatingBid(BidDTO bidDTO) {
        boolean answer = bidService.updatingBid(bidDTO);
        if (answer) {
            return true;
        }
        return false;
    }

    @DeleteMapping(path = "/bid/deleting")
    public boolean deletingBid(Integer index) {
        boolean answer = bidService.deletingBid(index);
        if (answer) {
            return true;
        }
        return false;
    }
}
