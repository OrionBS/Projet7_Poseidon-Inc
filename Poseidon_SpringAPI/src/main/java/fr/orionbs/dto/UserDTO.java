package fr.orionbs.dto;

import fr.orionbs.models.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class UserDTO {
    private Integer id;
    private String userName;
    private String fullName;
    private String role;

    public UserDTO userToUserDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getFullName(), user.getRole());
    }

    public User userDtoToUser(UserDTO userDTO) {
        return User.builder().id(userDTO.getId()).username(userDTO.getUserName()).fullName(userDTO.getFullName()).role(userDTO.getRole()).build();
    }

    public List<UserDTO> userToUserDTOList(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            UserDTO userDTO = new UserDTO(user.getId(), user.getUsername(), user.getFullName(), user.getRole());
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    public List<User> userDtoToUserList(List<UserDTO> userDTOList) {
        List<User> userList = new ArrayList<>();
        for (UserDTO userDTO : userDTOList) {
            User user = User.builder().id(userDTO.getId()).username(userDTO.getUserName()).fullName(userDTO.getFullName()).role(userDTO.getRole()).build();
            userList.add(user);
        }
        return userList;
    }
}
