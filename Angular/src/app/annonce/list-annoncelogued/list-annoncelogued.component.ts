import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AnnonceService } from 'src/app/service/annonce.service';

@Component({
  selector: 'app-list-annoncelogued',
  templateUrl: './list-annoncelogued.component.html',
  styleUrls: ['./list-annoncelogued.component.scss']
})
export class ListAnnonceloguedComponent implements OnInit {
name;
id;
clientname;
  constructor(public service:AnnonceService,private router : Router) { }

  ngOnInit(): void {
    this.name=localStorage.getItem('username');
    this.id=localStorage.getItem('idUser');
    this.clientname=localStorage.getItem('username');
    this.getData();
  }

  getData() {
    this.service.getAll2().subscribe(
      response =>{this.service.list = response;}
     );

  }

  detailsClient(clientname: number){
    this.router.navigate(['detail-clientpanier', clientname]);
  }

  detailsAnnonce(id: number){
    this.router.navigate(['DetailAnnonce', id]);
  }

}
