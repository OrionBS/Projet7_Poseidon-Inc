package fr.orionbs.services;

import fr.orionbs.dto.CredentialsDTO;
import fr.orionbs.dto.TokenDTO;
import fr.orionbs.dto.UserDTO;

import java.util.List;

public interface UserService {
    boolean creatingUser(UserDTO userDTO);

    UserDTO readingUser(Integer index);

    List<UserDTO> readingAllUser();

    boolean updatingUser(UserDTO userDTO);

    boolean deletingUser(Integer index);

    TokenDTO register(CredentialsDTO registrationDTO);
}
