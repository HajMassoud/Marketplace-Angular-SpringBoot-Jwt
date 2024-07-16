import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Categorie } from 'src/app/model/categorie';
import { CategorieService } from 'src/app/service/categorie.service';

@Component({
  selector: 'app-add-categorie',
  templateUrl: './add-categorie.component.html',
  styleUrls: ['./add-categorie.component.scss']
})
export class AddCategorieComponent implements OnInit {

  categorie :Categorie=new Categorie; 
  constructor(private categorieService :CategorieService,private router :Router) { }

  ngOnInit(): void {
  }

  addCategorie(){
    this.categorieService.createCategorie(this.categorie).subscribe(data =>{
      console.log(data);
      this.goToCategorieList();
    },
    error => console.log(error));
  }

  goToCategorieList(){
this.router.navigate(["/categories"]);
  }

  onSubmit(){
    console.log(this.categorie);
    this.addCategorie();
  }
}
