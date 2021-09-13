package fr.orionbs.security;

import fr.orionbs.dto.CredentialsDTO;
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

    public JwtUserDetailsService(UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CredentialsDTO credentialsDTO = new CredentialsDTO();
        credentialsDTO.userToCredentialsDto(userRepository.findByUsername(username));

        if (credentialsDTO != null) {
            return new User(credentialsDTO.getUsername(), credentialsDTO.getPassword(), Collections.emptyList());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
