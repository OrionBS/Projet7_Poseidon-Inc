package fr.orionbs.restControllers;

import fr.orionbs.dataTransferObjects.RuleDTO;
import fr.orionbs.services.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RuleRestController {

    @Autowired
    RuleService ruleService;

    @PostMapping(path = "/rule/creating")
    public boolean creatingRule(RuleDTO ruleDTO) {
        boolean answer = ruleService.creatingRule(ruleDTO);
        if (answer) {
            return true;
        }
        return false;
    }

    @GetMapping(path = "/rule/reading")
    public RuleDTO readingRule(Integer index) {
        return ruleService.readingRule(index);
    }

    @GetMapping(path = "/rule/readingAll")
    public List<RuleDTO> readingAllRule() {
        return ruleService.readingAllRule();
    }

    @PutMapping(path = "/rule/updating")
    public boolean updatingRule(RuleDTO ruleDTO) {
        boolean answer = ruleService.updatingRule(ruleDTO);
        if (answer) {
            return true;
        }
        return false;
    }

    @DeleteMapping(path = "/rule/deleting")
    public boolean deletingRule(Integer index) {
        boolean answer = ruleService.deletingRule(index);
        if (answer) {
            return true;
        }
        return false;
    }
}
