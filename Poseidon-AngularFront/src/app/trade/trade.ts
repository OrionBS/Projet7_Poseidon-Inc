export class Trade {
	id?: number;
	account?: string;
	type?: string;
	buyQuantity?: number;
	
	constructor(account?: string, type?: string, buyQuantity?: number) {
		this.account = account;
		this.type = type;
		this.buyQuantity = buyQuantity;
	}

}