package com.smartnet.projet.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity 
@Table (name = "categorie")

public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id ;
	@Column(name="code")
	private String code ; 
	@Column(name="libelle")
	private String libelle;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", code=" + code + ", libelle=" + libelle + "]";
	}
	public Categorie(long id, String code, String libelle) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 

}
