
  import { Component, OnInit,Inject } from '@angular/core';
  import { ArticleService} from '../../service/article.service';
  import { ToastrService } from 'ngx-toastr';
  import { Article} from '../../model/article';
  import { PanierService} from '../../service/panier.service';
  import { Panier} from '../../model/panier';
  import { Lpanier} from '../../model/lpanier';
  
  import {MatDialog, MatDialogConfig } from '@angular/material/dialog';
  import { MatDialogRef } from "@angular/material/dialog";
  import { Router } from '@angular/router';
  import { MAT_DIALOG_DATA } from "@angular/material/dialog";
  import { AddLpanierComponent } from '../../panier/add-lpanier/add-lpanier.component';
  import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule,Validators }
  from '@angular/forms';
import { ClientService } from 'src/app/service/client.service';

@Component({
  selector: 'app-add-panier',
  templateUrl: './add-panier.component.html',
  styleUrls: ['./add-panier.component.scss']
})
export class AddPanierComponent implements OnInit {
  lpanier : Lpanier;
  article : Article;
  montttc :number = 0;
  monttva : number = 0;
  montht  : number = 0;
  id;
  name;
  clientname;
  constructor(public service: ArticleService, public toastr: ToastrService,
    public panierService: PanierService,private router : Router,
    public clientService :ClientService,
    private matDialog: MatDialog,public fb: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef:MatDialogRef<AddLpanierComponent>,) { }


  ngOnInit(): void {
    this.name=localStorage.getItem('username');
    this.id=localStorage.getItem('idUser');
    this.clientname=localStorage.getItem('username');
    this.getData();

  }

  panier()
  {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.disableClose = true;
    dialogConfig.width="70%";
    //dialogConfig.data="gdddd";
    this.matDialog.open(AddLpanierComponent, dialogConfig);
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

  Showitem(id: number)
  {
   
      this.router.navigate(['detail-articleclient', id]);
    
  }


  getData() {
    this.service.getAll().subscribe(
      response =>{this.service.list = response;}
     );

  }


  logOut() {
    localStorage. clear() ;
    localStorage.removeItem("clientname");
    localStorage.setItem('token','');
    this.router.navigate(["/accueil"]);
  }
  
  detailsClient(clientname: number){
    this.router.navigate(['detail-clientpanier', clientname]);
  }


nosArticle(){
  if(this.clientname != null){
    this.router.navigate(["/panier"]);
  }
}

}
