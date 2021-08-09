package fr.orionbs.models;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String moodysRating;
    private String sAndPRating;
    private String fitchRating;
    private Integer orderNumber;
}
