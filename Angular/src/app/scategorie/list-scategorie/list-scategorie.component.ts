import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Scategorie } from 'src/app/model/scategorie';
import { ScategorieService } from 'src/app/service/scategorie.service';

@Component({
  selector: 'app-list-scategorie',
  templateUrl: './list-scategorie.component.html',
  styleUrls: ['./list-scategorie.component.scss']
})
export class ListScategorieComponent implements OnInit {

  scategories: Scategorie[];
  constructor(private scategorieService:ScategorieService,private router :Router) { }

  ngOnInit(): void {    this.getScategories();   }
    

  private getScategories() {
  this.scategorieService.getScategorieList().subscribe(data => {
  this.scategories=data;
   })
    }

    updateScategorie(id: number){
      this.router.navigate(['update-scategorie', id]);
    }
    detailsScategorie(id: number){
      this.router.navigate(['details-scategorie', id]);
    }
    
    deleteScategorie(id: number){
      this.scategorieService.deleteScategorie(id).subscribe(data =>{
        console.log(data);
        this.getScategories();
      })
    }
    
    addScategorieLink(){
      this.router.navigate(['scategorie']);
    }

}
