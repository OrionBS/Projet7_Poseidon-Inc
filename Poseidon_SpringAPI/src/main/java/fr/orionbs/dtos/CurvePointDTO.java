package fr.orionbs.dtos;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurvePointDTO {
    private Integer id;
    private Integer curveId;
    private Double term;
    private Double value;

    @Override
    public String toString() {
        return "{\n" +
                "\"id\": \""+id+"\",\n" +
                "\"curveId\": \""+curveId+"\",\n" +
                "\"term\": \""+term+"\",\n" +
                "\"value\": \""+value+"\"\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurvePointDTO that = (CurvePointDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
