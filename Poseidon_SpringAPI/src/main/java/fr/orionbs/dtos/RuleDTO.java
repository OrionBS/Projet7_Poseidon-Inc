package fr.orionbs.dtos;

import fr.orionbs.models.Rule;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class RuleDTO {
    private Integer id;
    private String name;
    private String description;
    private String json;
    private String template;
    private String sqlStr;
    private String sqlPart;

    @Override
    public String toString() {
        return "{\n" +
                "\"id\": \""+id+"\",\n" +
                "\"name\": \""+name+"\",\n" +
                "\"description\": \""+description+"\",\n" +
                "\"json\": \""+json+"\",\n" +
                "\"template\": \""+template+"\",\n" +
                "\"sqlStr\": \""+sqlStr+"\",\n" +
                "\"sqlPart\": \""+sqlPart+"\"\n" +
                '}';
    }
}
