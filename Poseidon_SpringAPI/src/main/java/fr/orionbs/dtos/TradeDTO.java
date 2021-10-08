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
public class TradeDTO {
    private Integer id;
    private String account;
    private String type;
    private Double buyQuantity;

    @Override
    public String toString() {
        return "{\n" +
                "\"id\": \""+id+"\",\n" +
                "\"account\": \""+account+"\",\n" +
                "\"type\": \""+type+"\",\n" +
                "\"buyQuantity\": \""+buyQuantity+"\"\n" +
                '}';
    }
}
