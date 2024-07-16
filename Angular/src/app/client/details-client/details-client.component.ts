import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/service/client.service';

@Component({
  selector: 'app-details-client',
  templateUrl: './details-client.component.html',
  styleUrls: ['./details-client.component.scss']
})
export class DetailsClientComponent implements OnInit {


  id:number;
  client :Client;
  clientname:string;
  constructor(public clientService :ClientService, private router :ActivatedRoute,private routt:Router) { }

  ngOnInit(): void {
    this.id=this.router.snapshot.params['id'];
    this.clientname=this.router.snapshot.params['clientname'];
    this.client=new Client();
    this.clientService.getClientById(this.id).subscribe(data =>{
      this.client=data;
    });
  }
  back(){
    this.routt.navigate(['/clients']);
  }

}
