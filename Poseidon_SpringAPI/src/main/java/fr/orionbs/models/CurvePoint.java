package fr.orionbs.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "curve_point")
public class CurvePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer curveId;
    private Timestamp asOfDate;
    private Double term;
    private Double value;
    private Timestamp creationDate;

    @Override
    public String toString() {
        return "CurvePoint{" +
                "id=" + id +
                ", curveId=" + curveId +
                ", asOfDate=" + asOfDate +
                ", term=" + term +
                ", value=" + value +
                ", creationDate=" + creationDate +
                '}';
    }
}
