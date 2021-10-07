package fr.orionbs.ApplicationTest.servicesTest;

import fr.orionbs.dtos.CurvePointDTO;
import fr.orionbs.models.CurvePoint;
import fr.orionbs.repositories.CurvePointRepository;
import fr.orionbs.services.impl.CurvePointServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurvePointServiceTest {

    @InjectMocks
    private CurvePointServiceImpl curvePointService;

    @Mock
    CurvePointRepository curvePointRepository;

    @Test
    public void testCreatingCurvePoint() {
        //GIVEN
        CurvePointDTO curvePointDTO = new CurvePointDTO(1, 1, 12.0, 10.0);
        CurvePoint curvePoint = new CurvePoint();
        curvePoint.setId(1);
        curvePoint.setCurveId(1);
        curvePoint.setTerm(12.0);
        curvePoint.setValue(10.0);

        when(curvePointRepository.save(any(CurvePoint.class))).thenReturn(curvePoint);

        //WHEN
        curvePointService.creatingCurvePoint(curvePointDTO);

        //THEN
        verify(curvePointRepository, Mockito.times(1)).save(any(CurvePoint.class));
    }

    @Test
    public void testCreatingEmptyCurvePoint() {
        //GIVEN

        //WHEN
        curvePointService.creatingCurvePoint(null);

        //THEN
        verify(curvePointRepository, Mockito.times(0)).save(new CurvePoint());
    }

    @Test
    public void testReadingCurvePoint() {
        //GIVEN
        CurvePoint curvePoint = new CurvePoint();
        curvePoint.setId(1);
        curvePoint.setCurveId(1);
        curvePoint.setTerm(12.0);
        curvePoint.setValue(10.0);

        when(curvePointRepository.getById(1)).thenReturn(curvePoint);

        //WHEN
        curvePointService.readingCurvePoint(1);

        //THEN
        verify(curvePointRepository, Mockito.times(1)).getById(1);
    }

    @Test
    public void testReadingNotFoundCurvePoint() {
        //GIVEN

        //WHEN
        curvePointService.readingCurvePoint(anyInt());

        //THEN
        verify(curvePointRepository, Mockito.times(0)).getById(1);
    }

    @Test
    public void testReadingAllCurvePoint() {
        //GIVEN
        List<CurvePoint> curvePointList = new ArrayList<>();

        when(curvePointRepository.findAll()).thenReturn(curvePointList);

        //WHEN
        curvePointService.readingAllCurvePoint();

        //THEN
        verify(curvePointRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testUpdatingCurvePoint() {
        //GIVEN
        CurvePointDTO curvePointDTO = new CurvePointDTO(1, 2, 13.0, 10.0);
        CurvePoint curvePoint = new CurvePoint();
        curvePoint.setId(1);
        curvePoint.setCurveId(2);
        curvePoint.setTerm(13.0);
        curvePoint.setValue(10.0);

        Optional<CurvePoint> curvePointOptional = Optional.of(curvePoint);

        when(curvePointRepository.findById(1)).thenReturn(curvePointOptional);
        when(curvePointRepository.save(any(CurvePoint.class))).thenReturn(curvePoint);

        //WHEN
        curvePointService.updatingCurvePoint(curvePointDTO);

        //THEN
        verify(curvePointRepository, Mockito.times(1)).findById(1);
        verify(curvePointRepository, Mockito.times(1)).save(curvePoint);
    }

    @Test
    public void testUpdatingEmptyCurvePoint() {
        //GIVEN

        //WHEN
        curvePointService.updatingCurvePoint(null);

        //THEN
        verify(curvePointRepository, Mockito.times(0)).save(new CurvePoint());
    }

    @Test
    public void testUpdatingNotFoundCurvePoint() {
        //GIVEN
        CurvePointDTO curvePointDTO = new CurvePointDTO(1, 2, 13.0, 10.0);

        when(curvePointRepository.findById(1)).thenReturn(null);

        //WHEN
        curvePointService.updatingCurvePoint(curvePointDTO);

        //THEN
        verify(curvePointRepository, Mockito.times(1)).findById(1);
        verify(curvePointRepository, Mockito.times(0)).save(new CurvePoint());
    }

    @Test
    public void testDeletingCurvePoint() {
        //GIVEN
        CurvePoint curvePoint = new CurvePoint();
        curvePoint.setId(1);
        curvePoint.setCurveId(1);
        curvePoint.setTerm(12.0);
        curvePoint.setValue(10.0);

        Optional<CurvePoint> curvePointOptional = Optional.of(curvePoint);

        when(curvePointRepository.findById(1)).thenReturn(curvePointOptional);

        //WHEN
        curvePointService.deletingCurvePoint(1);

        //THEN
        verify(curvePointRepository, Mockito.times(1)).deleteById(1);
    }

    @Test
    public void testDeletingNotFoundCurvePoint() {
        //GIVEN
        when(curvePointRepository.findById(1)).thenReturn(null);

        //WHEN
        curvePointService.deletingCurvePoint(1);

        //THEN
        verify(curvePointRepository, Mockito.times(1)).findById(1);
        verify(curvePointRepository, Mockito.times(0)).deleteById(1);

    }
}
