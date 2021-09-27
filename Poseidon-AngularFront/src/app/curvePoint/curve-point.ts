export class CurvePoint {
	id?: number;
    curveId?: number;
	term?: number;
	value?: number;
	
	constructor(curveId?: number, term?: number, value?: number) {
		this.curveId = curveId;
		this.term = term;
		this.value = value;
	}

}
