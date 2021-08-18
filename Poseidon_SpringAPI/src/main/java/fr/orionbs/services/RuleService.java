package fr.orionbs.services;

import fr.orionbs.dto.RuleDTO;
import fr.orionbs.models.Rule;
import fr.orionbs.repositories.RuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class RuleService {

    @Autowired
    RuleRepository ruleRepository;

    public boolean creatingRule(RuleDTO ruleDTO) {

        if (ruleDTO == null) {
            log.info("Rule is empty");
            return false;
        }

        log.info("Creating Rule, {}", ruleDTO);
        Rule rule = ruleDTO.ruleDtoToRule(ruleDTO);
        ruleRepository.save(rule);
        return true;
    }

    public RuleDTO readingRule(Integer index) {

        log.info("Reading Rule Id {}", index);
        Rule rule = ruleRepository.getById(index);
        return new RuleDTO().ruleToRuleDTO(rule);

    }

    public List<RuleDTO> readingAllRule() {

        log.info("Reading All Rules");
        RuleDTO ruleDTO = RuleDTO.builder().build();
        return ruleDTO.ruleToRuleDTOList(ruleRepository.findAll());

    }

    public boolean updatingRule(RuleDTO ruleDTO) {

        if (ruleDTO == null) {
            log.info("Rule is empty");
            return false;
        }

        if (ruleRepository.findById(ruleDTO.getId()) == null) {
            log.info("Rule doesn't exist");
            return false;
        }

        Rule rule = ruleDTO.ruleDtoToRule(ruleDTO);
        log.info("Updating Rule, {}", ruleDTO);
        ruleRepository.save(rule);
        return true;

    }

    public boolean deletingRule(Integer index) {

        if (ruleRepository.findById(index) == null) {
            log.info("Rule doesn't exist");
            return false;
        }
        ruleRepository.deleteById(index);
        log.info("Deleting Rule {}", index);
        return true;

    }
}
