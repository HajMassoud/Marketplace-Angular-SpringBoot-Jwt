import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../model/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  host :string='http://localhost:8080';
  private baseURL ="http://localhost:8080/api/clients/register";
  private baseURL2 ="http://localhost:8080/api/clients";
  private baseURL3 ="http://localhost:8080/api/clients/clientname";
  tokenStr = localStorage.getItem('token') as string;
  constructor(private httpClient :HttpClient) { }
  getClientList():Observable<Client[]>{
    return this.httpClient.get<Client[]>(`${this.baseURL2}`,{ headers: { authorization: this.tokenStr } });

  }
  createClient(Client: Object): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, Client,{ headers: { authorization: this.tokenStr } });
  }

  createClient2(Client: Object): Observable<Object> {
    return this.httpClient.post(`${this.baseURL2}`, Client,{ headers: { authorization: this.tokenStr } });
  }

  getClientById(id: number): Observable<Client>{
    return this.httpClient.get<Client>(`${this.baseURL2}/${id}`,{ headers: { authorization: this.tokenStr } });
  }

  updateClient(id: number, client: Client): Observable<Object>{
    return this.httpClient.put(`${this.baseURL2}/${id}`, client,{ headers: { authorization: this.tokenStr } });
  }
  
  deleteClient(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL2}/${id}`,{ headers: { authorization: this.tokenStr } });
  }
  getClientByClientname(clientname: string) {
    return this.httpClient.get<Client>(`${this.baseURL3}/${clientname}`,{ headers: { authorization: this.tokenStr } });
  }

}
