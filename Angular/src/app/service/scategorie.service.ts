import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { Scategorie } from '../model/scategorie';

@Injectable({
  providedIn: 'root'
})
export class ScategorieService {
  private baseURL ="http://localhost:8080/api/scategories";
  private baseURL2 ="http://localhost:8080/api/scategories/cc";
  public dataForm:FormGroup;
  tokenStr = localStorage.getItem('token') as string;
  constructor(private httpClient :HttpClient) { }

  getData(id:string):Observable<Object>{
    return this.httpClient.get(`${this.baseURL2}/${id}`,{ headers: { authorization: this.tokenStr } })
  }
  listScateg(id:string):Observable<any>{
    return this.httpClient.get(`${this.baseURL2}/${id}`,{ headers: { authorization: this.tokenStr } })
  }
  getNumero(code:string){
    return this.httpClient.get(`${this.baseURL}/7/${code  }`,{ headers: { authorization: this.tokenStr } })
  }

  getScategorieList():Observable<Scategorie[]>{
    return this.httpClient.get<Scategorie[]>(`${this.baseURL}`,{ headers: { authorization: this.tokenStr } });

  }
  createScategorie(Scategorie: Object): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, Scategorie,{ headers: { authorization: this.tokenStr } });
  }

  getScategorieById(id: number): Observable<Scategorie>{
    return this.httpClient.get<Scategorie>(`${this.baseURL}/${id}`,{ headers: { authorization: this.tokenStr } });
  }

  updateScategorie(id: number, scategorie: Scategorie): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, scategorie,{ headers: { authorization: this.tokenStr } });
  }
  
  deleteScategorie(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`,{ headers: { authorization: this.tokenStr } });
  }
}
