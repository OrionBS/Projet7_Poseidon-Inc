package fr.orionbs.ApplicationTest.restControllersTest;

import fr.orionbs.dtos.UserDTO;
import fr.orionbs.mappers.UserMapper;
import fr.orionbs.repositories.UserRepository;
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
public class UserRestControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    @AfterAll
    public void cleanUp() {
        userRepository.deleteAll();
    }

    @BeforeAll
    public void setUpUser() {
        UserDTO userDTO = new UserDTO(1, "userNameTest", "fullNameTest", "RoleTest");
        userMapper = new UserMapper();
        userRepository.save(userMapper.userDtoToUser(userDTO));
        UserDTO userDTO2 = new UserDTO(2, "userNameTest2", "fullNameTest2", "RoleTest2");
        userRepository.save(userMapper.userDtoToUser(userDTO2));
    }

    @Test
    public void testCreatingUser() throws Exception {
        UserDTO userDTO = new UserDTO(null, "userNameTest3", "fullNameTest3", "RoleTest3");
        mockMvc.perform(post("/api/curve-point").contentType(MediaType.APPLICATION_JSON).content(userDTO.toString()))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreatingAlreadyExistingUser() throws Exception {
        UserDTO userDTO = new UserDTO(2, "userNameTest2", "fullNameTest2", "RoleTest2");
        mockMvc.perform(post("/api/user").contentType(MediaType.APPLICATION_JSON).content(userDTO.toString()))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testReadingUser() throws Exception {
        mockMvc.perform(get("/api/user/2"))
                .andExpect(status().isOk());
    }

    @Test
    public void testReadingAllUser() throws Exception {
        mockMvc.perform(get("/api/user"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeletingUser() throws Exception {
        mockMvc.perform(delete("/api/user").param("index", "1"))
                .andExpect(status().isOk());
    }
}
