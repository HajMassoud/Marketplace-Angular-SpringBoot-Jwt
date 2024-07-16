import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Annonce } from 'src/app/model/annonce';
import { AnnonceService } from 'src/app/service/annonce.service';

@Component({
  selector: 'app-list-annonceadmin',
  templateUrl: './list-annonceadmin.component.html',
  styleUrls: ['./list-annonceadmin.component.scss']
})
export class ListAnnonceadminComponent implements OnInit {
 
  constructor(public service:AnnonceService,private router : Router,public toastr:ToastrService) { }

  ngOnInit(): void {
    this.getData();
  }

  getData() {
    this.service.getAll().subscribe(
      response =>{this.service.list = response;}
     );

  }

  addAnnonce(){
    this.router.navigate(["/annonceadmin"]);
  }
  removeData(id:any){
    if(window.confirm('Are  sure you want to delete this article ?')){
      this.service.deleteData(id)
      .subscribe(
        data => {
          console.log(data);
          this.toastr.warning('data seccessfully deleted !');
          this.getData();
        },
        error=>console.log(error));
      
    }
  }

  updatetData(id:number){
 this.router.navigate(['/updateannonce', id]);
  }

  detailsClient(clientname: number){
    this.router.navigate(['detail-clientpanieradmin', clientname]);
  }
}
