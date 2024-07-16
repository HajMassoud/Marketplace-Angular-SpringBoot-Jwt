import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Categorie } from 'src/app/model/categorie';
import { CategorieService } from 'src/app/service/categorie.service';

@Component({
  selector: 'app-list-categorie',
  templateUrl: './list-categorie.component.html',
  styleUrls: ['./list-categorie.component.scss']
})
export class ListCategorieComponent implements OnInit {
  categories: Categorie[];
  constructor(private categorieService:CategorieService,private router :Router) { }

  ngOnInit(): void { 
     
   
    this.getCategories();   }
    

  private getCategories() {
  this.categorieService.getCategorieList().subscribe(data => {
  this.categories=data;
   })
    }

    updateCategorie(id: number){
      this.router.navigate(['update-categorie', id]);
    }
    detailsCategorie(id: number){
      this.router.navigate(['details-categorie', id]);
    }
    
    deleteCategorie(id: number){
      this.categorieService.deleteCategorie(id).subscribe(data =>{
        console.log(data);
        this.getCategories();
      })
    }
    
    addCategorieLink(){
      this.router.navigate(['categorie']);
    }

   
}
