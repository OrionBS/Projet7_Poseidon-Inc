package fr.orionbs.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class RatingDTO {
    private Integer id;
    private String moodysRating;
    private String sAndPRating;
    private String fitchRating;
    private Integer orderNumber;
}
