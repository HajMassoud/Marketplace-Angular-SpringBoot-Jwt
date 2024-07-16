import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PanierService {
  public formData:  FormGroup;
  private baseUrl = '/api/paniers';
  private baseURL2 ='http://localhost:8080/api/paniers/nom';
  list :  any=[];
  tottht : number = 0;
  tottva : number = 0;
  totttc : number = 0;
  qte : number = 0;
  nba :number = 0;
  panier    : any={};
  tokenStr = localStorage.getItem('token') as string;
  
  constructor(private http:HttpClient,private toastr: ToastrService,
   ) { }
   getData(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`,{ headers: { authorization: this.tokenStr } });
  }
 
  saveOrUpdate(info: Object): Observable<Object> {
  
    return this.http.post(`${this.baseUrl}`, info,{ headers: { authorization: this.tokenStr } });
  }
  updatedata(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value,{ headers: { authorization: this.tokenStr } });
  }

  deleteData(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' , headers: { authorization: this.tokenStr }});
  }

  getAll(): Observable<any> {
    return this.http.get(`${this.baseUrl}`,{ headers: { authorization: this.tokenStr } });
  }

  getPanierByNom(nom: string): Observable<any>{
    return this.http.get(`${this.baseURL2}/${nom}`,{ headers: { authorization: this.tokenStr } });
  }

}
