import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginMail } from './login-mail';
import { LoginPhone } from './login-phone';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})

export class AuthServiceService {

  url = "http://localhost:8080/api/auth/";
  
  constructor(private http:HttpClient) { }

  loginByMail(login:LoginMail):Observable<any> {
    return this.http.post(this.url + "loginByMail",login);
  }

  loginByPhone(login:LoginPhone):Observable<any> {
    return this.http.post(this.url + "loginByPhone", login);
  }

  sign_up(user:User):Observable<any> {
    return this.http.post(this.url + "user", user);
  }

  logout() {

  }

}
