import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AnnonceService } from 'src/app/service/annonce.service';

@Component({
  selector: 'app-list-annonce',
  templateUrl: './list-annonce.component.html',
  styleUrls: ['./list-annonce.component.scss']
})
export class ListAnnonceComponent implements OnInit {

  constructor(public service:AnnonceService,private router :Router) { }

  ngOnInit(): void {
    this.getData();
  }

  getData() {
    this.service.getAll2().subscribe(
      response =>{this.service.list = response;}
     );

  }

  detailsAnnonce(id: number){
    this.router.navigate(['DetailAnnonce', id]);
  }

}
