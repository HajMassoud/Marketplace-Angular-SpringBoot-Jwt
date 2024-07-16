package com.smartnet.projet.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table (name = "scategorie")
public class Scategorie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id ;
	@Column(name="code")
	private String code ; 
	@Column(name="libelle")
	private String libelle;
	@Column (name="libcateg")
	private String libcateg;
	
	public Scategorie () {
		
	}

	

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

	public String getLibcateg() {
		return libcateg;
	}

	public void setLibcateg(String libcateg) {
		this.libcateg = libcateg;
	}
	@Override
	public String toString() {
		return "Scategorie [id=" + id + ", code=" + code + ", libelle=" + libelle + ", libcateg=" + libcateg+ "]";
	}



	public Scategorie(long id, String code, String libelle, String libcateg) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.libcateg = libcateg;
	}
	
	
}
