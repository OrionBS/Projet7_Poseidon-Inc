package fr.orionbs.ApplicationTest.unitTests.restControllersTest;

import fr.orionbs.dtos.UserDTO;
import fr.orionbs.dtos.UserDTO;
import fr.orionbs.restControllers.UserRestController;
import fr.orionbs.services.impl.UserServiceImpl;
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
public class UserRestControllerTest {

    @InjectMocks
    UserRestController userRestController;

    @Mock
    UserServiceImpl userService;

    @Test
    public void testCreatingUser() {
        //GIVEN
        UserDTO userDTO = new UserDTO(0, "userNameTest", "fullNameTest", "RoleTest");
        when(userService.creatingUser(any(UserDTO.class))).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = userRestController.creatingUser(userDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.CREATED));
        verify(userService, Mockito.times(1)).creatingUser(userDTO);
    }

    @Test
    public void testCreatingUserIdFilled() {
        //GIVEN
        UserDTO userDTO = new UserDTO(1, "userNameTest", "fullNameTest", "RoleTest");
        when(userService.creatingUser(any(UserDTO.class))).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = userRestController.creatingUser(userDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.BAD_REQUEST));
        verify(userService, Mockito.times(1)).creatingUser(userDTO);
    }

    @Test
    public void testReadingUser() {
        //GIVEN
        UserDTO userDTO = new UserDTO(1, "userNameTest", "fullNameTest", "RoleTest");
        when(userService.readingUser(1)).thenReturn(userDTO);

        //WHEN
        ResponseEntity<UserDTO> answer = userRestController.readingUser(1);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(userDTO, HttpStatus.OK));
        verify(userService, Mockito.times(1)).readingUser(1);
    }

    @Test
    public void testReadingNullIdUser() {
        //GIVEN
        when(userService.readingUser(null)).thenReturn(null);

        //WHEN
        ResponseEntity<UserDTO> answer = userRestController.readingUser(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        verify(userService, Mockito.times(1)).readingUser(null);
    }

    @Test
    public void testReadingAllUser() {
        //GIVEN
        UserDTO userDTO = new UserDTO(1, "userNameTest", "fullNameTest", "RoleTest");
        UserDTO userDTO2 = new UserDTO(2, "userNameTest2", "fullNameTest2", "RoleTest2");
        when(userService.readingAllUser()).thenReturn(Arrays.asList(userDTO, userDTO2));

        //WHEN
        ResponseEntity<List<UserDTO>> answer = userRestController.readingAllUser();

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(Arrays.asList(userDTO, userDTO2), HttpStatus.OK));
        verify(userService, Mockito.times(1)).readingAllUser();
    }

    @Test
    public void testUpdatingUser() {
        //GIVEN
        UserDTO userDTO = new UserDTO(1, "userNameTest", "fullNameTest", "RoleTest");
        when(userService.updatingUser(userDTO)).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = userRestController.updatingUser(userDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.OK));
        verify(userService, Mockito.times(1)).updatingUser(userDTO);
    }

    @Test
    public void testUpdatingNotFoundUser() {
        //GIVEN
        when(userService.updatingUser(null)).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = userRestController.updatingUser(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.NOT_FOUND));
        verify(userService, Mockito.times(1)).updatingUser(null);
    }

    @Test
    public void testDeletingUser() {
        //GIVEN
        when(userService.deletingUser(1)).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = userRestController.deletingUser(1);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.OK));
        verify(userService, Mockito.times(1)).deletingUser(1);
    }

    @Test
    public void testDeletingNotFoundUser() {
        //GIVEN
        when(userService.deletingUser(null)).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = userRestController.deletingUser(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.NOT_FOUND));
        verify(userService, Mockito.times(1)).deletingUser(null);
    }
}
