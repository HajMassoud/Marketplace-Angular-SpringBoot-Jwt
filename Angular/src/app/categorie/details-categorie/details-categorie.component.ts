import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Categorie } from 'src/app/model/categorie';
import { CategorieService } from 'src/app/service/categorie.service';

@Component({
  selector: 'app-details-categorie',
  templateUrl: './details-categorie.component.html',
  styleUrls: ['./details-categorie.component.scss']
})
export class DetailsCategorieComponent implements OnInit {

  id:number;
  categorie :Categorie;
  constructor(private categorieService :CategorieService, private router :ActivatedRoute) { }

  ngOnInit(): void {
    this.id=this.router.snapshot.params['id'];

    this.categorie=new Categorie();
    this.categorieService.getCategorieById(this.id).subscribe(data =>{
      this.categorie=data;
    });
  }

}
