package fr.orionbs.security;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class JwtRequest {
    private String username;
    private String password;
}
