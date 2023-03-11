package com.pool.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pool.model.Coffe;
import com.pool.model.Size;

@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {
	
	List<Coffe> coffes=new ArrayList<>();
	
	public CoffeeController() {
		coffes.add(new Coffe(1,"Garam Coffe", Size.SHORT));
		coffes.add(new Coffe(2,"Masala Coffe", Size.GRANDE));
		coffes.add(new Coffe(3,"Allam Coffe", Size.TALL));
		coffes.add(new Coffe(4,"Boost Coffe", Size.VENTI));
	}
	
	@GetMapping
	public List<Coffe> findAll(){
		return coffes;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		Predicate<Coffe> predicateCoffe=coffee->coffee.equals(id);
		coffes.removeIf(predicateCoffe);
	}

}
