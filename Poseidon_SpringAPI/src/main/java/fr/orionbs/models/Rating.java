package fr.orionbs.models;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String moodysRating;
    private String sAndPRating;
    private String fitchRating;
    private Integer orderNumber;

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", moodysRating='" + moodysRating + '\'' +
                ", sAndPRating='" + sAndPRating + '\'' +
                ", fitchRating='" + fitchRating + '\'' +
                ", orderNumber=" + orderNumber +
                '}';
    }
}
