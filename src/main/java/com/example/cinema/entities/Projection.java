package com.example.cinema.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Projection {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id_proj;
	
	private double prix;
	
	private Date datep ;
	
	 @ManyToOne
	 @JoinColumn (name="id_film")
	 private Film film;
	 
	 
	 @ManyToOne
	 @JoinColumn (name="id_salle")
	 private Salle salle;

}
