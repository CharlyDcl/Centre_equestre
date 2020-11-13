import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';
import { Cours } from './cours';


@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  url = "http://localhost:8080/api/";
  
  constructor(private http:HttpClient) { }

  getUsers():Observable<any> {
    return this.http.get(this.url + "user");
  }

  addUser(user:User):Observable<any> {
    return this.http.post(this.url + "user", user);
  }

  deleteUser(id:number):Observable<any> {
    return this.http.delete(this.url + "user/" + id);
  }

  getCours():Observable<any> {
    return this.http.get(this.url + "cours");
  }

  addCours(cours:Cours):Observable<any> {
    return this.http.post(this.url + "cours", cours);
  }

  deleteCours(id:number):Observable<any> {
    return this.http.delete(this.url + "cours/" + id);
  }
  
}
