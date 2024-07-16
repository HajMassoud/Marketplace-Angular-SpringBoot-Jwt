import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Annonce } from 'src/app/model/annonce';
import { AnnonceService } from 'src/app/service/annonce.service';

@Component({
  selector: 'app-detail-annonce',
  templateUrl: './detail-annonce.component.html',
  styleUrls: ['./detail-annonce.component.scss']
})
export class DetailAnnonceComponent implements OnInit {
  id:number;
  annonce :Annonce;
  clientname:string;
  constructor(public annonService :AnnonceService, private router :ActivatedRoute,private routt:Router) { }

  
  ngOnInit(): void {
    this.id=this.router.snapshot.params['id'];
    this.clientname=this.router.snapshot.params['clientname'];
    this.annonce=new Annonce();
    this.annonService.getAnnonceById(this.id).subscribe(data =>{
      this.annonce=data;
    });
  }

}
