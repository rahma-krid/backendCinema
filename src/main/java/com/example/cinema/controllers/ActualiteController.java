package com.example.cinema.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinema.entities.Actualite;
import com.example.cinema.entities.Categorie;
import com.example.cinema.entities.Film;
import com.example.cinema.dao.IActualite;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ActualiteController {
	
	@Autowired
	IActualite actualite;
	@GetMapping("/actualites")
	public List<Actualite> getAllEquipe() {

        return actualite.findAll();
	    
	}
	@PutMapping("/actualite/{id}")
	public ResponseEntity<Actualite> updateActualite(@PathVariable(value = "id") int employeeId,
			@Valid @RequestBody Actualite employeeDetails) throws ResourceNotFoundException {
		Actualite employee = actualite.findById((Integer) employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Actualite not found for this id :: " + employeeId));

		employee.setTitre_actualite(employeeDetails.getTitre_actualite());
		employee.setDate_actualite(employeeDetails.getDate_actualite());
		employee.setDescription_actualite(employeeDetails.getDescription_actualite());
		employee.setContenu_actualite(employeeDetails.getContenu_actualite());
		final Actualite updatedEmployee = actualite.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	@GetMapping("/actualites/{id}")
	public ResponseEntity<Actualite> getActualiteById(@PathVariable(value = "id") int employeeId)
			throws ResourceNotFoundException {
		Actualite act = actualite.findById((Integer) employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Actualite not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(act);
	}
	@PostMapping("/ajouteractualite")
	public Actualite createProject(@Valid @RequestBody Actualite pro) {
	    return actualite.save(pro);
	}
	@GetMapping("/rechercheactualite")
	public List<Actualite> getAllEquipebyId(String nom) {
        return actualite.findAll();
	    
	}

	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteActualitebyId(@PathVariable(value = "id") int employeeId)
			throws ResourceNotFoundException {
		Actualite employee = actualite.findById((Integer) employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("actualite not found for this id :: " + employeeId));

		actualite.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	@Autowired
    JdbcTemplate jdbcTemplate;
	@RequestMapping(value = "/actualitebysearch/{desc}", method = RequestMethod.GET)
	  @ResponseBody
	public List<Actualite> findAllBy( @PathVariable(value = "desc") String desc) {

		String sql = "SELECT * FROM `actualite` as a WHERE a.description_actualite LIKE  '%"+desc+"%'";

		List<Actualite> customerss = new ArrayList<>();
		  
      List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

      for (Map row : rows) {
    	  Actualite obj = new Actualite();
          obj.setTitre_actualite((String) row.get("titre_actualite"));
          obj.setId((Integer) row.get("id"));
          obj.setDescription_actualite((String) row.get("description_actualite"));
          obj.setPhoto_actualite((String) row.get("photo_actualite"));
          obj.setContenu_actualite((String) row.get("contenu_actualite"));
          
          customerss.add(obj);
      }

      return customerss;
      
	}
	
}
