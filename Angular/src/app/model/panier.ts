import { Lpanier } from "./lpanier";

export class Panier {
    id:number;
    numero:number;
    annee:number;
    date_mvt:any;
    montant:number;
    idclient:number;
    client:string;
    adresse:string;
    nba:number;
    lpanier:Array<Lpanier>=[];
    
}
