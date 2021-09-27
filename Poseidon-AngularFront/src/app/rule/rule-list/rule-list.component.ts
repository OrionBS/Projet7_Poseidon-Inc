import { Component, OnInit } from '@angular/core';
import { Rule } from '../rule';
import { RuleService } from '../rule.service';

@Component({
  selector: 'app-rule-list',
  templateUrl: './rule-list.component.html',
  styleUrls: ['./rule-list.component.css']
})
export class RuleListComponent implements OnInit {

  ruleList: Rule[] = [];

  constructor(private ruleService: RuleService) { }

  ngOnInit(): void {
    this.ruleService.readingAllRule().subscribe(rules => this.ruleList = rules);
  }

  onDelete(id: any) {
    this.ruleService.deletingRule(id).subscribe();
    let indexOf = this.ruleList.findIndex(x =>x.id === id);
    this.ruleList.splice(indexOf,1);
  }

}
