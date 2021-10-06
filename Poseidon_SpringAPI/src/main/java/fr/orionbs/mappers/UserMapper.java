package fr.orionbs.mappers;

import fr.orionbs.dtos.UserDTO;
import fr.orionbs.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO(user.getId(), user.getUsername(), user.getFullName(), user.getRole());
        return userDTO;
    }

    public User userDtoToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUserName());
        user.setFullName(userDTO.getFullName());
        user.setRole(userDTO.getRole());
        return user;
    }

    public List<UserDTO> userToUserDTOList(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            UserDTO userDTO = userToUserDTO(user);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    public List<User> userDtoToUserList(List<UserDTO> userDTOList) {
        List<User> userList = new ArrayList<>();
        for (UserDTO userDTO : userDTOList) {
            User user = userDtoToUser(userDTO);
            userList.add(user);
        }
        return userList;
    }
}
