package com.example.cinema.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salle {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	 private int id_salle ;
	
	 private String nom ;
	 
	 private int nbplaces ;
	 
	
	 private double longitude ;
	 private double latitude ;
	 
	 @OneToMany(mappedBy="salle")
		private Collection<Event> events;
	 
	 
	 @ManyToOne
	 @JoinColumn (name="id_ville")
	 private Ville ville;

}
