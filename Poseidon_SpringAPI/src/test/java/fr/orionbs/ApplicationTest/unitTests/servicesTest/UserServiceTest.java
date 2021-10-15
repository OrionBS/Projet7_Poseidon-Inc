package fr.orionbs.ApplicationTest.unitTests.servicesTest;

import fr.orionbs.dtos.UserDTO;
import fr.orionbs.models.User;
import fr.orionbs.repositories.UserRepository;
import fr.orionbs.services.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Test
    public void testCreatingUser() {
        //GIVEN
        UserDTO userDTO = new UserDTO(null, "UsernameTest", "FullNameTest", "RoleTest");
        User user = new User();
        user.setId(null);
        user.setUsername("UsernameTest");
        user.setFullName("FullNameTest");
        user.setRole("RoleTest");

        when(userRepository.save(any(User.class))).thenReturn(user);

        //WHEN
        userService.creatingUser(userDTO);

        //THEN
        verify(userRepository, Mockito.times(1)).save(any(User.class));
    }

    @Test
    public void testCreatingEmptyUser() {
        //GIVEN

        //WHEN
        userService.creatingUser(null);

        //THEN
        verify(userRepository, Mockito.times(0)).save(new User());
    }

    @Test
    public void testReadingUser() {
        //GIVEN
        User user = new User();
        user.setId(1);
        user.setUsername("UsernameTest");
        user.setFullName("FullNameTest");
        user.setRole("RoleTest");

        when(userRepository.getById(1)).thenReturn(user);

        //WHEN
        userService.readingUser(1);

        //THEN
        verify(userRepository, Mockito.times(1)).getById(1);
    }

    @Test
    public void testReadingNotFoundUser() {
        //GIVEN

        //WHEN
        userService.readingUser(anyInt());

        //THEN
        verify(userRepository, Mockito.times(0)).getById(1);
    }

    @Test
    public void testReadingAllUser() {
        //GIVEN
        List<User> userList = new ArrayList<>();

        when(userRepository.findAll()).thenReturn(userList);

        //WHEN
        userService.readingAllUser();

        //THEN
        verify(userRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testUpdatingUser() {
        //GIVEN
        UserDTO userDTO = new UserDTO(1, "UsernameTestUpdated", "FullNameTestUpdated", "RoleTestUpdated");
        User user = new User();
        user.setId(1);
        user.setUsername("UsernameTestUpdated");
        user.setFullName("FullNameTestUpdated");
        user.setRole("RoleTestUpdated");

        Optional<User> userOptional = Optional.of(user);

        when(userRepository.findById(1)).thenReturn(userOptional);
        when(userRepository.save(any(User.class))).thenReturn(user);

        //WHEN
        userService.updatingUser(userDTO);

        //THEN
        verify(userRepository, Mockito.times(1)).findById(1);
        verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    public void testUpdatingEmptyUser() {
        //GIVEN

        //WHEN
        userService.updatingUser(null);

        //THEN
        verify(userRepository, Mockito.times(0)).save(new User());
    }

    @Test
    public void testUpdatingNotFoundUser() {
        //GIVEN
        UserDTO userDTO = new UserDTO(1, "UsernameTestUpdated", "FullNameTestUpdated", "RoleTestUpdated");

        when(userRepository.findById(1)).thenReturn(null);

        //WHEN
        userService.updatingUser(userDTO);

        //THEN
        verify(userRepository, Mockito.times(1)).findById(1);
        verify(userRepository, Mockito.times(0)).save(new User());
    }

    @Test
    public void testDeletingUser() {
        //GIVEN
        User user = new User();
        user.setId(1);
        user.setUsername("UsernameTest");
        user.setFullName("FullNameTest");
        user.setRole("RoleTest");

        Optional<User> userOptional = Optional.of(user);

        when(userRepository.findById(1)).thenReturn(userOptional);

        //WHEN
        userService.deletingUser(1);

        //THEN
        verify(userRepository, Mockito.times(1)).deleteById(1);
    }

    @Test
    public void testDeletingNotFoundUser() {
        //GIVEN
        when(userRepository.findById(1)).thenReturn(null);

        //WHEN
        userService.deletingUser(1);

        //THEN
        verify(userRepository, Mockito.times(1)).findById(1);
        verify(userRepository, Mockito.times(0)).deleteById(1);

    }
}
