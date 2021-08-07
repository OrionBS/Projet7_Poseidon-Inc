package fr.orionbs.services;

import fr.orionbs.dataTransferObjects.CurvePointDTO;
import fr.orionbs.models.CurvePoint;
import fr.orionbs.repositories.CurvePointRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class CurvePointService {

    @Autowired
    CurvePointRepository curvePointRepository;

    public void addCurvePoint(CurvePointDTO curvePointDTO) {

        log.info("CurvePoint's Creation, {}", curvePointDTO);
        CurvePoint curvePoint = curvePointDTO.curvePointDtoToCurvePoint(curvePointDTO);

    }

    public CurvePointDTO getOneCurvePoint(Integer index) {

        log.info("Fetch CurvePoint Id {}", index);
        CurvePoint curvePoint = curvePointRepository.getById(index);
        return new CurvePointDTO().curvePointToCurvePointDto(curvePoint);

    }

    public void updateCurvePoint(CurvePointDTO curvePointDTO) {

        log.info("Update CurvePoint, {}", curvePointDTO);
        CurvePoint curvePoint = curvePointDTO.curvePointDtoToCurvePoint(curvePointDTO);
        curvePointRepository.save(curvePoint);

    }

    public List<CurvePointDTO> getAllCurvePoints() {

        log.info("Fetch All CurvePoints");
        CurvePointDTO curvePointDTO = CurvePointDTO.builder().build();
        return curvePointDTO.curvePointToCurvePointDtoList(curvePointRepository.findAll());

    }
}