package fr.orionbs.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ErrorAnswer {
    private String errorCode;
    private String errorMessage;
}
