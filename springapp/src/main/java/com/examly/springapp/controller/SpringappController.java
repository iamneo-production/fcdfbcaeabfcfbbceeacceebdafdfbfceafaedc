package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.examly.springapp.model.Springapp;
import com.examly.springapp.service.SpringappService;

@Controller
@ComponentScan(basePackages = "com.example.springapp")
public class SpringappController {

	@Autowired
	private SpringappService springappservice;
	
	// display list of Students
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "name", "asc", model);		
	}
	
	@GetMapping("/new_task")
	public String new_task(Model model) {
		// create model attribute to bind form data
		Springapp task = new Springapp();
		model.addAttribute("task", task);
		return "new_task";
	}
	
	@PostMapping("/saveTask")
	public String saveTask(@ModelAttribute("task") Springapp task) {
		// save Student to database
		springappservice.saveTask(task);
		return "redirect:/";
	}
	
	@GetMapping("/changeStatus/{id}")
	public String changeStatus(@PathVariable ( value = "id") int id, Model model) {
		
		// get Student from the service
		Springapp springapp= springappservice.getTaskById(id);
		
		// set Student as a model attribute to pre-populate the form
		model.addAttribute("task", springapp);
		return "update_status";
	}
	
	@GetMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable (value = "id") int id) {
		
		// call delete Student method 
		this.springappservice.deleteTask(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Springapp> page = springappservice.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Springapp> ls = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("ls", ls);
		return "index";
	}
}