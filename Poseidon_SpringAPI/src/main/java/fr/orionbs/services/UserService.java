package fr.orionbs.services;

import fr.orionbs.dtos.CredentialsDTO;
import fr.orionbs.dtos.TokenDTO;
import fr.orionbs.dtos.UserDTO;

import java.util.List;

public interface UserService {
    boolean creatingUser(UserDTO userDTO);

    UserDTO readingUser(Integer index);

    List<UserDTO> readingAllUser();

    boolean updatingUser(UserDTO userDTO);

    boolean deletingUser(Integer index);

    TokenDTO register(CredentialsDTO registrationDTO);
}
