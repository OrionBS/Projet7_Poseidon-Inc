package fr.orionbs.mappers;

import fr.orionbs.dtos.RuleDTO;
import fr.orionbs.models.Rule;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RuleMapper {

    public RuleDTO ruleToRuleDTO(Rule rule) {
        RuleDTO ruleDTO = new RuleDTO(rule.getId(), rule.getName(), rule.getDescription(), rule.getJson(), rule.getTemplate(), rule.getSqlStr(), rule.getSqlPart());
        return ruleDTO;
    }

    public Rule ruleDtoToRule(RuleDTO ruleDTO) {
        Rule rule = new Rule();
        rule.setId(ruleDTO.getId());
        rule.setName(ruleDTO.getName());
        rule.setDescription(ruleDTO.getDescription());
        rule.setJson(ruleDTO.getJson());
        rule.setTemplate(ruleDTO.getTemplate());
        rule.setSqlStr(ruleDTO.getSqlStr());
        rule.setSqlPart(ruleDTO.getSqlPart());
        return rule;
    }

    public List<RuleDTO> ruleToRuleDTOList(List<Rule> ruleList) {
        List<RuleDTO> ruleDTOList = new ArrayList<>();
        for (Rule rule : ruleList) {
            RuleDTO ruleDTO = ruleToRuleDTO(rule);
            ruleDTOList.add(ruleDTO);
        }
        return ruleDTOList;
    }

    public List<Rule> ruleDtoToRuleList(List<RuleDTO> ruleDTOList) {
        List<Rule> ruleList = new ArrayList<>();
        for (RuleDTO ruleDTO : ruleDTOList) {
            Rule rule = ruleDtoToRule(ruleDTO);
            ruleList.add(rule);
        }
        return ruleList;
    }
}
