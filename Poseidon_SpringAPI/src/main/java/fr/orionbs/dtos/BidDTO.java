package fr.orionbs.dtos;

import fr.orionbs.models.Bid;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BidDTO {
    private Integer id;
    private String account;
    private String type;
    private Double bidQuantity;

    @Override
    public String toString() {
        return "{\n" +
                "\"id\": \""+id+"\",\n" +
                "\"account\": \""+account+"\",\n" +
                "\"type\": \""+type+"\",\n" +
                "\"bidQuantity\": \""+bidQuantity+"\"\n" +
                "}";
    }
}
