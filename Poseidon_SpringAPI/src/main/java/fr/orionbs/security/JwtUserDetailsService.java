package fr.orionbs.security;

import fr.orionbs.dtos.CredentialsDTO;
import fr.orionbs.repositories.UserRepository;
import fr.orionbs.services.MapperService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final MapperService mapperService;

    public JwtUserDetailsService(UserRepository repository, MapperService mapperService) {
        this.userRepository = repository;
        this.mapperService = mapperService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CredentialsDTO credentialsDTO = mapperService.userToCredentialsDto(userRepository.findByUsername(username));

        if (credentialsDTO != null) {
            return new User(credentialsDTO.getUsername(), credentialsDTO.getPassword(), Collections.emptyList());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
