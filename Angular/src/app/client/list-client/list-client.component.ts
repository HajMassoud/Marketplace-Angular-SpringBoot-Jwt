import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/service/client.service';

@Component({
  selector: 'app-list-client',
  templateUrl: './list-client.component.html',
  styleUrls: ['./list-client.component.scss']
})
export class ListClientComponent implements OnInit {
  clients: Client[];
  constructor(private clientService:ClientService,private router :Router) { }

  ngOnInit(): void {    this.getClients();   }
    

  private getClients() {
  this.clientService.getClientList().subscribe(data => {
  this.clients=data;
   })
    }

    updateClient(id: number){
      this.router.navigate(['update-client', id]);
    }
    detailsClient(id: number){
      this.router.navigate(['details-client', id]);
    }
    
    deleteClient(id: number){
      this.clientService.deleteClient(id).subscribe(data =>{
        console.log(data);
        this.getClients();
      })
    }
    
    addClientLink(){
      this.router.navigate(['client']);
    }
}
