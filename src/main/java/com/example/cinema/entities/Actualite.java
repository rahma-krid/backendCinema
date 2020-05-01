package com.example.cinema.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity

public class Actualite implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id  ;
	private String titre_actualite;
	private Date date_actualite ;
	private String description_actualite ;
	private String contenu_actualite ;
	private String photo_actualite ;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre_actualite() {
		return titre_actualite;
	}

	public void setTitre_actualite(String titre_actualite) {
		this.titre_actualite = titre_actualite;
	}

	public Date getDate_actualite() {
		return date_actualite;
	}

	public void setDate_actualite(Date date_actualite) {
		this.date_actualite = date_actualite;
	}

	public String getDescription_actualite() {
		return description_actualite;
	}

	public void setDescription_actualite(String description_actualite) {
		this.description_actualite = description_actualite;
	}

	public String getContenu_actualite() {
		return contenu_actualite;
	}

	public void setContenu_actualite(String contenu_actualite) {
		this.contenu_actualite = contenu_actualite;
	}

	public String getPhoto_actualite() {
		return photo_actualite;
	}

	public void setPhoto_actualite(String photo_actualite) {
		this.photo_actualite = photo_actualite;
	}

	@ManyToOne
	@JoinColumn (name="id_redacteur")
	private Redacteur redacteur;
	public Redacteur getRedacteur() {
		return redacteur;
	}

	public void setRedacteur(Redacteur redacteur) {
		this.redacteur = redacteur;
	}

}
