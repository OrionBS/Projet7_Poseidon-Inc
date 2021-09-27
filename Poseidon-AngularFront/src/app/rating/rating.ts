export class Rating {
	id?: number;
	moodysRating?: string;
	sAndPRating?: string;
	fitchRating?: string;
    orderNumber?: number;
	
	constructor(moodysRating?: string, sAndPRating?: string, fitchRating?: string, orderNumber?: number) {
		this.moodysRating = moodysRating;
		this.sAndPRating = sAndPRating;
		this.fitchRating = fitchRating;
		this.orderNumber = orderNumber;
	}

}
