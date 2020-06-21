package com.example.cinema.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.cinema.entities.Film;

public interface IFilmDAO {

	List<Film> findAllBy(String categorie, String titre);








}
