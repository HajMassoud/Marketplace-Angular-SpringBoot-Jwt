import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Fournisseur } from 'src/app/model/fournisseur';
import { FournisseurService } from 'src/app/service/fournisseur.service';

@Component({
  selector: 'app-update-fournisseur',
  templateUrl: './update-fournisseur.component.html',
  styleUrls: ['./update-fournisseur.component.scss']
})
export class UpdateFournisseurComponent implements OnInit {


  fournisseur :Fournisseur=new Fournisseur; 
  id:number;
  constructor(private fournisseurService:FournisseurService,    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.fournisseurService.getFournisseurById(this.id).subscribe(data => {
      this.fournisseur = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.fournisseurService.updateFournisseur(this.id, this.fournisseur).subscribe( data =>{
      this.goToFournisseurList();
    }
    , error => console.log(error));
  }
  goToFournisseurList(){
    this.router.navigate(['/fournisseurs']);
  }
}
