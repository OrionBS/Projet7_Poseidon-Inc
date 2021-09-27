export class Rule {
	id?: number;
	name?: string;
    description?: string;
    json?: string;
    template?: string;
    sqlStr?: string;
    sqlPart?: string;
	
	constructor(name?: string, description?: string, json?: string, template?: string, sqlStr?: string, sqlPart?: string) {
		this.name = name;
        this.description = description;
        this.json = json;
        this.template = template;
        this.sqlStr = sqlStr;
        this.sqlPart = sqlPart;
	}

}
