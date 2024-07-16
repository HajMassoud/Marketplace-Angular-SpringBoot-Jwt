import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from 'src/app/model/categorie';
import { CategorieService } from 'src/app/service/categorie.service';

@Component({
  selector: 'app-update-categorie',
  templateUrl: './update-categorie.component.html',
  styleUrls: ['./update-categorie.component.scss']
})
export class UpdateCategorieComponent implements OnInit {
  categorie :Categorie=new Categorie; 
  id:number;
  constructor(private categorieService:CategorieService,    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.categorieService.getCategorieById(this.id).subscribe(data => {
      this.categorie = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.categorieService.updateCategorie(this.id, this.categorie).subscribe( data =>{
      this.goToCategorieList();
    }
    , error => console.log(error));
  }
  goToCategorieList(){
    this.router.navigate(['/categories']);
  }

}
