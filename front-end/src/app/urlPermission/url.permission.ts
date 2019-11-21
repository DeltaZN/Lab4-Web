import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable()
export class UrlPermission implements CanActivate {

  constructor(private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    let isAuthorized: boolean = !! localStorage.getItem('currentUser');

    if(!isAuthorized && state.url.match(/^\/(profile|check-point|history)$/ig)){
      this.router.navigate(['/login'], { queryParams: { returnUrl: state.url }});
      return false;
    }else if(isAuthorized && state.url.match(/^\/(login|register)$/ig)){
      this.router.navigate(['/profile']);
      return false;
    }

    return true;
  }
}
