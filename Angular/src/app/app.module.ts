import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module'
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { AddCategorieComponent } from './categorie/add-categorie/add-categorie.component';
import { ListCategorieComponent } from './categorie/list-categorie/list-categorie.component';
import { AddClientComponent } from './client/add-client/add-client.component';
import { ListClientComponent } from './client/list-client/list-client.component';
import { AddArticleComponent } from './article/add-article/add-article.component';
import { ListArticleComponent } from './article/list-article/list-article.component';
//ajouter manuellement 
import {HttpClientModule} from '@angular/common/http';
import { DetailsCategorieComponent } from './categorie/details-categorie/details-categorie.component';
import { UpdateCategorieComponent } from './categorie/update-categorie/update-categorie.component';
import { FormGroupDirective, FormsModule,ReactiveFormsModule } from '@angular/forms';
import { AddScategorieComponent } from './scategorie/add-scategorie/add-scategorie.component';
import { DetailsScategorieComponent } from './scategorie/details-scategorie/details-scategorie.component';
import { UpdateScategorieComponent } from './scategorie/update-scategorie/update-scategorie.component';
import { ListScategorieComponent } from './scategorie/list-scategorie/list-scategorie.component';
import { DetailsClientComponent } from './client/details-client/details-client.component';
import { UpdateClientComponent } from './client/update-client/update-client.component';
import { AddFournisseurComponent } from './fournisseur/add-fournisseur/add-fournisseur.component';
import { DetailsFournisseurComponent } from './fournisseur/details-fournisseur/details-fournisseur.component';
import { UpdateFournisseurComponent } from './fournisseur/update-fournisseur/update-fournisseur.component';
import { ListFournisseurComponent } from './fournisseur/list-fournisseur/list-fournisseur.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { ToastrModule } from 'ngx-toastr';
import {MatDialogModule, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {MatToolbarModule} from '@angular/material/toolbar';
import { AddPanierComponent } from './panier/add-panier/add-panier.component';
import { AddLpanierComponent } from './panier/add-lpanier/add-lpanier.component';
import { ListPanierComponent } from './panier/list-panier/list-panier.component';
import { PayementComponent } from './panier/payement/payement.component';
import { NgxPayPalModule } from 'ngx-paypal';
import { DatePipe, DecimalPipe } from '@angular/common';
import { NgxPaginationModule} from 'ngx-pagination';
import { ListUserComponent } from './user/list-user/list-user.component';
import { LoginComponent } from './user/login/login.component';
import { RegisterComponent } from './user/register/register.component';
import { AccueilComponent } from './accueil/accueil.component';
import { ListLpanierComponent } from './panier/list-lpanier/list-lpanier.component';
import { DetailClientpanierComponent } from './client/detail-clientpanier/detail-clientpanier.component';
import { ListPanierclientComponent } from './panier/list-panierclient/list-panierclient.component';
import { DetailClientpanierAdminComponent } from './client/detail-clientpanier-admin/detail-clientpanier-admin.component';
import { ListLpanierclientComponent } from './panier/list-lpanierclient/list-lpanierclient.component';
import { AddAnnonceComponent } from './annonce/add-annonce/add-annonce.component';
import { DetailAnnonceComponent } from './annonce/detail-annonce/detail-annonce.component';
import { ListAnnonceComponent } from './annonce/list-annonce/list-annonce.component';
import { ListAnnonceloguedComponent } from './annonce/list-annoncelogued/list-annoncelogued.component';
import { ListAnnonceadminComponent } from './annonce/list-annonceadmin/list-annonceadmin.component';
import { AddAnnonceadminComponent } from './annonce/add-annonceadmin/add-annonceadmin.component';
import { UpdateAnnonceComponent } from './annonce/update-annonce/update-annonce.component';
import { ListAnnonceclientComponent } from './annonce/list-annonceclient/list-annonceclient.component';
import { UpdateAnnonceclientComponent } from './annonce/update-annonceclient/update-annonceclient.component';
import { DetailArticleclientComponent } from './article/detail-articleclient/detail-articleclient.component';
@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    
    AddCategorieComponent,
    ListCategorieComponent,
    DetailsCategorieComponent,
    UpdateCategorieComponent,

    AddScategorieComponent,
    DetailsScategorieComponent,
    UpdateScategorieComponent,
    ListScategorieComponent,

    AddClientComponent,
    DetailsClientComponent,
    UpdateClientComponent,
    ListClientComponent,

    AddFournisseurComponent,
    DetailsFournisseurComponent,
    UpdateFournisseurComponent,
    ListFournisseurComponent,

    AddClientComponent,
    ListClientComponent,

    AddArticleComponent,
    ListArticleComponent,
    AddPanierComponent,
    AddLpanierComponent,
    ListPanierComponent,
    PayementComponent,
    ListUserComponent,
    LoginComponent,
    RegisterComponent,
    AccueilComponent,
    ListLpanierComponent,
    DetailClientpanierComponent,
    ListPanierclientComponent,
    DetailClientpanierAdminComponent,
    ListLpanierclientComponent,
    AddAnnonceComponent,
    DetailAnnonceComponent,
    ListAnnonceComponent,
    ListAnnonceloguedComponent,
    ListAnnonceadminComponent,
    AddAnnonceadminComponent,
    UpdateAnnonceComponent,
    ListAnnonceclientComponent,
    UpdateAnnonceclientComponent,
    DetailArticleclientComponent,


    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    //ce code est pour permettre la connexion avec *****
    HttpClientModule,
   //pour la correction du Can't bind to 'ngModel' since it isn't a known property of 'input'
    FormsModule,
    //pour la carrection de :no provider for ngcontrol found in nodeinjector angular
    ReactiveFormsModule,
    BrowserAnimationsModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule, 


    MatInputModule,
    MatDialogModule,
    MatButtonModule,
    MatToolbarModule,

    NgxPayPalModule,
    NgxPaginationModule,
    




    ToastrModule.forRoot({
      positionClass :'toast-top-right'
    })


  ],
  providers: [FormGroupDirective, DatePipe,DecimalPipe,
              { provide: MatDialogRef, useValue: {}},
              { provide: MAT_DIALOG_DATA, useValue: {} }, ],
  bootstrap: [AppComponent]
})
export class AppModule { }
