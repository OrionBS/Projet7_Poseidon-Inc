package fr.orionbs.dtos;

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
}
