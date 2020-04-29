package com.example.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.cinema.entities.Event;


@RepositoryRestResource
@CrossOrigin("*")
public interface IEventDAO extends JpaRepository<Event,Integer>{
	

}
