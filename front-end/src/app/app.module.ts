import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { FormsModule } from '@angular/forms';
import { AuthService } from "./services/auth.service";
import { HttpClientModule }   from '@angular/common/http';
import {AccountService} from "./services/account.service";
import { ProfileComponent } from './components/profile/profile.component';
import {routing} from "./app.routing";
import {FacebookModule} from "ngx-facebook";
import {UrlPermission} from "./urlPermission/url.permission";
import {HistoryComponent} from './components/history/history.component';
import {CheckPointComponent} from './components/check-point/check-point.component';
import {PointsService} from "./services/points.service";
import {HttpModule} from "@angular/http";
import {InfoComponent} from "./components/info/info.component";


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    HistoryComponent,
    CheckPointComponent,
    InfoComponent,

  ],
  imports: [
    BrowserModule,HttpClientModule, HttpModule, FormsModule,routing, FacebookModule.forRoot(),
  ],
  providers: [AuthService, AccountService, UrlPermission, PointsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
