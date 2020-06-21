package com.example.cinema.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	 
	 @ManyToMany (cascade = CascadeType.ALL)
	 @JoinTable(name="programme_film",
	 joinColumns={@JoinColumn(name="id_salle")}, 
	 inverseJoinColumns={@JoinColumn(name ="id_film")})
	 @OnDelete(action = OnDeleteAction.CASCADE)
	 private List<Film> film;

}
