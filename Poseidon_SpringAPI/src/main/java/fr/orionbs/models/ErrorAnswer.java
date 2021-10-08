package fr.orionbs.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ErrorAnswer {
    private String errorCode;
    private String errorMessage;

    @Override
    public String toString() {
        return "ErrorAnswer{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
