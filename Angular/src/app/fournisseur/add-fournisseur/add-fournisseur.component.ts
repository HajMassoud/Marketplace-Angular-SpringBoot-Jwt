import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fournisseur } from 'src/app/model/fournisseur';
import { FournisseurService } from 'src/app/service/fournisseur.service';

@Component({
  selector: 'app-add-fournisseur',
  templateUrl: './add-fournisseur.component.html',
  styleUrls: ['./add-fournisseur.component.scss']
})
export class AddFournisseurComponent implements OnInit {

  fournisseur :Fournisseur=new Fournisseur; 
  constructor(private fournisseurService :FournisseurService,private router :Router) { }

  ngOnInit(): void {
  }

  addFournisseur(){
    this.fournisseurService.createFournisseur(this.fournisseur).subscribe(data =>{
      console.log(data);
      this.goToFournisseurList();
    },
    error => console.log(error));
  }

  goToFournisseurList(){
this.router.navigate(["/fournisseurs"]);
  }

  onSubmit(){
    console.log(this.fournisseur);
    this.addFournisseur();
  }

}
