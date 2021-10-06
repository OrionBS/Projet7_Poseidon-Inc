package fr.orionbs.mappers;

import fr.orionbs.dtos.CredentialsDTO;
import fr.orionbs.models.User;
import org.springframework.stereotype.Component;

@Component
public class CredentialsMapper {

    public CredentialsDTO userToCredentialsDto(User user) {
        CredentialsDTO credentialsDTO = new CredentialsDTO(user.getUsername(), user.getPassword());
        return credentialsDTO;
    }
}
