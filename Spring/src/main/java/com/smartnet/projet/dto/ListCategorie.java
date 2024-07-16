///c'est pour DTo data transfer object
package com.smartnet.projet.dto;


public class ListCategorie {
    private long id;
 	private String code;
	private String libelle;
	private String libcateg;
	private String ccateg;
	
public ListCategorie(long id,String code, String libelle, String libcateg, String ccateg) {
		super();
		this.id =id;
		this.code = code;
		this.libelle = libelle;
		this.libcateg = libcateg;
		this.ccateg = ccateg;
		
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
	public String getCcateg() {
		return ccateg;
	}
	public void setCcateg(String ccateg) {
		this.ccateg = ccateg;
	}
	@Override
	public String toString() {
		return "ListCategorie [id=" + id + ", code=" + code + ", libelle=" + libelle + ", libcateg=" + libcateg
				+ ", ccateg=" + ccateg + "]";
	}

	
	


}
