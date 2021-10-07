package fr.orionbs.services.impl;

import fr.orionbs.dtos.CurvePointDTO;
import fr.orionbs.mappers.BidMapper;
import fr.orionbs.mappers.CurvePointMapper;
import fr.orionbs.models.Bid;
import fr.orionbs.models.CurvePoint;
import fr.orionbs.repositories.CurvePointRepository;
import fr.orionbs.services.CurvePointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.geo.Circle;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class CurvePointServiceImpl implements CurvePointService {

    private final CurvePointRepository curvePointRepository;
    private CurvePointMapper curvePointMapper;

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

        curvePointMapper = new CurvePointMapper();

        log.info("Creating CurvePoint, {}", curvePointDTO);
        curvePointRepository.save(curvePointMapper.curvePointDtoToCurvePoint(curvePointDTO));
        return true;
    }

    @Override
    public CurvePointDTO readingCurvePoint(Integer index) {
        log.info("Reading CurvePoint Id {}", index);
        CurvePoint curvePoint = curvePointRepository.getById(index);
        if(curvePoint == null) {
            log.warn("Not found CurvePoint Id {}", index);
            return null;
        }
        log.info("CurvePoint found {}", curvePoint);
        curvePointMapper = new CurvePointMapper();
        return curvePointMapper.curvePointToCurvePointDto(curvePoint);
    }

    @Override
    public List<CurvePointDTO> readingAllCurvePoint() {
        log.info("Reading All CurvePoints");
        curvePointMapper = new CurvePointMapper();
        return curvePointMapper.curvePointToCurvePointDtoList(curvePointRepository.findAll());
    }

    @Override
    public boolean updatingCurvePoint(CurvePointDTO curvePointDTO) {
        if (curvePointDTO == null) {
            log.info("CurvePoint is empty");
            return false;
        }

        Optional<CurvePoint> isCurvePointPresent = curvePointRepository.findById(curvePointDTO.getId());

        if (isCurvePointPresent == null) {
            log.info("CurvePoint doesn't exist");
            return false;
        }

        CurvePoint oldCurvePoint = isCurvePointPresent.get();

        curvePointMapper = new CurvePointMapper();
        CurvePoint curvePoint = curvePointMapper.curvePointDtoToCurvePoint(curvePointDTO);

        oldCurvePoint.setCurveId(curvePoint.getCurveId());
        oldCurvePoint.setTerm(curvePoint.getTerm());
        oldCurvePoint.setValue(curvePoint.getValue());


        log.info("Updating CurvePoint, {}", oldCurvePoint);
        curvePointRepository.save(oldCurvePoint);
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