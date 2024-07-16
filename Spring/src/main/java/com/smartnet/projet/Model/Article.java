package com.smartnet.projet.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table (name = "article")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name="id")
	private long id ;
	@Column(name="code")
	private String code ;
	@Column(name="libelle")
	private String libelle;
	@Column(name="prix_achat")
	private double pa ;
	@Column(name="prix_vente")
	private double pv ;
	@Column(name="tva")
	private int tva ;
	@Column(name="stock")
	private int stock ;
	@Column(name="libcateg")
	private String libcateg;
	@Column(name="libscateg")
	private String libscateg;
	@Column(name="description")
	private String description;
	@Column(name="libfour")
	private String libfour;
	//c'est pour le lien d'image
	@Column(name="filename")
	private String filename ;
	
	
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

	public double getPa() {
		return pa;
	}
	public void setPa(double pa) {
		this.pa = pa;
	}
	public double getPv() {
		return pv;
	}
	public void setPv(double pv) {
		this.pv = pv;
	}
	public int getTva() {
		return tva;
	}
	public void setTva(int tva) {
		this.tva = tva;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getLibcateg() {
		return libcateg;
	}
	public void setLibcateg(String libcateg) {
		this.libcateg = libcateg;
	}
	public String getLibscateg() {
		return libscateg;
	}
	public void setLibscateg(String libscateg) {
		this.libscateg = libscateg;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getLibfour() {
		return libfour;
	}
	public void setLibfour(String libfour) {
		this.libfour = libfour;
	}

	
	@Override
	public String toString() {
		return "Article [id=" + id + ", code=" + code + ", libelle=" + libelle + ", pa=" + pa + ", pv=" + pv + ", tva="
				+ tva + ", stock=" + stock + ", libcateg=" + libcateg + ", libscateg=" + libscateg + ", description="
				+ description + ", libfour=" + libfour + ", filename=" + filename + "]";
	}
	
	public Article(long id, String code, String libelle, double pa, double pv, int tva, int stock, String libcateg,
			String libscateg, String description, String libfour, String filename) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.pa = pa;
		this.pv = pv;
		this.tva = tva;
		this.stock = stock;
		this.libcateg = libcateg;
		this.libscateg = libscateg;
		this.description = description;
		this.libfour = libfour;
		this.filename = filename;
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
