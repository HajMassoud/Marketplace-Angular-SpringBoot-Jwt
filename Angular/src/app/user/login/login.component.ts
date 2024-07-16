import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { UserService} from '../../service/user.service';
import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule,Validators }
from '@angular/forms';
import { Router } from '@angular/router';
import { User} from '../../model/user';
import { DatePipe }         from '@angular/common';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  user: any={};

  errorMessage:string;
  name : string;
  Wdate;
  annee : 0;
  loginForm:  FormGroup;
  

  constructor(private router:Router,private userService : UserService,
    public toastr: ToastrService,private datePipe : DatePipe,public fb: FormBuilder) { }
  ngOnInit() {
     this.userService.islogin = false;
     this.userService.admin = false;
     this.userService.client = false;
     this.userService.suser= false;


     this.loginForm = this.fb.group({
      'username' : [null, Validators.required],
      'password' : [null, Validators.required]
    });
    //this link is for the next line:for the background:https://stackoverflow.com/questions/51971301/how-to-set-background-image-for-angular-component
    document.body.className = "selector";
    
  }
  onRegister() {
    this.router.navigate(["/register"]);
  }
  login() {
    const val = this.loginForm.value ;
   this.userService.login2(val.username,val.password).subscribe(
      res =>{
      this.user = res;
    
        localStorage.setItem("idUser", this.user.id);
        localStorage.setItem("username", this.user.username);
        localStorage.setItem("codef", this.user.code);
        localStorage.setItem("role", this.user.role);
        ///////
        let jwt = "Bearer " + this.user.jwt;
        localStorage.setItem("token", jwt);
       //////// 
        this.userService.islogin = true;
        if (this.user.role  == "ADMIN")
         {
         this.userService.admin = true;
          this.router.navigate(['/']).then(() => {
            window.location.reload();
          });
      }
      else if (this.user.role = "CLIENT")
      {
        this.userService.four = true;
        this.router.navigate(['/panier']).then(() => {
          window.location.reload();
        });
      }
       
      
    
    else
    {
      this.toastr.warning( 'Mot de Passe  Incorrecte ')
    }
          },
          error =>

            this.toastr.warning( 'Login Incorrecte ')


          );
        }


register()
{
  this.router.navigate(['/register']);
}


 logOut() {
          localStorage.removeItem("username");
 }



    transformDate(date){
      return this.datePipe.transform(date, 'yyyy-MM-dd');
    }
    logout() {
      // remove user from local storage and set current user to null
      localStorage.removeItem('name');

  }
  }


  


