package fr.orionbs.services;

import fr.orionbs.dataTransferObjects.UserDTO;
import fr.orionbs.models.User;
import fr.orionbs.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean creatingUser(UserDTO userDTO) {

        if (userDTO == null) {
            log.info("User is empty");
            return false;
        }

        log.info("Creating User, {}", userDTO);
        User user = userDTO.userDtoToUser(userDTO);
        userRepository.save(user);
        return true;
    }

    public UserDTO readingUser(Integer index) {

        log.info("Reading User Id {}", index);
        User user = userRepository.getById(index);
        return new UserDTO().userToUserDTO(user);

    }

    public List<UserDTO> readingAllUser() {

        log.info("Reading All Users");
        UserDTO userDTO = UserDTO.builder().build();
        return userDTO.userToUserDTOList(userRepository.findAll());

    }

    public boolean updatingUser(UserDTO userDTO) {

        if (userDTO == null) {
            log.info("User is empty");
            return false;
        }

        if (userRepository.findById(userDTO.getId()) == null) {
            log.info("User doesn't exist");
            return false;
        }

        User user = userDTO.userDtoToUser(userDTO);
        log.info("Updating User, {}", userDTO);
        userRepository.save(user);
        return true;

    }

    public boolean deletingUser(Integer index) {

        if (userRepository.findById(index) == null) {
            log.info("User doesn't exist");
            return false;
        }
        userRepository.deleteById(index);
        log.info("Deleting User {}", index);
        return true;

    }
}
