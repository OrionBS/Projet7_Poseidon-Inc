package fr.orionbs.ApplicationTest.restControllersTest;

import fr.orionbs.dtos.RatingDTO;
import fr.orionbs.mappers.RatingMapper;
import fr.orionbs.repositories.RatingRepository;
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
public class RatingRestControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    RatingRepository ratingRepository;
    @Autowired
    RatingMapper ratingMapper;

    @AfterAll
    public void cleanUp() {
        ratingRepository.deleteAll();
    }

    @BeforeAll
    public void setUpRating() {
        RatingDTO ratingDTO = new RatingDTO(1, "moodysTest", "sAndPTest", "fitchTest", 10);
        ratingMapper = new RatingMapper();
        ratingRepository.save(ratingMapper.ratingDtoToRating(ratingDTO));
        RatingDTO ratingDTO2 = new RatingDTO(2, "moodysTest2", "sAndPTest2", "fitchTest2", 12);
        ratingRepository.save(ratingMapper.ratingDtoToRating(ratingDTO2));
    }

    @Test
    public void testCreatingRating() throws Exception {
        RatingDTO ratingDTO = new RatingDTO(null, "moodysTest3", "sAndPTest3", "fitchTest3", 13);
        mockMvc.perform(post("/api/rating").contentType(MediaType.APPLICATION_JSON).content(ratingDTO.toString()))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreatingAlreadyExistingRating() throws Exception {
        RatingDTO ratingDTO = new RatingDTO(2, "moodysTest2", "sAndPTest2", "fitchTest2", 12);
        mockMvc.perform(post("/api/rating").contentType(MediaType.APPLICATION_JSON).content(ratingDTO.toString()))
                .andExpect(status().isBadRequest());
    }

    /**@Test
    public void testReadingRating() throws Exception {
        mockMvc.perform(get("/api/rating/2"))
                .andExpect(status().isOk());
    }**/

    @Test
    public void testReadingAllRating() throws Exception {
        mockMvc.perform(get("/api/rating"))
                .andExpect(status().isOk());
    }

    /**@Test
    public void testDeletingRating() throws Exception {
        mockMvc.perform(delete("/api/rating/").param("index", "1"))
                .andExpect(status().isOk());
    }**/
}
