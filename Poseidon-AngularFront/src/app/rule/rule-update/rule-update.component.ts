import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Rule } from '../rule';
import { RuleService } from '../rule.service';

@Component({
  selector: 'app-rule-update',
  templateUrl: './rule-update.component.html',
  styleUrls: ['./rule-update.component.css']
})
export class RuleUpdateComponent implements OnInit {

  updateRule: Rule = new Rule();

  constructor(private route: ActivatedRoute, private ruleService: RuleService) { }

  onUpdate() {
    this.ruleService.updatingRule(this.updateRule).subscribe();
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
       this.updateRule.id = +params['id'];
       });
    this.ruleService.readingRule(this.updateRule.id).subscribe(ruleFind => this.updateRule = ruleFind);
  }

}
