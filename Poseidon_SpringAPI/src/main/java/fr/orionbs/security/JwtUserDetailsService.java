package fr.orionbs.security;

import fr.orionbs.dtos.CredentialsDTO;
import fr.orionbs.mappers.CredentialsMapper;
import fr.orionbs.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final CredentialsMapper credentialsMapper;

    public JwtUserDetailsService(UserRepository repository, CredentialsMapper credentialsMapper) {
        this.userRepository = repository;
        this.credentialsMapper = credentialsMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CredentialsDTO credentialsDTO = credentialsMapper.userToCredentialsDto(userRepository.findByUsername(username));

        if (credentialsDTO != null) {
            return new User(credentialsDTO.getUsername(), credentialsDTO.getPassword(), Collections.emptyList());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
