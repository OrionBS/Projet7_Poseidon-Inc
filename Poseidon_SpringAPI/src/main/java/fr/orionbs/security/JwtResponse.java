package fr.orionbs.security;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class JwtResponse {
    private String token;
}
