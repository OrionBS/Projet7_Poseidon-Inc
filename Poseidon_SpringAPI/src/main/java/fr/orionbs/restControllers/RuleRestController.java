package fr.orionbs.restControllers;

import fr.orionbs.dto.RuleDTO;
import fr.orionbs.services.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/rule")
public class RuleRestController {

    @Autowired
    RuleService ruleService;

    @PostMapping
    public ResponseEntity<Boolean> creatingRule(@RequestBody RuleDTO ruleDTO) {

        boolean answer = ruleService.creatingRule(ruleDTO);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/{index}")
    public ResponseEntity<RuleDTO> readingRule(@PathVariable(value = "index") Integer index) {

        RuleDTO ruleDTO = ruleService.readingRule(index);

        if (ruleDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ruleDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RuleDTO>> readingAllRule() {

        List<RuleDTO> ruleDTOList = ruleService.readingAllRule();

        return new ResponseEntity<>(ruleDTOList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Boolean> updatingRule(@RequestBody RuleDTO ruleDTO) {

        boolean answer = ruleService.updatingRule(ruleDTO);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deletingRule(@RequestParam(value = "index") Integer index) {

        boolean answer = ruleService.deletingRule(index);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
