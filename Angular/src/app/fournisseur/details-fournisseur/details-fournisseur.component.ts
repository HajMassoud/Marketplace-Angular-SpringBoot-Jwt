import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Fournisseur } from 'src/app/model/fournisseur';
import { FournisseurService } from 'src/app/service/fournisseur.service';

@Component({
  selector: 'app-details-fournisseur',
  templateUrl: './details-fournisseur.component.html',
  styleUrls: ['./details-fournisseur.component.scss']
})
export class DetailsFournisseurComponent implements OnInit {
  id:number;
  fournisseur :Fournisseur;
  constructor(private fournisseurService :FournisseurService, private router :ActivatedRoute) { }

  ngOnInit(): void {
    this.id=this.router.snapshot.params['id'];

    this.fournisseur=new Fournisseur();
    this.fournisseurService.getFournisseurById(this.id).subscribe(data =>{
      this.fournisseur=data;
    });
  }

}
