package fr.orionbs.ApplicationTest.restControllersTest;

import fr.orionbs.dtos.BidDTO;
import fr.orionbs.mappers.BidMapper;
import fr.orionbs.repositories.BidRepository;
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
public class BidRestControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    BidRepository bidRepository;
    @Autowired
    BidMapper bidMapper;

    @AfterAll
    public void cleanUp() {
        bidRepository.deleteAll();
    }

    @BeforeAll
    public void setUpBid() {
        BidDTO bidDTO = new BidDTO(1, "AccountTest", "TypeTest", 10.0);
        bidMapper = new BidMapper();
        bidRepository.save(bidMapper.bidDtoToBid(bidDTO));
        BidDTO bidDTO2 = new BidDTO(2, "AccountTest2", "TypeTest2", 12.0);
        bidRepository.save(bidMapper.bidDtoToBid(bidDTO2));
    }

    @Test
    public void testCreatingBid() throws Exception {
        BidDTO bidDTO = new BidDTO(null, "AccountTest3", "TypeTest3", 13.0);
        mockMvc.perform(post("/api/bid").contentType(MediaType.APPLICATION_JSON).content(bidDTO.toString()))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreatingAlreadyExistingBid() throws Exception {
        BidDTO bidDTO = new BidDTO(2, "AccountTest2", "TypeTest2", 12.0);
        mockMvc.perform(post("/api/bid").contentType(MediaType.APPLICATION_JSON).content(bidDTO.toString()))
                .andExpect(status().isBadRequest());
    }

    /**@Test
    public void testReadingBid() throws Exception {
        mockMvc.perform(get("/api/bid/2"))
                .andExpect(status().isOk());
    }**/

    @Test
    public void testReadingAllBid() throws Exception {
        mockMvc.perform(get("/api/bid"))
                .andExpect(status().isOk());
    }

    /**@Test
    public void testDeletingBid() throws Exception {
        mockMvc.perform(delete("/api/bid/").param("index", "1"))
                .andExpect(status().isOk());
    }**/
}
