import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User} from '../model/user';
import { DatePipe } from '@angular/common';

import { FormBuilder, FormGroup, FormControl,ReactiveFormsModule,Validators}
from '@angular/forms';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = '/api/users';
  private baseUrl2= 'api/users/login';
  list:  any=[];
  islogin = false;
  admin = false;
  suser = false;
  client = false;
  four = false;
  host :string = 'http://localhost:8080';
  baseURL1 ="http://localhost:8080/api/clients/register";
  baseURL2 ="http://localhost:8080/api/users/auth";
  baseURL3 ="http://localhost:8080/api/users/login";
  tokenStr = localStorage.getItem('token') as string;

  choixmenu : string;
  public formData:  FormGroup; 
  constructor(private http: HttpClient,private datePipe: DatePipe) { }
  login(username :string,pwd : string ) {
    return this.http.get(`${this.baseURL2}/${username}`,{ headers: { authorization: this.tokenStr } });
   
   } 

   login2(username, password) {
    return this.http.post(`${this.baseURL3}`,{username, password});
  }
   
   verifEmail(email :string) {
    return this.http.get(`${this.baseUrl}/verif/${email}`,{ headers: { authorization: this.tokenStr } });
   
   }  
 
  getData(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`,{ headers: { authorization: this.tokenStr } });
  }
 
  createData(formData:FormData): Observable<Object> {
  
    return this.http.post(`${this.baseURL1}`, formData);
  }
  
  updatedata(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value,{ headers: { authorization: this.tokenStr } });
  }
 
  
  deleteData(id: number): Observable<any> {
   
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' , headers: { authorization: this.tokenStr } }); //,{ headers: { authorization: this.tokenStr } }
  }

  getAll(): Observable<any> {
   
    return this.http.get(`${this.baseUrl}`,{ headers: { authorization: this.tokenStr } }  );
  }
  
  }
