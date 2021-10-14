package fr.orionbs.ApplicationTest.restControllersTest;

import fr.orionbs.dtos.UserDTO;
import fr.orionbs.mappers.UserMapper;
import fr.orionbs.repositories.UserRepository;
import fr.orionbs.services.UserService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    /**@Test
    public void testReadingUser() throws Exception {
        UserDTO userDTO = new UserDTO(2, "userNameTest2", "fullNameTest2", "RoleTest2");
        userMapper = new UserMapper();
        userRepository.save(userMapper.userDtoToUser(userDTO));

        mockMvc.perform(get("/api/user/2"))
                .andExpect(status().isOk());

        userRepository.deleteAll();
    }**/

    @Test
    public void testCreatingUser() throws Exception {
        UserDTO userDTO = new UserDTO(null, "userNameTest3", "fullNameTest3", "RoleTest3");
        mockMvc.perform(post("/api/curve-point").contentType(MediaType.APPLICATION_JSON).content(userDTO.toString()))
                .andExpect(status().isCreated());

        userRepository.deleteAll();
    }

    @Test
    public void testCreatingAlreadyExistingUser() throws Exception {
        UserDTO userDTO2 = new UserDTO(2, "userNameTest2", "fullNameTest2", "RoleTest2");
        userMapper = new UserMapper();
        userRepository.save(userMapper.userDtoToUser(userDTO2));

        UserDTO userDTO = new UserDTO(2, "userNameTest2", "fullNameTest2", "RoleTest2");
        mockMvc.perform(post("/api/user").contentType(MediaType.APPLICATION_JSON).content(userDTO.toString()))
                .andExpect(status().isBadRequest());

        userRepository.deleteAll();
    }

    @Test
    public void testReadingAllUser() throws Exception {
        UserDTO userDTO = new UserDTO(1, "userNameTest", "fullNameTest", "RoleTest");
        userMapper = new UserMapper();
        userRepository.save(userMapper.userDtoToUser(userDTO));

        mockMvc.perform(get("/api/user"))
                .andExpect(status().isOk());

        userRepository.deleteAll();
    }

    /**@Test
    public void testDeletingUser() throws Exception {
        UserDTO userDTO = new UserDTO(0, "userNameTest", "fullNameTest", "RoleTest");
        userMapper = new UserMapper();
        userRepository.save(userMapper.userDtoToUser(userDTO));

        mockMvc.perform(delete("/api/user").param("index", "1"))
                .andExpect(status().isOk());

        userRepository.deleteAll();
    }**/
}
