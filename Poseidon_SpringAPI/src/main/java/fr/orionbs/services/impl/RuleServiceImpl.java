package fr.orionbs.services.impl;

import fr.orionbs.dtos.RuleDTO;
import fr.orionbs.mappers.RuleMapper;
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

    private final RuleRepository ruleRepository;
    private final RuleMapper ruleMapper;

    public RuleServiceImpl(RuleRepository ruleRepository, RuleMapper ruleMapper) {
        this.ruleRepository = ruleRepository;
        this.ruleMapper = ruleMapper;
    }

    @Override
    public boolean creatingRule(RuleDTO ruleDTO) {
        if (ruleDTO == null) {
            log.info("Rule is empty");
            return false;
        }

        log.info("Creating Rule, {}", ruleDTO);
        ruleRepository.save(ruleMapper.ruleDtoToRule(ruleDTO));
        return true;
    }

    @Override
    public RuleDTO readingRule(Integer index) {
        log.info("Reading Rule Id {}", index);
        Rule rule = ruleRepository.getById(index);
        return ruleMapper.ruleToRuleDTO(rule);
    }

    @Override
    public List<RuleDTO> readingAllRule() {
        log.info("Reading All Rules");
        return ruleMapper.ruleToRuleDTOList(ruleRepository.findAll());
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

        Rule rule = ruleMapper.ruleDtoToRule(ruleDTO);
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
