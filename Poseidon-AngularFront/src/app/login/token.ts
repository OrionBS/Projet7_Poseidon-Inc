export class Token {
    token = '';
    
    constructor(obj?: Partial<Token>) {
        Object.assign(this, obj);
    }
}