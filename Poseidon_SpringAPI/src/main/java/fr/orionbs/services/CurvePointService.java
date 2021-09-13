package fr.orionbs.services;

import fr.orionbs.dtos.CurvePointDTO;

import java.util.List;

public interface CurvePointService {
    boolean creatingCurvePoint(CurvePointDTO curvePointDTO);
    CurvePointDTO readingCurvePoint(Integer index);
    List<CurvePointDTO> readingAllCurvePoint();
    boolean updatingCurvePoint(CurvePointDTO curvePointDTO);
    boolean deletingCurvePoint(Integer index);
}
