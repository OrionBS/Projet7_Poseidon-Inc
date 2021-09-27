export class Bid {
	id?: number;
	account: string;
	type: string;
	bidQuantity?: number;
	
	constructor(account: string, type: string, bidQuantity?: number) {
		this.account = account;
		this.type = type;
		this.bidQuantity = bidQuantity;
	}

}