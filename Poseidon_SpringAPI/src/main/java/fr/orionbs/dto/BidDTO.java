package fr.orionbs.dto;

import fr.orionbs.models.Bid;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class BidDTO {
    private Integer id;
    private String account;
    private String type;
    private Double bidQuantity;

    public BidDTO bidToBidDto(Bid bid) {
        return new BidDTO(bid.getId(), bid.getAccount(), bid.getType(), bid.getBidQuantity());
    }

    public Bid bidDtoToBid(BidDTO bidDTO) {
        return Bid.builder().id(bidDTO.getId()).account(bidDTO.getAccount()).type(bidDTO.getType()).bidQuantity(bidDTO.getBidQuantity()).build();
    }

    public List<BidDTO> bidToBidDtoList(List<Bid> bidList) {
        List<BidDTO> bidDTOList = new ArrayList<>();
        for (Bid bid : bidList) {
            BidDTO bidDTO = new BidDTO(bid.getId(), bid.getAccount(), bid.getType(), bid.getBidQuantity());
            bidDTOList.add(bidDTO);
        }
        return bidDTOList;
    }

    public List<Bid> bidDtoToBidList(List<BidDTO> bidDtoList) {
        List<Bid> bidList = new ArrayList<>();
        for (BidDTO bidDto : bidDtoList) {
            Bid bid = Bid.builder().id(bidDto.getId()).account(bidDto.getAccount()).type(bidDto.getType()).bidQuantity(bidDto.getBidQuantity()).build();
            bidList.add(bid);
        }
        return bidList;
    }
}
