import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { Article } from '../model/article';
@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  private baseURL ='http://localhost:8080/api/articles';
  private baseURL2 ='http://localhost:8080/api/articles/all';//****************** */
  
  host :string='http://localhost:8080';
  choixmenu :string='A';
  public dataForm:FormGroup;
  tokenStr = localStorage.getItem('token') as string;
  list: any = [];
  constructor(private http:HttpClient) { }


  getData(id:number):Observable<Object>{
    return this.http.get(`${this.baseURL}/${id}`,{ headers: { authorization: this.tokenStr } })
  }
  getNumero(code:string){
    return this.http.get(`${this.baseURL}/7/${code  }`,{ headers: { authorization: this.tokenStr } })
  }
  createData(formData:FormData):Observable<any>{
    return this.http.post(`${this.baseURL}`,formData,{ headers: { authorization: this.tokenStr } });
  }
  deleteData(id:number):Observable<any>{
    return this.http.delete(`${this.baseURL}/${id}`,{responseType:'text', headers: { authorization: this.tokenStr }});
  }
  updateData(id:number,value :any):Observable<object>{
    return this.http.put(`${this.baseURL}/${id}`,value,{ headers: { authorization: this.tokenStr } });
  }

  getAll():Observable<Article[]>{
    return this.http.get<Article[]>(`${this.baseURL2}`,{ headers: { authorization: this.tokenStr } });
  }
  uploadFile(file:File):Observable<HttpEvent<{}>>{
    const formdata:FormData=new FormData();
    formdata.append('file',file);
    const req=new HttpRequest('POST','<Server URL of the file upload>',formdata,
    {reportProgress:true,responseType:'text'});
    return this.http.request(req);
  }

  getArticleById(id: number): Observable<Article>{
    return this.http.get<Article>(`${this.baseURL}/${id}`,{ headers: { authorization: this.tokenStr } });
  }

}