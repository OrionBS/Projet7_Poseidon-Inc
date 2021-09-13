package fr.orionbs.services.impl;

import fr.orionbs.dto.RuleDTO;
import fr.orionbs.models.Rule;
import fr.orionbs.repositories.RuleRepository;
import fr.orionbs.services.RuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class RuleServiceImpl implements RuleService {

    private RuleRepository ruleRepository;

    public RuleServiceImpl(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
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

    @Override
    public RuleDTO readingRule(Integer index) {
        log.info("Reading Rule Id {}", index);
        Rule rule = ruleRepository.getById(index);
        return new RuleDTO().ruleToRuleDTO(rule);
    }

    @Override
    public List<RuleDTO> readingAllRule() {
        log.info("Reading All Rules");
        RuleDTO ruleDTO = RuleDTO.builder().build();
        return ruleDTO.ruleToRuleDTOList(ruleRepository.findAll());
    }

    @Override
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

    @Override
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
