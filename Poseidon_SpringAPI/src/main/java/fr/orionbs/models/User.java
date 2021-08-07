package fr.orionbs.models;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String username;
    private String password;
    private String fullName;
    private String role;
}
