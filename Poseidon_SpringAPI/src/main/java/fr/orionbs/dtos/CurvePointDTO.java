package fr.orionbs.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CurvePointDTO {
    private Integer id;
    private Integer curveId;
    private Double term;
    private Double value;
}
