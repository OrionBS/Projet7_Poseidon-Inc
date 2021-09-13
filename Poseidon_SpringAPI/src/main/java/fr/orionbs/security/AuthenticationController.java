package fr.orionbs.security;

import fr.orionbs.dtos.CredentialsDTO;
import fr.orionbs.dtos.TokenDTO;
import fr.orionbs.services.UserService;
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

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;
    private final UserService userService;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, JwtUserDetailsService userDetailsService, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

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
