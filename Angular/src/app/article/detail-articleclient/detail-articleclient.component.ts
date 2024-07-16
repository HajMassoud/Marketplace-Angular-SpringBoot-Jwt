import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Annonce } from 'src/app/model/annonce';
import { Article } from 'src/app/model/article';
import { ArticleService } from 'src/app/service/article.service';

@Component({
  selector: 'app-detail-articleclient',
  templateUrl: './detail-articleclient.component.html',
  styleUrls: ['./detail-articleclient.component.scss']
})
export class DetailArticleclientComponent implements OnInit {
  id:number;
  article:Article;
  constructor(public articleService :ArticleService, private router :ActivatedRoute,private routt:Router) { }

  ngOnInit(): void {
    this.id=this.router.snapshot.params['id'];
    this.article=new Article();
    this.articleService.getArticleById(this.id).subscribe(data =>{
      this.article=data;
    });
  }

}
