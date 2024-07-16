import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { Annonce } from '../model/annonce';

@Injectable({
  providedIn: 'root'
})
export class AnnonceService {
  public dataForm:FormGroup;
  list: any = [];
  host :string='http://localhost:8080';
  private baseURL2 ='http://localhost:8080/api/annonces/all';
  private baseURL5 ='http://localhost:8080/api/annoncesvld'
  tokenStr = localStorage.getItem('token') as string;
  private baseURL ='http://localhost:8080/api/annonces/client';
  private baseURL3 ='http://localhost:8080/api/annonces';
  private baseURL6 ='http://localhost:8080/api/annonces/nom';
  constructor(private http:HttpClient) { }

  createData(formData:FormData):Observable<any>{
    return this.http.post(`${this.baseURL}`,formData,{ headers: { authorization: this.tokenStr } });
  }
  getAll():Observable<Annonce[]>{
    return this.http.get<Annonce[]>(`${this.baseURL2}`,{ headers: { authorization: this.tokenStr } });
  }
  getAll2():Observable<Annonce[]>{
    return this.http.get<Annonce[]>(`${this.baseURL5}`,{ headers: { authorization: this.tokenStr } });
  }
  deleteData(id:number):Observable<any>{
    return this.http.delete(`${this.baseURL3}/${id}`,{responseType:'text', headers: { authorization: this.tokenStr }});
  }

  updateAnnonce(id: number, annonce: Annonce): Observable<Object>{
    return this.http.put(`${this.baseURL3}/${id}`, annonce,{ headers: { authorization: this.tokenStr } });
  }

  getAnnonceById(id: number): Observable<Annonce>{
    return this.http.get<Annonce>(`${this.baseURL3}/${id}`,{ headers: { authorization: this.tokenStr } });
  }

  getAnnonceByNom(nom: string): Observable<any>{
    return this.http.get(`${this.baseURL6}/${nom}`,{ headers: { authorization: this.tokenStr } });
  }
}
