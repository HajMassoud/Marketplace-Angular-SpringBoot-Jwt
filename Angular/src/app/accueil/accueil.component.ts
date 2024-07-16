import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialog, MatDialogConfig, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Article } from '../model/article';
import { Lpanier } from '../model/lpanier';
import { AddLpanierComponent } from '../panier/add-lpanier/add-lpanier.component';
import { ArticleService } from '../service/article.service';
import { ClientService } from '../service/client.service';
import { PanierService } from '../service/panier.service';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.scss']
})
export class AccueilComponent implements OnInit {

  lpanier : Lpanier;
  article : Article;
  montttc :number = 0;
  monttva : number = 0;
  montht  : number = 0;
  id;
  name;
  
  constructor(public service: ArticleService, public toastr: ToastrService,
    public panierService: PanierService,private router : Router,
    public clientService :ClientService,
    private matDialog: MatDialog,public fb: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef:MatDialogRef<AddLpanierComponent>,) { }


  ngOnInit(): void {
    this.name=localStorage.getItem('username');
    this.id=localStorage.getItem('idUser');
    this.getData();
  }

  
  addToCart(item :Lpanier)
  {
    this.montttc =item.pv;
    this.montht  =(this.montttc /( 100 + item.tva))*100;
    this.monttva = this.montttc - this.montht;
    this.panierService.totttc =this.panierService.totttc + this.montttc;
    this.panierService.tottht =this.panierService.tottht + this.montht;
    this.panierService.tottva =this.panierService.tottva + this.monttva;
    item.montttc = this.montttc;
    item.montht  = this.montht;
    item.monttva  = this.monttva;
    item.qte = 1;
    this.panierService.list.push(item)
    
  }

  Show(item : Article)
  {

  }


  getData() {
    this.service.getAll().subscribe(
      response =>{this.service.list = response;}
     );

  }

  payement()
  {

  }
  
  vider()
  {
    
  }

  logOut() {
    localStorage.removeItem("username");
    this.router.navigate(["/login"]);
  }
Dlogin(){

  this.toastr.error( 'Please LogIn');
}

detailsArticle(id: number){
  this.router.navigate(['detail-articleclient', id]);
}




}
