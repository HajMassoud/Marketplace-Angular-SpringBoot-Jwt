import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fournisseur } from 'src/app/model/fournisseur';
import { FournisseurService } from 'src/app/service/fournisseur.service';

@Component({
  selector: 'app-list-fournisseur',
  templateUrl: './list-fournisseur.component.html',
  styleUrls: ['./list-fournisseur.component.scss']
})
export class ListFournisseurComponent implements OnInit {

  fournisseurs: Fournisseur[];
  constructor(private fournisseurService:FournisseurService,private router :Router) { }

  ngOnInit(): void {    this.getFournisseurs();   }
    

  private getFournisseurs() {
  this.fournisseurService.getFournisseurList().subscribe(data => {
  this.fournisseurs=data;
   })
    }

    updateFournisseur(id: number){
      this.router.navigate(['update-fournisseur', id]);
    }
    detailsFournisseur(id: number){
      this.router.navigate(['details-fournisseur', id]);
    }
    
    deleteFournisseur(id: number){
      this.fournisseurService.deleteFournisseur(id).subscribe(data =>{
        console.log(data);
        this.getFournisseurs();
      })
    }
    
    addFournisseurLink(){
      this.router.navigate(['fournisseur']);
    }
}
