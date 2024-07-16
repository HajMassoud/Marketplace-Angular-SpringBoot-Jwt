package com.smartnet.projet.dto;


public class ListArticle {
    private long id;
 	private String code;
	private String libelle;
	private String libscateg;
	private String libcateg;
	private String filename;
	private double pa ;
	private double pv ;
	private int tva ;
	private int stock ;
	
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

	public String getLibscateg() {
		return libscateg;
	}

	public void setLibscateg(String libscateg) {
		this.libscateg = libscateg;
	}

	public String getLibcateg() {
		return libcateg;
	}

	public void setLibcateg(String libcateg) {
		this.libcateg = libcateg;
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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "ListArticle [id=" + id + ", code=" + code + ", libelle=" + libelle + ", libscateg=" + libscateg
				+ ", libcateg=" + libcateg + ", filename=" + filename + ", pa=" + pa + ", pv=" + pv + ", tva=" + tva
				+ ", stock=" + stock + "]";
	}
 
	public ListArticle(long id, String code, String libelle,String filename, String libscateg, String libcateg, double pa, double pv,
			int tva, int stock) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.libscateg = libscateg;
		this.libcateg = libcateg;
		this.filename=filename;
		this.pa = pa;
		this.pv = pv;
		this.tva = tva;
		this.stock = stock;
	}

	public ListArticle() {
		super();
	}

 

}
