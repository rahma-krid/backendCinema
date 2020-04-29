package com.example.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinema.dao.ICategoryDAO;
import com.example.cinema.dao.IEventDAO;
import com.example.cinema.entities.Categorie;
import com.example.cinema.entities.Event;

@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge=3600)
@RestController
public class CategoryController {
	
	@Autowired
	private ICategoryDAO categRepository;
	
	@Autowired
	private IEventDAO eventrepository;
	
	
	@RequestMapping("/all")
	public @ResponseBody Iterable<Categorie> getCategs(){
		
	return categRepository.findAll();
	}
	
	
	
@PostMapping(path="/add") // Map ONLY POST Requests
	  public @ResponseBody String addNewcateg (@RequestParam String nom) {
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request

	    Categorie n = new Categorie();
	   n.setNom(nom);
	   categRepository.save(n);
	    return "Saved";
	  }
	
	@RequestMapping("/save")
	public Categorie saveProduit(Categorie p){
		categRepository.save(p);
	return p;
	}
	
	@RequestMapping("/delete")
	public boolean delete(int idcateg){
		categRepository.deleteById(idcateg);
	return true;
	}
	@RequestMapping("/update")
	public Categorie update(Categorie p){
		categRepository.saveAndFlush(p);
	return p;
	}
	

}
