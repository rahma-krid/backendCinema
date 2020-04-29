package com.example.cinema.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ville {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id_ville;
	
	private String nom;
	
	 private double longitude ;
	 private double latitude ;
	 
	 @OneToMany(mappedBy="ville" ,cascade={CascadeType.ALL})
	 private Collection<Salle> salles;
	 
	

}
