package fr.orionbs.ApplicationTest.restControllersTest;

import fr.orionbs.dtos.CurvePointDTO;
import fr.orionbs.mappers.CurvePointMapper;
import fr.orionbs.models.CurvePoint;
import fr.orionbs.repositories.CurvePointRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CurvePointRestControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    CurvePointRepository curvePointRepository;
    @Autowired
    CurvePointMapper curvePointMapper;


    @Test
    public void testCreatingCurvePoint() throws Exception {
        CurvePointDTO curvePointDTO = new CurvePointDTO(null, 3, 3.0, 13.0);
        mockMvc.perform(post("/api/curve-point").contentType(MediaType.APPLICATION_JSON).content(curvePointDTO.toString()))
                .andExpect(status().isCreated());

        curvePointRepository.deleteAll();
    }

    @Test
    public void testCreatingAlreadyExistingCurvePoint() throws Exception {
        CurvePointDTO curvePointDTO2 = new CurvePointDTO(2, 2, 2.0, 12.0);
        curvePointMapper = new CurvePointMapper();
        curvePointRepository.save(curvePointMapper.curvePointDtoToCurvePoint(curvePointDTO2));

        CurvePointDTO curvePointDTO = new CurvePointDTO(2, 2, 2.0, 12.0);
        mockMvc.perform(post("/api/curve-point").contentType(MediaType.APPLICATION_JSON).content(curvePointDTO.toString()))
                .andExpect(status().isBadRequest());

        curvePointRepository.deleteAll();
    }

    /**@Test
    public void testReadingCurvePoint() throws Exception {
        CurvePointDTO curvePointDTO2 = new CurvePointDTO(2, 2, 2.0, 12.0);
        curvePointMapper = new CurvePointMapper();
        curvePointRepository.save(curvePointMapper.curvePointDtoToCurvePoint(curvePointDTO2));

        mockMvc.perform(get("/api/curve-point/2"))
                .andExpect(status().isOk());

        curvePointRepository.deleteAll();
    }**/

    @Test
    public void testReadingAllCurvePoint() throws Exception {
        CurvePointDTO curvePointDTO2 = new CurvePointDTO(2, 2, 2.0, 12.0);
        curvePointMapper = new CurvePointMapper();
        curvePointRepository.save(curvePointMapper.curvePointDtoToCurvePoint(curvePointDTO2));

        mockMvc.perform(get("/api/curve-point"))
                .andExpect(status().isOk());

        curvePointRepository.deleteAll();
    }

    /**@Test
    public void testDeletingCurvePoint() throws Exception {
        CurvePointDTO curvePointDTO = new CurvePointDTO(0, 1, 1.0, 10.0);
        curvePointMapper = new CurvePointMapper();
        CurvePoint curvePoint = curvePointRepository.save(curvePointMapper.curvePointDtoToCurvePoint(curvePointDTO));

        mockMvc.perform(delete("/api/curve-point/").param("index", "1"))
                .andExpect(status().isOk());

        curvePointRepository.deleteAll();
    }**/
}
