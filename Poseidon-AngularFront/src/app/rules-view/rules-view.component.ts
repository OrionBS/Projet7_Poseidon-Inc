import { Component, OnInit } from '@angular/core';

export interface RuleObject {
  id: number;
  name: string;
  description: string;
  json: string;
  template: string;
  sqlStr: string;
  sqlPart: string;
  action: any;
}

const ELEMENT_DATA: RuleObject[] = [
  {id: 1, name: 'Rule Name', description: 'Rule Description', json: 'Rule JSON', template:'Rule Template', sqlStr:'Rule Sql Str', sqlPart:'RuleSql Part', action:''},
  {id: 2, name: 'Rule Name', description: 'Rule Description', json: 'Rule JSON', template:'Rule Template', sqlStr:'Rule Sql Str', sqlPart:'RuleSql Part', action:''},
  {id: 3, name: 'Rule Name', description: 'Rule Description', json: 'Rule JSON', template:'Rule Template', sqlStr:'Rule Sql Str', sqlPart:'RuleSql Part', action:''},
  {id: 4, name: 'Rule Name', description: 'Rule Description', json: 'Rule JSON', template:'Rule Template', sqlStr:'Rule Sql Str', sqlPart:'RuleSql Part', action:''},
  {id: 5, name: 'Rule Name', description: 'Rule Description', json: 'Rule JSON', template:'Rule Template', sqlStr:'Rule Sql Str', sqlPart:'RuleSql Part', action:''},
  {id: 6, name: 'Rule Name', description: 'Rule Description', json: 'Rule JSON', template:'Rule Template', sqlStr:'Rule Sql Str', sqlPart:'RuleSql Part', action:''},
];

@Component({
  selector: 'app-rules-view',
  templateUrl: './rules-view.component.html',
  styleUrls: ['./rules-view.component.css']
})
export class RulesViewComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'description', 'json', 'template', 'sqlStr', 'sqlPart', 'action'];
  dataSource = ELEMENT_DATA;

  constructor() { }

  ngOnInit(): void {
  }

}
