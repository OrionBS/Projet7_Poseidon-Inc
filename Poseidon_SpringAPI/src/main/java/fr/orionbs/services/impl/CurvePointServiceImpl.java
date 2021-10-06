package fr.orionbs.services.impl;

import fr.orionbs.dtos.CurvePointDTO;
import fr.orionbs.mappers.CurvePointMapper;
import fr.orionbs.models.CurvePoint;
import fr.orionbs.repositories.CurvePointRepository;
import fr.orionbs.services.CurvePointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class CurvePointServiceImpl implements CurvePointService {

    private final CurvePointRepository curvePointRepository;
    private final CurvePointMapper curvePointMapper;

    public CurvePointServiceImpl(CurvePointRepository curvePointRepository, CurvePointMapper curvePointMapper) {
        this.curvePointRepository = curvePointRepository;
        this.curvePointMapper = curvePointMapper;
    }

    @Override
    public boolean creatingCurvePoint(CurvePointDTO curvePointDTO) {
        if (curvePointDTO == null) {
            log.info("CurvePoint is empty");
            return false;
        }

        log.info("Creating CurvePoint, {}", curvePointDTO);
        curvePointRepository.save(curvePointMapper.curvePointDtoToCurvePoint(curvePointDTO));
        return true;
    }

    @Override
    public CurvePointDTO readingCurvePoint(Integer index) {
        log.info("Reading CurvePoint Id {}", index);
        CurvePoint curvePoint = curvePointRepository.getById(index);
        return curvePointMapper.curvePointToCurvePointDto(curvePoint);
    }

    @Override
    public List<CurvePointDTO> readingAllCurvePoint() {
        log.info("Reading All CurvePoints");
        return curvePointMapper.curvePointToCurvePointDtoList(curvePointRepository.findAll());
    }

    @Override
    public boolean updatingCurvePoint(CurvePointDTO curvePointDTO) {
        if (curvePointDTO == null) {
            log.info("CurvePoint is empty");
            return false;
        }

        if (curvePointRepository.findById(curvePointDTO.getId()) == null) {
            log.info("CurvePoint doesn't exist");
            return false;
        }

        CurvePoint curvePoint = curvePointMapper.curvePointDtoToCurvePoint(curvePointDTO);
        log.info("Updating CurvePoint, {}", curvePointDTO);
        curvePointRepository.save(curvePoint);
        return true;
    }

    @Override
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