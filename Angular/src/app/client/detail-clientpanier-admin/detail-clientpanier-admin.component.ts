import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/service/client.service';

@Component({
  selector: 'app-detail-clientpanier-admin',
  templateUrl: './detail-clientpanier-admin.component.html',
  styleUrls: ['./detail-clientpanier-admin.component.scss']
})
export class DetailClientpanierAdminComponent implements OnInit {
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
    this.routt.navigate(['/listpaniers']).then(() => {
      window.location.reload();
    });
  }



}
