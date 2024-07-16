import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Fournisseur } from '../model/fournisseur';

@Injectable({
  providedIn: 'root'
})
export class FournisseurService {

  private baseURL ="http://localhost:8080/api/fournisseurs";
  tokenStr = localStorage.getItem('token') as string;
  constructor(private httpClient :HttpClient) { }
  getFournisseurList():Observable<Fournisseur[]>{
    return this.httpClient.get<Fournisseur[]>(`${this.baseURL}`,{ headers: { authorization: this.tokenStr } });

  }
  createFournisseur(Fournisseur: Object): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, Fournisseur,{ headers: { authorization: this.tokenStr } });
  }

  getFournisseurById(id: number): Observable<Fournisseur>{
    return this.httpClient.get<Fournisseur>(`${this.baseURL}/${id}`,{ headers: { authorization: this.tokenStr } });
  }

  updateFournisseur(id: number, fournisseur: Fournisseur): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, fournisseur,{ headers: { authorization: this.tokenStr } });
  }
  
  deleteFournisseur(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`,{ headers: { authorization: this.tokenStr } });
  }

  getFourList():Observable<Fournisseur[]>{
    return this.httpClient.get<Fournisseur[]>(`${this.baseURL}`,{ headers: { authorization: this.tokenStr } });

  }
}
