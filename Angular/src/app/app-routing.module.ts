import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';


import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { AddCategorieComponent } from './categorie/add-categorie/add-categorie.component';
import { ListCategorieComponent } from './categorie/list-categorie/list-categorie.component';
import { UpdateCategorieComponent } from './categorie/update-categorie/update-categorie.component';
import { DetailsCategorieComponent } from './categorie/details-categorie/details-categorie.component';
import { ListScategorieComponent } from './scategorie/list-scategorie/list-scategorie.component';
import { AddScategorieComponent } from './scategorie/add-scategorie/add-scategorie.component';
import { UpdateScategorieComponent } from './scategorie/update-scategorie/update-scategorie.component';
import { DetailsScategorieComponent } from './scategorie/details-scategorie/details-scategorie.component';
import { ListClientComponent } from './client/list-client/list-client.component';
import { AddClientComponent } from './client/add-client/add-client.component';
import { UpdateClientComponent } from './client/update-client/update-client.component';
import { ListFournisseurComponent } from './fournisseur/list-fournisseur/list-fournisseur.component';
import { DetailsClientComponent } from './client/details-client/details-client.component';
import { AddFournisseurComponent } from './fournisseur/add-fournisseur/add-fournisseur.component';
import { UpdateFournisseurComponent } from './fournisseur/update-fournisseur/update-fournisseur.component';
import { DetailsFournisseurComponent } from './fournisseur/details-fournisseur/details-fournisseur.component';
import { ListArticleComponent } from './article/list-article/list-article.component';
import { AddArticleComponent } from './article/add-article/add-article.component';
import { ListPanierComponent } from './panier/list-panier/list-panier.component';
import { AddPanierComponent } from './panier/add-panier/add-panier.component';
import { LoginComponent } from'./user/login/login.component';
import { RegisterComponent } from './user/register/register.component';
import { AccueilComponent } from './accueil/accueil.component';
import { ListLpanierComponent } from './panier/list-lpanier/list-lpanier.component';
import { DetailClientpanierComponent } from './client/detail-clientpanier/detail-clientpanier.component';
import { ListPanierclientComponent } from './panier/list-panierclient/list-panierclient.component';
import { DetailClientpanierAdminComponent } from './client/detail-clientpanier-admin/detail-clientpanier-admin.component';
import { ListLpanierclientComponent } from './panier/list-lpanierclient/list-lpanierclient.component';
import { ListAnnonceComponent } from './annonce/list-annonce/list-annonce.component';
import { AddAnnonceComponent } from './annonce/add-annonce/add-annonce.component';
import { DetailAnnonceComponent } from './annonce/detail-annonce/detail-annonce.component';
import { ListAnnonceloguedComponent } from './annonce/list-annoncelogued/list-annoncelogued.component';
import { ListAnnonceadminComponent } from './annonce/list-annonceadmin/list-annonceadmin.component';
import { AddAnnonceadminComponent } from './annonce/add-annonceadmin/add-annonceadmin.component';
import { UpdateAnnonceComponent } from './annonce/update-annonce/update-annonce.component';
import { ListAnnonceclientComponent } from './annonce/list-annonceclient/list-annonceclient.component';
import { UpdateAnnonceclientComponent } from './annonce/update-annonceclient/update-annonceclient.component';
import { DetailArticleclientComponent } from './article/detail-articleclient/detail-articleclient.component';

const routes : Routes =[
  {path: '',component:MenuComponent,children:[
    {path:'categories',component:ListCategorieComponent},
    {path:'categorie',component:AddCategorieComponent},
    {path:'', redirectTo:'categories',pathMatch:'full'},
    {path:'update-categorie/:id', component :UpdateCategorieComponent} ,
    {path:'details-categorie/:id', component :DetailsCategorieComponent} ,


    {path:'scategories',component:ListScategorieComponent},
    {path:'scategorie',component:AddScategorieComponent},
    {path:'update-scategorie/:id', component :UpdateScategorieComponent} ,
    {path:'details-scategorie/:id', component :DetailsScategorieComponent}, 

    
    {path:'clients',component:ListClientComponent},
    {path:'client',component:AddClientComponent},
    {path:'update-client/:id', component :UpdateClientComponent} ,
    {path:'details-client/:id', component :DetailsClientComponent},

    {path:'fournisseurs',component:ListFournisseurComponent},
    {path:'fournisseur',component:AddFournisseurComponent},
    {path:'update-fournisseur/:id', component :UpdateFournisseurComponent} ,
    {path:'details-fournisseur/:id', component :DetailsFournisseurComponent},

    {path:'articles',component:ListArticleComponent},
    {path:'article',component:AddArticleComponent},
    {path: 'listpaniers',component:ListPanierComponent},
    {path: 'listlpaniers/:numero',component:ListLpanierComponent},
    {path:'detail-clientpanieradmin/:clientname',component:DetailClientpanierAdminComponent },

    {path:'annoncesadmin',component:ListAnnonceadminComponent},
    {path:'annoncce',component:AddAnnonceComponent},
    {path:'annonceadmin',component:AddAnnonceadminComponent},
    {path:'updateannonce/:id',component:UpdateAnnonceComponent},


    

  ]
 
  }
  ,{path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'paniers', component: ListPanierComponent},
  {path: 'panier', component: AddPanierComponent},
  {path:'accueil',component:AccueilComponent},
  {path:'detail-clientpanier/:clientname',component:DetailClientpanierComponent },
  //attention ici 
  {path: 'listpaniers2',component:ListPanierComponent},
  {path: 'listlpaniers2/:numero',component:ListLpanierComponent},
  {path: 'listlpaniersclient/:numero',component:ListLpanierclientComponent},
  {path:'listpanierclient/:nom',component:ListPanierclientComponent},

 
  {path:'annonces',component:ListAnnonceComponent},
  {path:'annonceslogued/:nom',component:ListAnnonceloguedComponent},
  {path:'annonce/:nom',component:AddAnnonceComponent},
  {path:'details-annonce/:id', component :DetailAnnonceComponent},
  {path:'annonceslogued',component:ListAnnonceloguedComponent},
  {path:'DetailAnnonce/:id',component:DetailAnnonceComponent},
  {path:'ListAnnonceclient/:nom',component:ListAnnonceclientComponent},
  {path:'update-annonceclient/:id',component:UpdateAnnonceclientComponent},
  {path:'detail-articleclient/:id',component:DetailArticleclientComponent}

 

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [ RouterModule  ],
  declarations: []

})
export class AppRoutingModule { }
