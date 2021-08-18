package fr.orionbs.services;

import fr.orionbs.dto.CurvePointDTO;
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

    public boolean creatingCurvePoint(CurvePointDTO curvePointDTO) {

        if (curvePointDTO == null) {
            log.info("CurvePoint is empty");
            return false;
        }

        log.info("Creating CurvePoint, {}", curvePointDTO);
        CurvePoint curvePoint = curvePointDTO.curvePointDtoToCurvePoint(curvePointDTO);
        curvePointRepository.save(curvePoint);
        return true;
    }

    public CurvePointDTO readingCurvePoint(Integer index) {

        log.info("Reading CurvePoint Id {}", index);
        CurvePoint curvePoint = curvePointRepository.getById(index);
        return new CurvePointDTO().curvePointToCurvePointDto(curvePoint);

    }

    public List<CurvePointDTO> readingAllCurvePoint() {

        log.info("Reading All CurvePoints");
        CurvePointDTO curvePointDTO = CurvePointDTO.builder().build();
        return curvePointDTO.curvePointToCurvePointDtoList(curvePointRepository.findAll());

    }

    public boolean updatingCurvePoint(CurvePointDTO curvePointDTO) {

        if (curvePointDTO == null) {
            log.info("CurvePoint is empty");
            return false;
        }

        if (curvePointRepository.findById(curvePointDTO.getId()) == null) {
            log.info("CurvePoint doesn't exist");
            return false;
        }

        CurvePoint curvePoint = curvePointDTO.curvePointDtoToCurvePoint(curvePointDTO);
        log.info("Updating CurvePoint, {}", curvePointDTO);
        curvePointRepository.save(curvePoint);
        return true;

    }

    public boolean deletingCurvePoint(Integer index) {

        if (curvePointRepository.findById(index) == null) {
            log.info("CurvePoint doesn't exist");
            return false;
        }
        curvePointRepository.deleteById(index);
        log.info("Deleting CurvePoint {}", index);
        return true;

    }
}