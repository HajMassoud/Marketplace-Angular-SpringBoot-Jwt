 
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categorie } from '../model/categorie';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {
  private baseURL ="http://localhost:8080/api/categories";
  tokenStr = localStorage.getItem('token') as string;
  constructor(private httpClient :HttpClient) { }

  
  getCategorieList():Observable<Categorie[]>{
    return this.httpClient.get<Categorie[]>(`${this.baseURL}`,{ headers: { authorization: this.tokenStr } });

  }
  createCategorie(Categorie: Object): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, Categorie,{ headers: { authorization: this.tokenStr } });
  }

  getCategorieById(id: number): Observable<Categorie>{
    return this.httpClient.get<Categorie>(`${this.baseURL}/${id}`,{ headers: { authorization: this.tokenStr } });
  }

  updateCategorie(id: number, categorie: Categorie): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, categorie,{ headers: { authorization: this.tokenStr } });
  }
  
  deleteCategorie(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`,{ headers: { authorization: this.tokenStr } });
  }
}
