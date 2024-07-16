import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AnnonceService } from 'src/app/service/annonce.service';

@Component({
  selector: 'app-add-annonceadmin',
  templateUrl: './add-annonceadmin.component.html',
  styleUrls: ['./add-annonceadmin.component.scss']
})
export class AddAnnonceadminComponent implements OnInit {

  nom;
  userFile ;
  message : string;
  public imagePath;
  imgURL:any;
  constructor(public crudApi:AnnonceService,public fb:FormBuilder,
    public toastr:ToastrService,
    private router :Router,@Inject(MAT_DIALOG_DATA) public data,) { }

  ngOnInit(): void {
    this.infoForm();
    this.nom=localStorage.getItem('username');

  }
  infoForm(){
    this.crudApi.dataForm=this.fb.group({
    id:null,
    clientname:['',[Validators.required]], 
    libelle:['',[Validators.required]],
    adresse:['',[Validators.required]],
    tel1:['',[Validators.required]],
    tel2:['',[Validators.required]],
    etat:['',[Validators.required]],
    pv:[0,[Validators.required]],
    }) 
  }

  onSubmit(){
      this.addData();
  }

  addData (){
    const formData=new FormData();
    const annonce = this.crudApi.dataForm.value;
    formData.append('annonce',JSON.stringify(annonce));
    formData.append('file',this.userFile);
    this.crudApi.createData(formData).subscribe(data =>{
        this.router.navigate(['/annoncesadmin'])  .then(() => {
          window.location.reload();
        });
    });  

}

onSelectFile(event){
  if(event.target.files.length > 0){
    const file =event.target.files[0];
    this.userFile=file;

    var mimeType=event.target.files[0].type;
    if(mimeType.match(/image\/*/)==null){
      this.message="Only images supported .";
      return;
    }
    var reader =new FileReader;
    this.imagePath=file;
    reader.readAsDataURL(file);
    reader.onload=(_event)=>{
      this.imgURL=reader.result;

     }
   }
  }

}
