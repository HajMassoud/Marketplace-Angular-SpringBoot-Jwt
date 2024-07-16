package com.smartnet.projet.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name = "annonce")
public class Annonce {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name="id")
	private long id ;
	@Column(name="clientname")
	private String clientname;
	@Column(name="libelle")
	private String libelle;
	@Column(name="adresse")
	private String adresse;
	@Column(name="tel1")
	private String tel1;
	@Column(name="tel2")
	private String tel2;
	@Column(name="description")
	private String description;
	@Column(name="prix_vente")
	private double pv ;
	@Column(name="etat")
	private String etat;
	//c'est pour le lien d'image
	@Column(name="filename")
	private String filename ;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public double getPv() {
		return pv;
	}
	public void setPv(double pv) {
		this.pv = pv;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}



	
	
	@Override
	public String toString() {
		return "Annonce [id=" + id + ", clientname=" + clientname + ", libelle=" + libelle + ", adresse=" + adresse
				+ ", tel1=" + tel1 + ", tel2=" + tel2 + ", description=" + description + ", pv=" + pv + ", etat=" + etat
				+ ", filename=" + filename + "]";
	}
	
	public Annonce(long id, String clientname, String libelle, String adresse, String tel1, String tel2,
			String description, double pv, String etat, String filename) {
		super();
		this.id = id;
		this.clientname = clientname;
		this.libelle = libelle;
		this.adresse = adresse;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.description = description;
		this.pv = pv;
		this.etat = etat;
		this.filename = filename;
	}
	public Annonce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}
