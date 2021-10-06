package fr.orionbs.mappers;

import fr.orionbs.dtos.CurvePointDTO;
import fr.orionbs.models.CurvePoint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CurvePointMapper {

    public CurvePointDTO curvePointToCurvePointDto(CurvePoint curvePoint) {
        CurvePointDTO curvePointDTO = new CurvePointDTO(curvePoint.getId(), curvePoint.getCurveId(), curvePoint.getTerm(), curvePoint.getValue());
        return curvePointDTO;
    }

    public CurvePoint curvePointDtoToCurvePoint(CurvePointDTO curvePointDTO) {
        CurvePoint curvePoint = new CurvePoint();
        curvePoint.setId(curvePointDTO.getId());
        curvePoint.setCurveId(curvePointDTO.getCurveId());
        curvePoint.setTerm(curvePointDTO.getTerm());
        curvePoint.setValue(curvePointDTO.getValue());
        return curvePoint;
    }

    public List<CurvePointDTO> curvePointToCurvePointDtoList(List<CurvePoint> curvePointList) {
        List<CurvePointDTO> curvePointDTOList = new ArrayList<>();
        for (CurvePoint curvePoint : curvePointList) {
            CurvePointDTO curvePointDTO = curvePointToCurvePointDto(curvePoint);
            curvePointDTOList.add(curvePointDTO);
        }
        return curvePointDTOList;
    }

    public List<CurvePoint> curvePointDtoToCurvePointList(List<CurvePointDTO> curvePointDTOList) {
        List<CurvePoint> curvePointList = new ArrayList<>();
        for (CurvePointDTO curvePointDTO : curvePointDTOList) {
            CurvePoint curvePoint = curvePointDtoToCurvePoint(curvePointDTO);
            curvePointList.add(curvePoint);
        }
        return curvePointList;
    }
}
