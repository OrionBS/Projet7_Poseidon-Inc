package fr.orionbs.ApplicationTest.restControllersTest;

import fr.orionbs.dtos.TradeDTO;
import fr.orionbs.mappers.TradeMapper;
import fr.orionbs.repositories.TradeRepository;
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
public class TradeRestControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    TradeRepository tradeRepository;
    @Autowired
    TradeMapper tradeMapper;

    @AfterAll
    public void cleanUp() {
        tradeRepository.deleteAll();
    }

    @BeforeAll
    public void setUpTrade() {
        TradeDTO tradeDTO = new TradeDTO(1, "AccountTest", "TypeTest", 10.0);
        tradeMapper = new TradeMapper();
        tradeRepository.save(tradeMapper.tradeDtoToTrade(tradeDTO));
        TradeDTO tradeDTO2 = new TradeDTO(2, "AccountTest2", "TypeTest2", 12.0);
        tradeRepository.save(tradeMapper.tradeDtoToTrade(tradeDTO2));
    }

    @Test
    public void testCreatingTrade() throws Exception {
        TradeDTO tradeDTO = new TradeDTO(null, "AccountTest3", "TypeTest3", 13.0);
        mockMvc.perform(post("/api/curve-point").contentType(MediaType.APPLICATION_JSON).content(tradeDTO.toString()))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreatingAlreadyExistingTrade() throws Exception {
        TradeDTO tradeDTO = new TradeDTO(2, "AccountTest2", "TypeTest2", 12.0);
        mockMvc.perform(post("/api/trade").contentType(MediaType.APPLICATION_JSON).content(tradeDTO.toString()))
                .andExpect(status().isBadRequest());
    }

    /**@Test
    public void testReadingTrade() throws Exception {
        mockMvc.perform(get("/api/trade/2"))
                .andExpect(status().isOk());
    }**/

    @Test
    public void testReadingAllTrade() throws Exception {
        mockMvc.perform(get("/api/trade"))
                .andExpect(status().isOk());
    }

    /**@Test
    public void testDeletingTrade() throws Exception {
        mockMvc.perform(delete("/api/trade").param("index", "1"))
                .andExpect(status().isOk());
    }**/
}
