package fr.orionbs.models;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "rule")
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private String json;
    private String template;
    private String sqlStr;
    private String sqlPart;

    @Override
    public String toString() {
        return "Rule{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", json='" + json + '\'' +
                ", template='" + template + '\'' +
                ", sqlStr='" + sqlStr + '\'' +
                ", sqlPart='" + sqlPart + '\'' +
                '}';
    }
}
