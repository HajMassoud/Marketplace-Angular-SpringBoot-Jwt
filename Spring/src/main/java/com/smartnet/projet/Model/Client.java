package com.smartnet.projet.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity 
@Table (name = "client")

public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id ;
	@Column(name="code")
	private String code ;
	@Column(name="clientname")
	private String clientname;
	@Column(name="adresse")
	private String adresse ;
	@Column(name="tel")
	private String tel ;
	@Column(name="email")
	private String email ;
	@Column(name="fax")
	private String fax ;
	@Column(name="passwordss")
	private String pwd ;
	@Column(name="filename")
	private String filename;
	

	
		
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
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
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
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
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", code=" + code + ", clientname=" + clientname + ", adresse=" + adresse + ", tel="
				+ tel + ", email=" + email + ", fax=" + fax + ", pwd=" + pwd + ", filename=" + filename + "]";
	}
	
	
	public Client(long id, String code, String clientname, String adresse, String tel, String email, String fax,
			String pwd, String filename) {
		super();
		this.id = id;
		this.code = code;
		this.clientname = clientname;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.fax = fax;
		this.pwd = pwd;
		this.filename = filename;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
