import { Component, OnInit } from '@angular/core';
import { ApiServiceService } from '../api-service.service';

@Component({
  selector: 'app-user-component',
  templateUrl: './user-component.component.html',
  styleUrls: ['./user-component.component.css']
})
export class UserComponentComponent implements OnInit {

  constructor(private service:ApiServiceService) { }

  users;

  ngOnInit(): void {
    this.service.getUsers().subscribe(
      data => {
        this.users = data;
      }
    )
  }

}
