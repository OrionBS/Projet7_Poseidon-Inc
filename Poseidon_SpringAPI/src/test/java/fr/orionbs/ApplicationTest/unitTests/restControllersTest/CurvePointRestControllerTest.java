package fr.orionbs.ApplicationTest.unitTests.restControllersTest;

import fr.orionbs.dtos.CurvePointDTO;
import fr.orionbs.restControllers.CurvePointRestController;
import fr.orionbs.services.impl.CurvePointServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurvePointRestControllerTest {

    @InjectMocks
    CurvePointRestController curvePointRestController;

    @Mock
    CurvePointServiceImpl curvePointService;

    @Test
    public void testCreatingCurvePoint() {
        //GIVEN
        CurvePointDTO curvePointDTO = new CurvePointDTO(0, 1, 1.0, 10.0);
        when(curvePointService.creatingCurvePoint(any(CurvePointDTO.class))).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = curvePointRestController.creatingCurvePoint(curvePointDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.CREATED));
        verify(curvePointService, Mockito.times(1)).creatingCurvePoint(curvePointDTO);
    }

    @Test
    public void testCreatingCurvePointIdFilled() {
        //GIVEN
        CurvePointDTO curvePointDTO = new CurvePointDTO(1, 1, 1.0, 10.0);
        when(curvePointService.creatingCurvePoint(any(CurvePointDTO.class))).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = curvePointRestController.creatingCurvePoint(curvePointDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.BAD_REQUEST));
        verify(curvePointService, Mockito.times(1)).creatingCurvePoint(curvePointDTO);
    }

    @Test
    public void testReadingCurvePoint() {
        //GIVEN
        CurvePointDTO curvePointDTO = new CurvePointDTO(1, 1, 1.0, 10.0);
        when(curvePointService.readingCurvePoint(1)).thenReturn(curvePointDTO);

        //WHEN
        ResponseEntity<CurvePointDTO> answer = curvePointRestController.readingCurvePoint(1);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(curvePointDTO, HttpStatus.OK));
        verify(curvePointService, Mockito.times(1)).readingCurvePoint(1);
    }

    @Test
    public void testReadingNullIdCurvePoint() {
        //GIVEN
        when(curvePointService.readingCurvePoint(null)).thenReturn(null);

        //WHEN
        ResponseEntity<CurvePointDTO> answer = curvePointRestController.readingCurvePoint(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        verify(curvePointService, Mockito.times(1)).readingCurvePoint(null);
    }

    @Test
    public void testReadingAllCurvePoint() {
        //GIVEN
        CurvePointDTO curvePointDTO = new CurvePointDTO(1, 1, 1.0, 10.0);
        CurvePointDTO curvePointDTO2 = new CurvePointDTO(2, 2, 2.0, 12.0);
        when(curvePointService.readingAllCurvePoint()).thenReturn(Arrays.asList(curvePointDTO, curvePointDTO2));

        //WHEN
        ResponseEntity<List<CurvePointDTO>> answer = curvePointRestController.readingAllCurvePoint();

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(Arrays.asList(curvePointDTO, curvePointDTO2), HttpStatus.OK));
        verify(curvePointService, Mockito.times(1)).readingAllCurvePoint();
    }

    @Test
    public void testUpdatingCurvePoint() {
        //GIVEN
        CurvePointDTO curvePointDTO = new CurvePointDTO(1, 1, 1.0, 10.0);
        when(curvePointService.updatingCurvePoint(curvePointDTO)).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = curvePointRestController.updatingCurvePoint(curvePointDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.OK));
        verify(curvePointService, Mockito.times(1)).updatingCurvePoint(curvePointDTO);
    }

    @Test
    public void testUpdatingNotFoundCurvePoint() {
        //GIVEN
        when(curvePointService.updatingCurvePoint(null)).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = curvePointRestController.updatingCurvePoint(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.NOT_FOUND));
        verify(curvePointService, Mockito.times(1)).updatingCurvePoint(null);
    }

    @Test
    public void testDeletingCurvePoint() {
        //GIVEN
        when(curvePointService.deletingCurvePoint(1)).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = curvePointRestController.deletingCurvePoint(1);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.OK));
        verify(curvePointService, Mockito.times(1)).deletingCurvePoint(1);
    }

    @Test
    public void testDeletingNotFoundCurvePoint() {
        //GIVEN
        when(curvePointService.deletingCurvePoint(null)).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = curvePointRestController.deletingCurvePoint(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.NOT_FOUND));
        verify(curvePointService, Mockito.times(1)).deletingCurvePoint(null);
    }

}
