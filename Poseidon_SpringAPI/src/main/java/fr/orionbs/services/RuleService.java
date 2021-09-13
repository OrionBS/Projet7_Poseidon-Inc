package fr.orionbs.services;

import fr.orionbs.dto.RuleDTO;

import java.util.List;

public interface RuleService {
    boolean creatingRule(RuleDTO ruleDTO);

    RuleDTO readingRule(Integer index);

    List<RuleDTO> readingAllRule();

    boolean updatingRule(RuleDTO ruleDTO);

    boolean deletingRule(Integer index);
}
