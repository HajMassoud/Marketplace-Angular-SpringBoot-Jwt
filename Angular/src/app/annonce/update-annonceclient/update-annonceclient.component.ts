import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { AnnonceService } from 'src/app/service/annonce.service';
import { Annonce } from 'src/app/model/annonce';

@Component({
  selector: 'app-update-annonceclient',
  templateUrl: './update-annonceclient.component.html',
  styleUrls: ['./update-annonceclient.component.scss']
})
export class UpdateAnnonceclientComponent implements OnInit {
  id:number;
  annonce :Annonce=new Annonce;
  constructor(private location :Location,private annonceService:AnnonceService,    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.annonceService.getAnnonceById(this.id).subscribe(data => {
      this.annonce = data;
    }, error => console.log(error));
  }
  onSubmit(){
    this.annonceService.updateAnnonce(this.id, this.annonce).subscribe(data =>{this.close()})
  }
  close(){
    this.location.back();
  }
}
