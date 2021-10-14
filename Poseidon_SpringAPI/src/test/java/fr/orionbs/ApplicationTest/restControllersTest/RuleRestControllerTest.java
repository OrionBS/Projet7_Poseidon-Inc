package fr.orionbs.ApplicationTest.restControllersTest;

import fr.orionbs.dtos.RuleDTO;
import fr.orionbs.mappers.RuleMapper;
import fr.orionbs.repositories.RuleRepository;
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
public class RuleRestControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    RuleRepository ruleRepository;
    @Autowired
    RuleMapper ruleMapper;

    @AfterAll
    public void cleanUp() {
        ruleRepository.deleteAll();
    }

    @BeforeAll
    public void setUpRule() {
        RuleDTO ruleDTO = new RuleDTO(1,"NameTest","DescTest","JsonTest","TemplateTest","SqlStrTest","SqlPartTest");
        ruleMapper = new RuleMapper();
        ruleRepository.save(ruleMapper.ruleDtoToRule(ruleDTO));
        RuleDTO ruleDTO2 = new RuleDTO(2,"NameTest2","DescTest2","JsonTest2","TemplateTest2","SqlStrTest2","SqlPartTest2");
        ruleRepository.save(ruleMapper.ruleDtoToRule(ruleDTO2));
    }

    @Test
    public void testCreatingRule() throws Exception {
        RuleDTO ruleDTO = new RuleDTO(null,"NameTest3","DescTest3","JsonTest3","TemplateTest3","SqlStrTest3","SqlPartTest3");
        mockMvc.perform(post("/api/rule").contentType(MediaType.APPLICATION_JSON).content(ruleDTO.toString()))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreatingAlreadyExistingRule() throws Exception {
        RuleDTO ruleDTO = new RuleDTO(2,"NameTest2","DescTest2","JsonTest2","TemplateTest2","SqlStrTest2","SqlPartTest2");
        mockMvc.perform(post("/api/rule").contentType(MediaType.APPLICATION_JSON).content(ruleDTO.toString()))
                .andExpect(status().isBadRequest());
    }

    /**@Test
    public void testReadingRule() throws Exception {
        mockMvc.perform(get("/api/rule/2"))
                .andExpect(status().isOk());
    }**/

    @Test
    public void testReadingAllRule() throws Exception {
        mockMvc.perform(get("/api/rule"))
                .andExpect(status().isOk());
    }

    /**@Test
    public void testDeletingRule() throws Exception {
        mockMvc.perform(delete("/api/rule").param("index", "1"))
                .andExpect(status().isOk());
    }**/
}
