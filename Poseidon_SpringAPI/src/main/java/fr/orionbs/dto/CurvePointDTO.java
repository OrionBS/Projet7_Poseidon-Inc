package fr.orionbs.dto;

import fr.orionbs.models.CurvePoint;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CurvePointDTO {
    private Integer id;
    private Integer curveId;
    private Double term;
    private Double value;

    public CurvePointDTO curvePointToCurvePointDto(CurvePoint curvePoint) {
        return new CurvePointDTO(curvePoint.getId(), curvePoint.getCurveId(), curvePoint.getTerm(), curvePoint.getValue());
    }

    public CurvePoint curvePointDtoToCurvePoint(CurvePointDTO curvePointDTO) {
        return CurvePoint.builder().curveId(curvePointDTO.getCurveId()).term(curvePointDTO.getTerm()).value(curvePointDTO.getValue()).build();
    }

    public List<CurvePointDTO> curvePointToCurvePointDtoList(List<CurvePoint> curvePointList) {
        List<CurvePointDTO> curvePointDTOList = new ArrayList<>();
        for (CurvePoint curvePoint : curvePointList) {
            CurvePointDTO curvePointDTO = new CurvePointDTO(curvePoint.getId(), curvePoint.getCurveId(), curvePoint.getTerm(), curvePoint.getValue());
            curvePointDTOList.add(curvePointDTO);
        }
        return curvePointDTOList;
    }

    public List<CurvePoint> curvePointDtoToCurvePointList(List<CurvePointDTO> curvePointDTOList) {
        List<CurvePoint> curvePointList = new ArrayList<>();
        for (CurvePointDTO curvePointDTO : curvePointDTOList) {
            CurvePoint curvePoint = CurvePoint.builder().id(curvePointDTO.getId()).curveId(curvePointDTO.getCurveId()).term(curvePointDTO.getTerm()).value(curvePointDTO.getValue()).build();
            curvePointList.add(curvePoint);
        }
        return curvePointList;
    }
}
