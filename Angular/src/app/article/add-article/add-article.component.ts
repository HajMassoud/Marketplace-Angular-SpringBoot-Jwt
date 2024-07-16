import { Component, OnInit,Inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Categorie } from 'src/app/model/categorie';
import { ArticleService } from 'src/app/service/article.service';
import { CategorieService } from 'src/app/service/categorie.service';
import { ScategorieService } from 'src/app/service/scategorie.service';
//npm i ngx-toastr@13.2.1 enfin !!!!!!!!!!!
import { ToastrService} from 'ngx-toastr'; 
//ng add @angular/material    pour material 
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Article } from 'src/app/model/article';
import { FournisseurService } from 'src/app/service/fournisseur.service';
@Component({
  selector: 'app-add-article',
  templateUrl: './add-article.component.html',
  styleUrls: ['./add-article.component.scss']
})
export class AddArticleComponent implements OnInit {

  num: any;
  wcode:string;
  CategorieList:Categorie[];
  ScategorieList:any[];
  fourList:any[];
  scategorie:any={};
  message : string;
  userFile ;
  public imagePath;
  imgURL:any;
  list;
    constructor(public crudApi:ArticleService,public fb:FormBuilder,
      public scategoriService :ScategorieService,
      public toastr:ToastrService,private fourService:FournisseurService,
      public categoriService :CategorieService,
      private router :Router,@Inject(MAT_DIALOG_DATA) public data,
      public dialogRef:MatDialogRef<AddArticleComponent>,
      ) { }

  get f(){return this.crudApi.dataForm.controls;}
  
    ngOnInit(): void {
      if(this.crudApi.choixmenu=="A") {this.infoForm()};
      this.categoriService.getCategorieList().subscribe(
        responce => {this.CategorieList=responce;});

        this.fourService.getFourList().subscribe(response =>{this.fourList =response;})

      
    }
    infoForm(){
      this.crudApi.dataForm=this.fb.group({
      id:null,
      code:['',[Validators.required]],
      libelle:['',[Validators.required]],
      pa:[0,[Validators.required]],
      pv:[0,[Validators.required]],
      tva:[0,[Validators.required]],
      stock:[0,[Validators.required]],
      libcateg:['',[Validators.required]],
      libscateg:['',[Validators.required]],
      libfour:['',[Validators.required]],
      description:['',[Validators.required]],
      }) 
    }
  
    ResetForm(){
      this.crudApi.dataForm.reset();
    }
  
    onSubmit(){
      if(this.crudApi.choixmenu=="A"){
        this.addData();
      }
      else{
        this.updateData();
      }
    }

    onSelectCateg(libcateg:string){
      this.scategoriService.listScateg(libcateg).subscribe(
        response => {this.ScategorieList=response;}
      );
    }
  
    onSelectScateg(libcateg:string){
      this.scategoriService.getData(libcateg).subscribe(
        response =>{
          this.num=response;
         // if(this.num > 0 ){
           // this.wcode=(100000000+this.num +1 ).toSting().substring(1);
          //}
          //else{
            //this.wcode=(cscateg +'001');
          }

          //this.f['code'].setValue(this.wcode);
        //}
      );
    }
  
   addData (){
    const formData=new FormData();
    const article = this.crudApi.dataForm.value;
    formData.append('article',JSON.stringify(article));
    formData.append('file',this.userFile);
    this.crudApi.createData(formData).subscribe(data =>{
      this.dialogRef.close();
      this.crudApi.getAll().subscribe(
        responce =>{this.list= responce;}
      );
        this.router.navigate(['/articles'])  .then(() => {
          window.location.reload();
        });
    });  

}
updateData(){
  this.crudApi.updateData(this.crudApi.dataForm.value.id,this.crudApi.dataForm.value).
  subscribe(data =>{
    this.dialogRef.close();
      this.crudApi.getAll().subscribe(
        response =>{this.list=response;}
      );
      this.router.navigate(['/articles']);
      });
}

onSelectFile(event){
  if(event.target.files.length > 0){
    const file =event.target.files[0];
    this.userFile=file;

    var mimeType=event.target.files[0].type;
    if(mimeType.match(/image\/*/)==null){
      this.message="Only images supported .";
      return;
    }
    var reader =new FileReader;
    this.imagePath=file;
    reader.readAsDataURL(file);
    reader.onload=(_event)=>{
      this.imgURL=reader.result;

     }
   }
  }
   
}
