import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Scategorie } from 'src/app/model/scategorie';
import { ScategorieService } from 'src/app/service/scategorie.service';
import { CategorieService } from 'src/app/service/categorie.service';
import { Categorie } from 'src/app/model/categorie';
import { FormGroupDirective } from '@angular/forms';

@Component({
  selector: 'app-add-scategorie',
  templateUrl: './add-scategorie.component.html',
  styleUrls: ['./add-scategorie.component.scss']
})
export class AddScategorieComponent implements OnInit {
  CategorieList : Categorie[]; 
  scategorie :Scategorie=new Scategorie;
  num :any;
  code:string;
  constructor(private scategorieService :ScategorieService,private categorieService :CategorieService,private router :Router,private fg: FormGroupDirective)
   {     this.fg = fg;
          console.log(this.fg.form)
   }
  get f(){return this.scategorieService.dataForm.controls};
  ngOnInit(): void {
    this.categorieService.getCategorieList().subscribe(response =>{this.CategorieList =response;})
  }

  addScategorie(){
    this.scategorieService.createScategorie(this.scategorie).subscribe(data =>{
      console.log(data);
      this.goToScategorieList();
    },
    error => console.log(error));
  }

  goToScategorieList(){
this.router.navigate(["/scategories"]);
  }

  onSubmit(){
    console.log(this.scategorie);
    this.addScategorie();
  }
  OnSelectcateg(ctrl){
    if(ctrl.selectedIndex==0){
      this.f['ccateg'].setValue('');
    }
    else
    {
      this.code=this.CategorieList[ctrl.selectedIndex -1].code;
      this.scategorieService.getNumero(this.code).subscribe(
        response =>{
          this.num=response;
          if(this.num>0)
          {
            this.code=(100000 + this.num +1  ).toSting.substring(1);
          }
          else{
            this.code=(this.code+'01'); 
          }
          this.f['code'].setValue(this.code);
        }
      )
    }
  }

}
