import { Component, OnInit } from '@angular/core';
import { Rule } from '../rule';
import { RuleService } from '../rule.service';

@Component({
  selector: 'app-rule-add',
  templateUrl: './rule-add.component.html',
  styleUrls: ['./rule-add.component.css']
})
export class RuleAddComponent implements OnInit {

  newRule: Rule = new Rule();

  constructor(private ruleService: RuleService) { }

  onAdd(): void {
    this.ruleService.creatingRule(this.newRule).subscribe();
  }

  ngOnInit(): void {
  }

}
