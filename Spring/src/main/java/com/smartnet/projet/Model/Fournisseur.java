package com.smartnet.projet.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name = "fournisseur")
public class Fournisseur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id ;
	@Column(name="code")
	private int code ;
	@Column(name="FourName")
	private String fourName;
	@Column(name="adresse")
	private String adresse ;
	@Column(name="tel")
	private String tel ;
	@Column(name="email")
	private String email ;
	@Column(name="fax")
	private String fax ;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getFourName() {
		return fourName;
	}


	public void setFourName(String fourName) {
		this.fourName = fourName;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}
	




	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", code=" + code + ", fourName=" + fourName + ", adresse=" + adresse + ", tel="
				+ tel + ", email=" + email + ", fax=" + fax + "]";
	}


	public Fournisseur( long id,int code, String fourName, String adresse, String tel, String email, String fax) {
		super();
		this.id = id;
		this.code = code;
		this.fourName = fourName;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.fax = fax;
	}


	public Fournisseur() {
		super();
	}

}
