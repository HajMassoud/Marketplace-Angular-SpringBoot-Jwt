import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/service/client.service';

@Component({
  selector: 'app-detail-clientpanier',
  templateUrl: './detail-clientpanier.component.html',
  styleUrls: ['./detail-clientpanier.component.scss']
})
export class DetailClientpanierComponent implements OnInit {

  id:number;
  client :Client;
  clientname:string;
  constructor(public clientService :ClientService, private router :ActivatedRoute,private routt:Router) { }

  ngOnInit(): void {
    this.clientname=this.router.snapshot.params['clientname'];
    this.client=new Client();
    this.clientService.getClientByClientname(this.clientname).subscribe(data =>{
      this.client=data;
    });
  }
  back(){
    this.routt.navigate(['/panier']).then(() => {
      window.location.reload();
    });
  }

  panierclient(clientname:string){
    
    this.routt.navigate(['listpanierclient', clientname]);
  }

  annonces(clientname:string){
    
    this.routt.navigate(['ListAnnonceclient', clientname]);
  }
  addannonce(clientname:string){
    
    this.routt.navigate(['annonce', clientname]);
  }

}
