export class Rating {
	id?: number;
	moodysRating?: string;
	sandPRating?: string;
	fitchRating?: string;
    orderNumber?: number;
	
	constructor(moodysRating?: string, sandPRating?: string, fitchRating?: string, orderNumber?: number) {
		this.moodysRating = moodysRating;
		this.sandPRating = sandPRating;
		this.fitchRating = fitchRating;
		this.orderNumber = orderNumber;
	}

}
