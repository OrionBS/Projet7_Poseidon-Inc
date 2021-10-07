package fr.orionbs.services.impl;

import fr.orionbs.dtos.RuleDTO;
import fr.orionbs.mappers.RuleMapper;
import fr.orionbs.mappers.RuleMapper;
import fr.orionbs.models.Rule;
import fr.orionbs.models.Rule;
import fr.orionbs.repositories.RuleRepository;
import fr.orionbs.services.RuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class RuleServiceImpl implements RuleService {

    private final RuleRepository ruleRepository;
    private RuleMapper ruleMapper;

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

        ruleMapper = new RuleMapper();

        log.info("Creating Rule, {}", ruleDTO);
        ruleRepository.save(ruleMapper.ruleDtoToRule(ruleDTO));
        return true;
    }

    @Override
    public RuleDTO readingRule(Integer index) {
        log.info("Reading Rule Id {}", index);
        Rule rule = ruleRepository.getById(index);
        if(rule == null) {
            log.warn("Not found Rule Id {}", index);
            return null;
        }
        log.info("Rule found {}", rule);
        ruleMapper = new RuleMapper();
        return ruleMapper.ruleToRuleDTO(rule);
    }

    @Override
    public List<RuleDTO> readingAllRule() {
        log.info("Reading All Rules");
        ruleMapper = new RuleMapper();
        return ruleMapper.ruleToRuleDTOList(ruleRepository.findAll());
    }

    @Override
    public boolean updatingRule(RuleDTO ruleDTO) {
        if (ruleDTO == null) {
            log.info("Rule is empty");
            return false;
        }

        Optional<Rule> isRulePresent = ruleRepository.findById(ruleDTO.getId());

        if (isRulePresent == null) {
            log.info("Rule doesn't exist");
            return false;
        }

        Rule oldRule = isRulePresent.get();

        ruleMapper = new RuleMapper();
        Rule rule = ruleMapper.ruleDtoToRule(ruleDTO);

        oldRule.setName(rule.getName());
        oldRule.setDescription(rule.getDescription());
        oldRule.setJson(rule.getJson());
        oldRule.setTemplate(rule.getTemplate());
        oldRule.setSqlStr(rule.getSqlStr());
        oldRule.setSqlPart(rule.getSqlPart());

        log.info("Updating Rule, {}", oldRule);
        ruleRepository.save(oldRule);
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
