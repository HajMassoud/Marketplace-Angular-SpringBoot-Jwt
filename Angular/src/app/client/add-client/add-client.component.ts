import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/service/client.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.scss']
})
export class AddClientComponent implements OnInit {

  submitted = false;
  userFile;
  public imagePath;
  imgURL: any;
  acceptTerms : string; 
  constructor(public crudApi: UserService ,public fb: FormBuilder,public toastr: ToastrService,
    private router : Router) { }
    ngOnInit() {
      this.infoForm();
  
      //background
      document.body.className = "selector2";
     }
  
     get f() { return this.crudApi.formData.controls; }
  
    
    infoForm() {
      this.crudApi.formData = this.fb.group({
          id: null,
          code:['', [Validators.required]],
          clientname: ['', [Validators.required, Validators.minLength(8)]],
          adresse: ['', [Validators.required, Validators.minLength(4)]],
          tel: ['', [Validators.required, Validators.minLength(4)]],
          email: ['', [Validators.required, Validators.minLength(4)]],
          fax: ['', [Validators.required, Validators.minLength(4)]],
          pwd: ['', [Validators.required, Validators.minLength(4)]],
          });
      }
     
    
  
    onReset() {
      this.submitted = false;
        this.crudApi.formData.reset();
    }
    onSubmit() {
      this.crudApi.choixmenu=="A";
      this.submitted = true;
      const val = this.crudApi.formData.value;
            this.addData();
  
        }
    
     
  
  addData() {
    const formData = new FormData();
      
      const client = this.crudApi.formData.value;
      formData.append('client', JSON.stringify(client));
      formData.append('file', this.userFile);
      this.crudApi.createData(formData).subscribe( data => {
      this.toastr.success( 'Validation Faite avec Success'); 
      this.router.navigate(['/clients']);
    });
  }
  
    updateData()
    {
    
      this.crudApi.updatedata(this.crudApi.formData.value.id,this.crudApi.formData.value).
      subscribe( data => {
        this.toastr.success( 'Modification Faite avec Success');
  
        this.router.navigate(['/users']);
      });
    }
    onSelectFile(event) {
      if (event.target.files.length > 0) {
        const file = event.target.files[0];
        this.userFile = file;
        // this.f['profile'].setValue(file);
  
        var mimeType = event.target.files[0].type;
        if (mimeType.match(/image\/*/) == null) {
          this.toastr.success('Only images are supported.');
  
          return;
        }
        var reader = new FileReader();
        this.imagePath = file;
        reader.readAsDataURL(file);
        reader.onload = (_event) => {
          this.imgURL = reader.result;
        }
      }
    }
  
  
  
    
}
