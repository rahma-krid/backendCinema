package com.example.cinema.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
@PrimaryKeyJoinColumn(name="id_redacteur")
public class Redacteur {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
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
	public Collection<Actualite> getActualite() {
		return actualite;
	}
	public void setActualite(Collection<Actualite> actualite) {
		this.actualite = actualite;
	}
	@Id
	@GeneratedValue
	private Long id ;
	private String nom;
	 private  String email ;
	 private String adresse ;
	@OneToMany(mappedBy="redacteur")
	private Collection<Actualite> actualite;
}
