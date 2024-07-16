import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Scategorie } from 'src/app/model/scategorie';
import { ScategorieService } from 'src/app/service/scategorie.service';

@Component({
  selector: 'app-details-scategorie',
  templateUrl: './details-scategorie.component.html',
  styleUrls: ['./details-scategorie.component.scss']
})
export class DetailsScategorieComponent implements OnInit {

  id:number;
  scategorie :Scategorie;
  constructor(private scategorieService :ScategorieService, private router :ActivatedRoute) { }

  ngOnInit(): void {
    this.id=this.router.snapshot.params['id'];

    this.scategorie=new Scategorie();
    this.scategorieService.getScategorieById(this.id).subscribe(data =>{
      this.scategorie=data;
    });
  }
}
