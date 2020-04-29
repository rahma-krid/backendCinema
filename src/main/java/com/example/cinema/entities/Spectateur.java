package com.example.cinema.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@PrimaryKeyJoinColumn(name="id_spectateur")
public class Spectateur extends Utilisateur {
	
	
	@Id
	@GeneratedValue
	private Long id ;
	private String nom;
	 private  String email ;
	 private String adresse ;

	 private int tel ;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public Spectateur(Long id, String nom, String email, String adresse, int tel) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.adresse = adresse;
		this.tel = tel;
	}
	public Spectateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
	 