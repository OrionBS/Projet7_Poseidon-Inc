package fr.orionbs.ApplicationTest.unitTests.restControllersTest;

import fr.orionbs.dtos.RuleDTO;
import fr.orionbs.restControllers.RuleRestController;
import fr.orionbs.services.impl.RuleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RuleRestControllerTest {

    @InjectMocks
    RuleRestController ruleRestController;

    @Mock
    RuleServiceImpl ruleService;

    @Test
    public void testCreatingRule() {
        //GIVEN
        RuleDTO ruleDTO = new RuleDTO(0, "NameTest", "DescTest", "JsonTest", "TemplateTest", "SqlStrTest", "SqlPartTest");
        when(ruleService.creatingRule(any(RuleDTO.class))).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = ruleRestController.creatingRule(ruleDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.CREATED));
        verify(ruleService, Mockito.times(1)).creatingRule(ruleDTO);
    }

    @Test
    public void testCreatingRuleIdFilled() {
        //GIVEN
        RuleDTO ruleDTO = new RuleDTO(1, "NameTest", "DescTest", "JsonTest", "TemplateTest", "SqlStrTest", "SqlPartTest");
        when(ruleService.creatingRule(any(RuleDTO.class))).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = ruleRestController.creatingRule(ruleDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.BAD_REQUEST));
        verify(ruleService, Mockito.times(1)).creatingRule(ruleDTO);
    }

    @Test
    public void testReadingRule() {
        //GIVEN
        RuleDTO ruleDTO = new RuleDTO(1, "NameTest", "DescTest", "JsonTest", "TemplateTest", "SqlStrTest", "SqlPartTest");
        when(ruleService.readingRule(1)).thenReturn(ruleDTO);

        //WHEN
        ResponseEntity<RuleDTO> answer = ruleRestController.readingRule(1);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(ruleDTO, HttpStatus.OK));
        verify(ruleService, Mockito.times(1)).readingRule(1);
    }

    @Test
    public void testReadingNullIdRule() {
        //GIVEN
        when(ruleService.readingRule(null)).thenReturn(null);

        //WHEN
        ResponseEntity<RuleDTO> answer = ruleRestController.readingRule(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        verify(ruleService, Mockito.times(1)).readingRule(null);
    }

    @Test
    public void testReadingAllRule() {
        //GIVEN
        RuleDTO ruleDTO = new RuleDTO(1, "NameTest", "DescTest", "JsonTest", "TemplateTest", "SqlStrTest", "SqlPartTest");
        RuleDTO ruleDTO2 = new RuleDTO(2, "NameTest2", "DescTest2", "JsonTest2", "TemplateTest2", "SqlStrTest2", "SqlPartTest2");
        when(ruleService.readingAllRule()).thenReturn(Arrays.asList(ruleDTO, ruleDTO2));

        //WHEN
        ResponseEntity<List<RuleDTO>> answer = ruleRestController.readingAllRule();

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(Arrays.asList(ruleDTO, ruleDTO2), HttpStatus.OK));
        verify(ruleService, Mockito.times(1)).readingAllRule();
    }

    @Test
    public void testUpdatingRule() {
        //GIVEN
        RuleDTO ruleDTO = new RuleDTO(1, "NameTest", "DescTest", "JsonTest", "TemplateTest", "SqlStrTest", "SqlPartTest");
        when(ruleService.updatingRule(ruleDTO)).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = ruleRestController.updatingRule(ruleDTO);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.OK));
        verify(ruleService, Mockito.times(1)).updatingRule(ruleDTO);
    }

    @Test
    public void testUpdatingNotFoundRule() {
        //GIVEN
        when(ruleService.updatingRule(null)).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = ruleRestController.updatingRule(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.NOT_FOUND));
        verify(ruleService, Mockito.times(1)).updatingRule(null);
    }

    @Test
    public void testDeletingRule() {
        //GIVEN
        when(ruleService.deletingRule(1)).thenReturn(true);

        //WHEN
        ResponseEntity<Boolean> answer = ruleRestController.deletingRule(1);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(true, HttpStatus.OK));
        verify(ruleService, Mockito.times(1)).deletingRule(1);
    }

    @Test
    public void testDeletingNotFoundRule() {
        //GIVEN
        when(ruleService.deletingRule(null)).thenReturn(false);

        //WHEN
        ResponseEntity<Boolean> answer = ruleRestController.deletingRule(null);

        //THEN
        assertThat(answer).isEqualTo(new ResponseEntity<>(false, HttpStatus.NOT_FOUND));
        verify(ruleService, Mockito.times(1)).deletingRule(null);
    }

}
