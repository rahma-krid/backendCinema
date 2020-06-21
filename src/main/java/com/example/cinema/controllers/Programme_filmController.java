package com.example.cinema.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinema.dao.IProgramme_film;
import com.example.cinema.entities.Actualite;
import com.example.cinema.entities.programme_film;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Programme_filmController {
	@Autowired
	IProgramme_film prog_film;
	
	@GetMapping("/prog_films")
	public List<programme_film> getAllProgrammeFilms() {

        return prog_film.findAll();
	    
	}
	
	@PostMapping("/ajouterprogFilm")
	public programme_film createProject(@Valid @RequestBody programme_film pro) {
	    return prog_film.save(pro);
	}
}
