import { DecimalPipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Lpanier } from 'src/app/model/lpanier';
import { ArticleService } from 'src/app/service/article.service';
import { LpanierService } from 'src/app/service/lpanier.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-list-lpanierclient',
  templateUrl: './list-lpanierclient.component.html',
  styleUrls: ['./list-lpanierclient.component.scss']
})
export class ListLpanierclientComponent implements OnInit {

  numero:number;
  lpaniers:Lpanier[];
  format = '3.3-3';
  constructor(public crudApi:ArticleService,public lpanierService :LpanierService,
     private router :ActivatedRoute,private nav:Router,public decimalPipe: DecimalPipe,private location: Location) { }

  ngOnInit(): void {
    this.numero=this.router.snapshot.params['numero'];
    this.lpanierService.getLpanierByNumero(this.numero).subscribe(data =>{this.lpaniers=data;
    });
  

  }
  close(){
    this.location.back();
  }


}
