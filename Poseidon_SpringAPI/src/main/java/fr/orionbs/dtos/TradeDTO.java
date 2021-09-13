package fr.orionbs.dtos;

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
}
