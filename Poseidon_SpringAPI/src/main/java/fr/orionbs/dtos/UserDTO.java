package fr.orionbs.dtos;

import fr.orionbs.models.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class UserDTO {
    private Integer id;
    private String userName;
    private String fullName;
    private String role;

    @Override
    public String toString() {
        return "{\n" +
                "\"id\": \""+id+"\",\n" +
                "\"userName\": \""+userName+"\",\n" +
                "\"fullName\": \""+fullName+"\",\n" +
                "\"role\": \""+role+"\"\n" +
                '}';
    }
}
