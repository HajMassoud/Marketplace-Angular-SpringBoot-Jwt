import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Annonce } from 'src/app/model/annonce';
import { AnnonceService } from 'src/app/service/annonce.service';

@Component({
  selector: 'app-update-annonce',
  templateUrl: './update-annonce.component.html',
  styleUrls: ['./update-annonce.component.scss']
})
export class UpdateAnnonceComponent implements OnInit {
  annonce :Annonce=new Annonce; 
  id:number;
  constructor(private annservice:AnnonceService,private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.annservice.getAnnonceById(this.id).subscribe(data => {
      this.annonce = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.annservice.updateAnnonce(this.id, this.annonce).subscribe( data =>{
      this.goToCategorieList();
    }
    , error => console.log(error));
  }
  goToCategorieList(){
    this.router.navigate(['/annoncesadmin']);
  }

}
