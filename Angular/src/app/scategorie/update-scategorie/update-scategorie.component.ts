import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from 'src/app/model/categorie';
import { Scategorie } from 'src/app/model/scategorie';
import { CategorieService } from 'src/app/service/categorie.service';
import { ScategorieService } from 'src/app/service/scategorie.service';

@Component({
  selector: 'app-update-scategorie',
  templateUrl: './update-scategorie.component.html',
  styleUrls: ['./update-scategorie.component.scss']
})
export class UpdateScategorieComponent implements OnInit {
  CategorieList : Categorie[]; 
  scategorie :Scategorie=new Scategorie; 
  id:number;
  constructor(private scategorieService:ScategorieService,private categorieService :CategorieService,    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.categorieService.getCategorieList().subscribe(response =>{this.CategorieList =response;})

    this.id = this.route.snapshot.params['id'];

    this.scategorieService.getScategorieById(this.id).subscribe(data => {
      this.scategorie = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.scategorieService.updateScategorie(this.id, this.scategorie).subscribe( data =>{
      this.goToCategorieList();
    }
    , error => console.log(error));
  }
  goToCategorieList(){
    this.router.navigate(['/scategories']);
  }

}
