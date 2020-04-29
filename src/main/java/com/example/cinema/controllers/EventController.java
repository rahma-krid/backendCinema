package com.example.cinema.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.cinema.dao.IEventDAO;
import com.example.cinema.entities.Categorie;
import com.example.cinema.entities.Event;

@RestController
public class EventController {
	
	@Autowired
	private IEventDAO eventrepository;
	
	

	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping("/event/all")
	public @ResponseBody Iterable<Event> getEvents(){
		
	return eventrepository.findAll();
	}
	
	
	
	
	@PostMapping("/event/save")
	public Event addevent(@RequestBody Event e){
		eventrepository.save(e);
	return e;
	}
	
	
	
	@RequestMapping("/event/{id}")
	public Event update(@PathVariable("id") int id, @RequestBody Event e){
		eventrepository.saveAndFlush(e);
	return e;
	}
	
	
	
	

	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(path ={"/event/delete/{id}"})
	public void deleteevnet(@PathVariable("id") int id){
		eventrepository.deleteById(id);
    }
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(path ={"getevent/{id}"})
	public Optional<Event> getevent(@PathVariable("id") int id){
		return eventrepository.findById(id);
		
    }
	
	/*@PostMapping(path="/add") // Map ONLY POST Requests
	  public @ResponseBody String addNewcateg (@RequestParam String nom) {
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request

	    Categorie n = new Categorie();
	   n.setNom(nom);
	   categRepository.save(n);
	    return "Saved";
	  }*/
	
	

}
