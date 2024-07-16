import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LpanierService {
  private baseURL ='http://localhost:8080/api/lpaniers/numero';
  tokenStr = localStorage.getItem('token') as string;
  constructor(private http :HttpClient) { }

  getLpanierByNumero(numero: number): Observable<any>{
    return this.http.get(`${this.baseURL}/${numero}`,{ headers: { authorization: this.tokenStr } });
  }
}
