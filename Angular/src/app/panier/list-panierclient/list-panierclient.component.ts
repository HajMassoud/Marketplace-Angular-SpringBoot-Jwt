import { DatePipe, DecimalPipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { PanierService } from 'src/app/service/panier.service';
import { Location } from '@angular/common';


@Component({
  selector: 'app-list-panierclient',
  templateUrl: './list-panierclient.component.html',
  styleUrls: ['./list-panierclient.component.scss']
})
export class ListPanierclientComponent implements OnInit {
p = 1;
  Liste;
  SearchText: string;
  format = '3.3-3';
  nom;
  paniers;
  constructor(private service: PanierService, private router: Router,
    private toastr: ToastrService, public fb: FormBuilder,
    private datePipe: DatePipe,public decimalPipe: DecimalPipe,
    private matDialog:MatDialog,private routter :ActivatedRoute,
    private panierService:PanierService,private location: Location) { }

  ngOnInit(): void {
    this.nom=localStorage.getItem('username');
    this.panierService.getPanierByNom(this.nom).subscribe(data =>{this.paniers=data;
    });
  }

  info(numero: number){
    this.router.navigate(['listlpaniersclient', numero]);
     }  

     close(){
      this.location.back();
    }
}
