package com.mitocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mitocode.model.Persona;
import com.mitocode.repo.IPersonaRepo;

@Controller
public class DemoController {

	  @Autowired
	  private IPersonaRepo repo;
	
	  @GetMapping("/greeting")
	    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	       
		  //lógica de guardar a una base de datos con  save;guarda entidad...
		  Persona p= new Persona();
		  
		  p.setIdPersona(1);  // Esto se puede cambiar
		  p.setNombre("MitoCode");
		  repo.save(p); 
		  
		  model.addAttribute("name", name);
	        return "greeting";
	    }
	  
	  
	  @GetMapping("/listar")
	    public String greeting(Model model) {
		  //lógica 
		  model.addAttribute("personas", repo.findAll());
	        return "greeting";
	    }
	  
}
