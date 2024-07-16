import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {
id;
adminname;
  constructor(public userService:UserService,private router:Router) { }

  ngOnInit(): void {
    this.id =  localStorage.getItem('id');
    this.adminname=localStorage.getItem('username');
  }

  wenttocat(){
    this.router.navigate(['/categories']).then(() => {
      window.location.reload();
    });
  }

  logOut() {
    localStorage.removeItem("adminname");
    localStorage.removeItem("token");
    this.userService.tokenStr='';
    this.router.navigate(["/accueil"]);
  }
}
