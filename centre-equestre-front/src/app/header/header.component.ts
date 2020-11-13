import { ResourceLoader } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private route:Router) { }
  
  user = null;
  titre;

  isLoggedIn = false;
  isAdmin = false;
  isMoniteur = true;
  isUser = false;

  ngOnInit(): void {
    this.user = localStorage.getItem('user');
      if(this.user != null){
        this.titre = this.user.prenom;
        this.isLoggedIn = false;

        if(localStorage.getItem('role') === 'USER') {
          this.isUser = true;
        }
        if(localStorage.getItem('role') === 'MONITEUR') {
          this.isMoniteur = true;
        }
        if(localStorage.getItem('role') === 'ADMIN') {
          this.isAdmin = true;
        }
    }
  }

  logout() {
    localStorage.removeItem('user');
    localStorage.removeItem('role');
    this.route.navigate(['/home']);
  }

}
