import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {User} from "../../model/model.user";
import {Router} from "@angular/router";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
  encapsulation: ViewEncapsulation.None
})
// TODO: rename component profile -> home
export class ProfileComponent implements OnInit {
  currentUser: User;
  section: string;

  constructor(public authService: AuthService, public router: Router) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  ngOnInit() {
    this.section = window.location.pathname.substr(1);
  }

// login out from the app
  logOut() {
    this.authService.logOut()
      .subscribe(
        data => {
          this.router.navigate(['/login']);
        },
        error => {

        });
  }

  showMoreInfo() {
    let infoBlock = document.getElementById('more-info');
    infoBlock.style.visibility = infoBlock.style.visibility?'':'hidden';
  }

  changeSection(section: string) {
    this.section = section;
  }
}
