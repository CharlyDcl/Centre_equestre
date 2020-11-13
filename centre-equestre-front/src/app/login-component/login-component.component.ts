import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from '../auth-service.service';
import { HeaderComponent } from '../header/header.component';
import { LoginMail } from '../login-mail';
import { LoginPhone } from '../login-phone';
import { User } from '../user';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {

  loginMail = new LoginMail();
  loginPhone = new LoginPhone();

  constructor(private route:Router, private service:AuthServiceService) { }

  loginByMail() {

    this.service.loginByMail(this.loginMail).subscribe(
      data => {
        localStorage.setItem('user', data);
        localStorage.setItem('role', data.role);
        this.route.navigate(['/home']);
      }
    )
  }

  loginByPhone() {

    this.service.loginByPhone(this.loginPhone).subscribe(
      data => {
        localStorage.setItem('user', data);
        localStorage.setItem('role', data.role);
        this.route.navigate(['/home']);
      }
    )
  }

  ngOnInit(): void {
  }

}
