import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialogConfig,MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Article } from 'src/app/model/article';
import { ArticleService } from 'src/app/service/article.service';
import { AddArticleComponent } from '../add-article/add-article.component';

@Component({
  selector: 'app-list-article',
  templateUrl: './list-article.component.html',
  styleUrls: ['./list-article.component.scss']
})
export class ListArticleComponent implements OnInit {
  articles:Article[];
  constructor(public crudApi:ArticleService,public toastr:ToastrService,public fb:FormBuilder,private router :Router,private matDialog:MatDialog) { }

  ngOnInit(): void {
    this.getData();
  }

  addArticle(){
   
    this.crudApi.choixmenu="A";
   
   const dialogConfig =new MatDialogConfig();
   dialogConfig.autoFocus=true;
   dialogConfig.disableClose=true;
   dialogConfig.width="60%";
   dialogConfig.maxHeight='90vh';
   this.matDialog.open(AddArticleComponent,dialogConfig);
  }

  getData(){
    this.crudApi.getAll().subscribe(
      data  =>{this.articles =data ;}
    );
  }
  removeData(id:any){
    if(window.confirm('Are  sure you want to delete this article ?')){
      this.crudApi.deleteData(id)
      .subscribe(
        data => {
          console.log(data);
          this.toastr.warning('data seccessfully deleted !');
          this.getData();
        },
        error=>console.log(error));
      
    }
  }

  selectData(item:Article){
   this.crudApi.choixmenu="M";
   this.crudApi.dataForm=this.fb.group(Object.assign({},item));
   const dialogConfig= new MatDialogConfig;
   dialogConfig.autoFocus=true;
   dialogConfig.disableClose=true;
   dialogConfig.width="50%";
   dialogConfig.maxHeight='90vh';
   this.matDialog.open(AddArticleComponent,dialogConfig);
  }

}
