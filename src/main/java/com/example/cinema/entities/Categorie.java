package com.example.cinema.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
public class Categorie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCateg;
	private String nom ;
	
	@OneToMany(mappedBy="categorie")
	private Collection<Film> films;

	public Integer getIdCateg() {
		return idCateg;
	}

	public void setIdCateg(Integer idCateg) {
		this.idCateg = idCateg;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Film> getFilms() {
		return films;
	}

	public void setFilms(Collection<Film> films) {
		this.films = films;
	}

	public Categorie(Integer idCateg, String nom, Collection<Film> films) {
		super();
		this.idCateg = idCateg;
		this.nom = nom;
		this.films = films;
	}

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
}
