package com.example.cinema.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.cinema.entities.Categorie;
import com.example.cinema.entities.Film;
import com.example.cinema.dao.CustomerRowMapper;
import com.example.cinema.dao.IFilmDAO;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class FilmController implements IFilmDAO{
	@Autowired
    EntityManager entityManager;
	@Autowired
     JdbcTemplate jdbcTemplate;
	@Autowired
	IFilmDAO film;

	@RequestMapping(value = "/filmbysearch/{cat}/{titre}", method = RequestMethod.GET)
	  @ResponseBody
	public List<Film> findAllBy(@PathVariable(value = "cat") String categorie, @PathVariable(value = "titre") String titre) {

		String sql = "SELECT * FROM `film` as f,categorie as cat WHERE  cat.id_categ =f.`id_categ` and (f.titre='"+titre+"' or cat.nom='"+categorie+"')";

		List<Film> customers = new ArrayList<>();
		  
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map row : rows) {
        	Film obj = new Film();
        	Categorie ob = new Categorie();
            obj.setTitre((String) row.get("titre"));
            obj.setId((Long) row.get("id"));
            obj.setCible((String) row.get("cible"));
            obj.setPhoto((String) row.get("photo"));
            obj.setDetails((String) row.get("details"));
            ob.setNom((String) row.get("nom"));
            
            customers.add(obj);
        }

        return customers;
        
	}
	 
}
