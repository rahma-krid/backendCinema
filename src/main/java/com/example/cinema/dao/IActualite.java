package com.example.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cinema.entities.Actualite;;



@Repository
public interface IActualite extends JpaRepository<Actualite,Integer> {
	
}
