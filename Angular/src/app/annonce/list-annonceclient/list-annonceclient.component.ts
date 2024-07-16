import { DatePipe, DecimalPipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AnnonceService } from 'src/app/service/annonce.service';
import { Location } from '@angular/common';
@Component({
  selector: 'app-list-annonceclient',
  templateUrl: './list-annonceclient.component.html',
  styleUrls: ['./list-annonceclient.component.scss']
})
export class ListAnnonceclientComponent implements OnInit {
  nom;
  annonces;
  p = 1;
  constructor(private service: AnnonceService, private router: Router,
    private toastr: ToastrService, public fb: FormBuilder,
    private datePipe: DatePipe,public decimalPipe: DecimalPipe,
    private matDialog:MatDialog,private routter :ActivatedRoute,
    private location: Location) { }

  ngOnInit(): void {
    this.nom=localStorage.getItem('username');
    this.service.getAnnonceByNom(this.nom).subscribe(data =>{this.annonces=data;
    });
  }

  close(){
    this.location.back();
  }

  updateClient(id: number){
    this.router.navigate(['update-annonceclient', id]);
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


  getData() {
    this.service.getAll().subscribe(
      response =>{this.service.list = response;}
     );

  }
}
