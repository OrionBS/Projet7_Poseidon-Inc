package fr.orionbs.ApplicationTest.servicesTest;

import fr.orionbs.dtos.RuleDTO;
import fr.orionbs.models.Rule;
import fr.orionbs.repositories.RuleRepository;
import fr.orionbs.services.impl.RuleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RuleServiceTest {

    @InjectMocks
    private RuleServiceImpl ruleService;

    @Mock
    RuleRepository ruleRepository;

    @Test
    public void testCreatingRule() {
        //GIVEN
        RuleDTO ruleDTO = new RuleDTO(1, "NameTest", "DescTest", "JsonTest","TemplateTest","SqlTest","SqlPartTest");
        Rule rule = new Rule();
        rule.setId(1);
        rule.setName("NameTest");
        rule.setDescription("DescTest");
        rule.setJson("JsonTest");
        rule.setTemplate("TemplateTest");
        rule.setSqlStr("SqlTest");
        rule.setSqlPart("SqlPartTest");

        when(ruleRepository.save(any(Rule.class))).thenReturn(rule);

        //WHEN
        ruleService.creatingRule(ruleDTO);

        //THEN
        verify(ruleRepository, Mockito.times(1)).save(any(Rule.class));
    }

    @Test
    public void testCreatingEmptyRule() {
        //GIVEN

        //WHEN
        ruleService.creatingRule(null);

        //THEN
        verify(ruleRepository, Mockito.times(0)).save(new Rule());
    }

    @Test
    public void testReadingRule() {
        //GIVEN
        Rule rule = new Rule();
        rule.setId(1);
        rule.setName("NameTest");
        rule.setDescription("DescTest");
        rule.setJson("JsonTest");
        rule.setTemplate("TemplateTest");
        rule.setSqlStr("SqlTest");
        rule.setSqlPart("SqlPartTest");

        when(ruleRepository.getById(1)).thenReturn(rule);

        //WHEN
        ruleService.readingRule(1);

        //THEN
        verify(ruleRepository, Mockito.times(1)).getById(1);
    }

    @Test
    public void testReadingNotFoundRule() {
        //GIVEN

        //WHEN
        ruleService.readingRule(anyInt());

        //THEN
        verify(ruleRepository, Mockito.times(0)).getById(1);
    }

    @Test
    public void testReadingAllRule() {
        //GIVEN
        List<Rule> ruleList = new ArrayList<>();

        when(ruleRepository.findAll()).thenReturn(ruleList);

        //WHEN
        ruleService.readingAllRule();

        //THEN
        verify(ruleRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testUpdatingRule() {
        //GIVEN
        RuleDTO ruleDTO = new RuleDTO(1, "NameTestUpdated", "DescTestUpdated", "JsonTestUpdated","TemplateTestUpdated","SqlTestUpdated","SqlPartTestUpdated");
        Rule rule = new Rule();
        rule.setId(1);
        rule.setName("NameTestUpdated");
        rule.setDescription("DescTestUpdated");
        rule.setJson("JsonTestUpdated");
        rule.setTemplate("TemplateTestUpdated");
        rule.setSqlStr("SqlTestUpdated");
        rule.setSqlPart("SqlPartTestUpdated");

        Optional<Rule> ruleOptional = Optional.of(rule);

        when(ruleRepository.findById(1)).thenReturn(ruleOptional);
        when(ruleRepository.save(any(Rule.class))).thenReturn(rule);

        //WHEN
        ruleService.updatingRule(ruleDTO);

        //THEN
        verify(ruleRepository, Mockito.times(1)).findById(1);
        verify(ruleRepository, Mockito.times(1)).save(rule);
    }

    @Test
    public void testUpdatingEmptyRule() {
        //GIVEN

        //WHEN
        ruleService.updatingRule(null);

        //THEN
        verify(ruleRepository, Mockito.times(0)).save(new Rule());
    }

    @Test
    public void testUpdatingNotFoundRule() {
        //GIVEN
        RuleDTO ruleDTO = new RuleDTO(1, "NameTestUpdated", "DescTestUpdated", "JsonTestUpdated","TemplateTestUpdated","SqlTestUpdated","SqlPartTestUpdated");

        when(ruleRepository.findById(1)).thenReturn(null);

        //WHEN
        ruleService.updatingRule(ruleDTO);

        //THEN
        verify(ruleRepository, Mockito.times(1)).findById(1);
        verify(ruleRepository, Mockito.times(0)).save(new Rule());
    }

    @Test
    public void testDeletingRule() {
        //GIVEN
        Rule rule = new Rule();
        rule.setId(1);
        rule.setName("NameTestUpdated");
        rule.setDescription("DescTestUpdated");
        rule.setJson("JsonTestUpdated");
        rule.setTemplate("TemplateTestUpdated");
        rule.setSqlStr("SqlTestUpdated");
        rule.setSqlPart("SqlPartTestUpdated");

        Optional<Rule> ruleOptional = Optional.of(rule);

        when(ruleRepository.findById(1)).thenReturn(ruleOptional);

        //WHEN
        ruleService.deletingRule(1);

        //THEN
        verify(ruleRepository, Mockito.times(1)).deleteById(1);
    }

    @Test
    public void testDeletingNotFoundRule() {
        //GIVEN
        when(ruleRepository.findById(1)).thenReturn(null);

        //WHEN
        ruleService.deletingRule(1);

        //THEN
        verify(ruleRepository, Mockito.times(1)).findById(1);
        verify(ruleRepository, Mockito.times(0)).deleteById(1);

    }
}
