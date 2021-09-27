import { HttpErrorResponse, HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { tap } from "rxjs/operators";
import { AuthenticateService } from "./login/authenticate.service";

@Injectable({
    providedIn: 'root',
})
export class JwtInterceptor implements HttpInterceptor {
    constructor(private auth: AuthenticateService, private router: Router) {
    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const jwt = this.auth.getJwt();
        const headers = new HttpHeaders({
            Authorization: `Bearer ${jwt}`,
        });
        return next.handle(req.clone({headers})).pipe(tap(() => {}, err => {
            if (err instanceof HttpErrorResponse && [401, 403].includes(err.status)) {
                localStorage.removeItem(AuthenticateService.TOKEN);
                this.router.navigate(['/login']);
            }
        }));
    }

}
