package fr.orionbs.ApplicationTest.restControllersTest;

import fr.orionbs.dtos.CredentialsDTO;
import fr.orionbs.security.SecurityConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AuthenticateControllerTest {

    /**@Autowired
    MockMvc mockMvc;

    @Test
    public void setUser() throws Exception {
        CredentialsDTO credentialsDTO = new CredentialsDTO();
        credentialsDTO.setUsername("Tester");
        credentialsDTO.setPassword("123456");
        String str = credentialsDTO.toString();
        mockMvc.perform(post("/register").contentType(MediaType.APPLICATION_JSON).content(credentialsDTO.toString()))
                .andExpect(status().isCreated());

    }

    @Test
    public void login() throws Exception {

        CredentialsDTO credentialsDTO = new CredentialsDTO("Tester", "123456");

        String str = credentialsDTO.toString();

        MvcResult result = mockMvc.perform(post("/authenticate").contentType(MediaType.APPLICATION_JSON).content(credentialsDTO.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }**/
}
