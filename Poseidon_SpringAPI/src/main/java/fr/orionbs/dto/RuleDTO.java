package fr.orionbs.dto;

import fr.orionbs.models.Rule;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class RuleDTO {
    private Integer id;
    private String name;
    private String description;
    private String json;
    private String template;
    private String sqlStr;
    private String sqlPart;

    public RuleDTO ruleToRuleDTO(Rule rule) {
        return new RuleDTO(rule.getId(), rule.getName(), rule.getDescription(), rule.getJson(), rule.getTemplate(), rule.getSqlStr(), rule.getSqlPart());
    }

    public Rule ruleDtoToRule(RuleDTO ruleDTO) {
        return Rule.builder().id(ruleDTO.getId()).name(ruleDTO.getName()).description(ruleDTO.getDescription()).json(ruleDTO.getJson()).template(ruleDTO.getTemplate()).sqlStr(ruleDTO.getSqlStr()).sqlPart(ruleDTO.getSqlPart()).build();
    }

    public List<RuleDTO> ruleToRuleDTOList(List<Rule> ruleList) {
        List<RuleDTO> ruleDTOList = new ArrayList<>();
        for (Rule rule : ruleList) {
            RuleDTO ruleDTO = new RuleDTO(rule.getId(), rule.getName(), rule.getDescription(), rule.getJson(), rule.getTemplate(), rule.getSqlStr(), rule.getSqlPart());
            ruleDTOList.add(ruleDTO);
        }
        return ruleDTOList;
    }

    public List<Rule> ruleDtoToRuleList(List<RuleDTO> ruleDTOList) {
        List<Rule> ruleList = new ArrayList<>();
        for (RuleDTO ruleDTO : ruleDTOList) {
            Rule rule = Rule.builder().id(ruleDTO.getId()).name(ruleDTO.getName()).description(ruleDTO.getDescription()).json(ruleDTO.getJson()).template(ruleDTO.getTemplate()).sqlStr(ruleDTO.getSqlStr()).sqlPart(ruleDTO.getSqlPart()).build();
            ruleList.add(rule);
        }
        return ruleList;
    }
}
