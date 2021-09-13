package fr.orionbs.security;

import fr.orionbs.dto.CredentialsDTO;
import fr.orionbs.dto.TokenDTO;
import fr.orionbs.services.UserService;
import fr.orionbs.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<TokenDTO> register(@RequestBody CredentialsDTO credentialsDTO) {

        return new ResponseEntity<>(userService.register(credentialsDTO), HttpStatus.CREATED);
    }

    @PostMapping(path = "/authenticate")
    public ResponseEntity<TokenDTO> createAuthenticationToken(@RequestBody CredentialsDTO credentialsDTO) throws Exception {

        authenticate(credentialsDTO.getUsername(), credentialsDTO.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(credentialsDTO.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return new ResponseEntity<>(new TokenDTO(token), HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
