package fr.orionbs.services;

import fr.orionbs.dtos.BidDTO;

import java.util.List;

public interface BidService {
    boolean creatingBid(BidDTO bidDTO);
    BidDTO readingBid(Integer index);
    List<BidDTO> readingAllBid();
    boolean updatingBid(BidDTO bidDTO);
    boolean deletingBid(Integer index);
}
