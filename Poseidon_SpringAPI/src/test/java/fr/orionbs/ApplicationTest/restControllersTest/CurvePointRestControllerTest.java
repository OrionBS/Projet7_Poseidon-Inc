package fr.orionbs.ApplicationTest.restControllersTest;

import fr.orionbs.dtos.CurvePointDTO;
import fr.orionbs.mappers.CurvePointMapper;
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

    @AfterAll
    public void cleanUp() {
        curvePointRepository.deleteAll();
    }

    @BeforeAll
    public void setUpCurvePoint() {
        CurvePointDTO curvePointDTO = new CurvePointDTO(1, 1, 1.0, 10.0);
        curvePointMapper = new CurvePointMapper();
        curvePointRepository.save(curvePointMapper.curvePointDtoToCurvePoint(curvePointDTO));
        CurvePointDTO curvePointDTO2 = new CurvePointDTO(2, 2, 2.0, 12.0);
        curvePointRepository.save(curvePointMapper.curvePointDtoToCurvePoint(curvePointDTO2));
    }

    @Test
    public void testCreatingCurvePoint() throws Exception {
        CurvePointDTO curvePointDTO = new CurvePointDTO(null, 3, 3.0, 13.0);
        mockMvc.perform(post("/api/curve-point").contentType(MediaType.APPLICATION_JSON).content(curvePointDTO.toString()))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreatingAlreadyExistingCurvePoint() throws Exception {
        CurvePointDTO curvePointDTO = new CurvePointDTO(2, 2, 2.0, 12.0);
        mockMvc.perform(post("/api/curve-point").contentType(MediaType.APPLICATION_JSON).content(curvePointDTO.toString()))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testReadingCurvePoint() throws Exception {
        mockMvc.perform(get("/api/curve-point/2"))
                .andExpect(status().isOk());
    }

    @Test
    public void testReadingAllCurvePoint() throws Exception {
        mockMvc.perform(get("/api/curve-point"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeletingCurvePoint() throws Exception {
        mockMvc.perform(delete("/api/curve-point/").param("index", "1"))
                .andExpect(status().isOk());
    }
}
