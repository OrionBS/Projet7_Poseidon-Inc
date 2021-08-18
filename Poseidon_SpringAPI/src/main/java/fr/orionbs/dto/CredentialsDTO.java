package fr.orionbs.dto;

import fr.orionbs.models.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class CredentialsDTO {
    private String username;
    private String password;

    public CredentialsDTO userToCredentialsDto(User user) {
        return new CredentialsDTO(user.getUsername(),user.getPassword());
    }
}
