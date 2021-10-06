package fr.orionbs.services.impl;

import fr.orionbs.dtos.CredentialsDTO;
import fr.orionbs.dtos.TokenDTO;
import fr.orionbs.dtos.UserDTO;
import fr.orionbs.mappers.UserMapper;
import fr.orionbs.models.User;
import fr.orionbs.repositories.UserRepository;
import fr.orionbs.security.JwtTokenUtil;
import fr.orionbs.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(JwtTokenUtil jwtTokenUtil, UserRepository userRepository, UserMapper userMapper) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean creatingUser(UserDTO userDTO) {
        if (userDTO == null) {
            log.info("User is empty");
            return false;
        }

        log.info("Creating User, {}", userDTO);
        userRepository.save(userMapper.userDtoToUser(userDTO));
        return true;
    }

    @Override
    public UserDTO readingUser(Integer index) {
        log.info("Reading User Id {}", index);
        User user = userRepository.getById(index);
        return userMapper.userToUserDTO(user);
    }

    @Override
    public List<UserDTO> readingAllUser() {
        log.info("Reading All Users");
        return userMapper.userToUserDTOList(userRepository.findAll());
    }

    @Override
    public boolean updatingUser(UserDTO userDTO) {
        if (userDTO == null) {
            log.info("User is empty");
            return false;
        }

        Optional<User> isUserPresent = userRepository.findById(userDTO.getId());

        User oldUser = isUserPresent.get();

        if (userRepository.findById(userDTO.getId()) == null) {
            log.info("User doesn't exist");
            return false;
        }

        User user = userMapper.userDtoToUser(userDTO);

        oldUser.setFullName(user.getFullName());
        oldUser.setRole(user.getRole());
        oldUser.setUsername(user.getUsername());


        log.info("Updating User, {}", userDTO);
        userRepository.save(oldUser);
        return true;
    }

    @Override
    public boolean deletingUser(Integer index) {
        if (userRepository.findById(index) == null) {
            log.info("User doesn't exist");
            return false;
        }
        userRepository.deleteById(index);
        log.info("Deleting User {}", index);
        return true;
    }

    @Override
    public TokenDTO register(CredentialsDTO registrationDTO) {
        User user = new User();

        if (registrationDTO.getUsername() == null) {
            log.error("Username null.");
            return null;
            //TODO throw exception;
        }
        user.setUsername(registrationDTO.getUsername());
        if (registrationDTO.getPassword() == null) {
            log.error("Password null.");
            return null;
            //TODO throw exception;

        }
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));

        log.info("Registration User {}", user);
        final User save = userRepository.save(user);
        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(save.getUsername(), save.getPassword(), Collections.emptyList());
        return new TokenDTO(jwtTokenUtil.generateToken(userDetails));
    }
}
