package fr.orionbs.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class RatingDTO {
    private Integer id;
    private String moodysRating;
    private String sAndPRating;
    private String fitchRating;
    private Integer orderNumber;

    @Override
    public String toString() {
        return "{\n" +
                "\"id\": \""+id+"\",\n" +
                "\"moodysRating\": \""+id+"\",\n" +
                "\"sAndPRating\": \""+sAndPRating+"\",\n" +
                "\"fitchRating\": \""+fitchRating+"\",\n" +
                "\"orderNumber\": \""+orderNumber+"\"\n" +
                '}';
    }
}
