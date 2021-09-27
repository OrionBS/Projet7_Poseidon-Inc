export class User {
	id?: number;
	userName?: string;
    fullName?: string;
    role?: string;
	
	constructor(userName?: string, fullName?: string, role?: string) {
		this.userName = userName;
        this.fullName = fullName;
        this.role = role;
	}

}