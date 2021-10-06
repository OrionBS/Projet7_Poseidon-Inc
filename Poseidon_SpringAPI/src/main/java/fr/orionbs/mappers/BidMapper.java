package fr.orionbs.mappers;

import fr.orionbs.dtos.BidDTO;
import fr.orionbs.models.Bid;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BidMapper {

    public BidDTO bidToBidDto(Bid bid) {
        BidDTO bidDTO = new BidDTO(bid.getId(), bid.getAccount(), bid.getType(), bid.getBidQuantity());
        return bidDTO;
    }

    public Bid bidDtoToBid(BidDTO bidDTO) {
        Bid bid = new Bid();
        bid.setId(bidDTO.getId());
        bid.setAccount(bidDTO.getAccount());
        bid.setType(bidDTO.getType());
        bid.setBidQuantity(bidDTO.getBidQuantity());
        return bid;
    }

    public List<BidDTO> bidToBidDtoList(List<Bid> bidList) {
        List<BidDTO> bidDTOList = new ArrayList<>();
        for (Bid bid : bidList) {
            BidDTO bidDTO = bidToBidDto(bid);
            bidDTOList.add(bidDTO);
        }
        return bidDTOList;
    }

    public List<Bid> bidDtoToBidList(List<BidDTO> bidDtoList) {
        List<Bid> bidList = new ArrayList<>();
        for (BidDTO bidDto : bidDtoList) {
            Bid bid = bidDtoToBid(bidDto);
            bidList.add(bid);
        }
        return bidList;
    }
}
