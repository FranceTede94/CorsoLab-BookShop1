package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Autore;
import it.corso.service.AutoreService;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/autore")
public class AutoreController {
	
	@Autowired
	private AutoreService autoreService;
	
	@GetMapping
	public String getAutore(Model model) {
		Autore autore = new Autore();
		model.addAttribute("autori", autoreService.getAll());
		model.addAttribute("autore", autore);
		return "home-autori";
	}
	
	@PostMapping("save")
	public String saveAutori(@ModelAttribute("autore") Autore autore) {
		autoreService.save(autore);
		return "redirect:/autore";
	}
		

	@GetMapping("delete")
	public String deleteAutori(@RequestParam("id") int id) {
		autoreService.deleteAutore(autoreService.getAutoreById(id));
		return "redirect:/autore";
	}
	
	
	@GetMapping("update")
	public String editAutore(@RequestParam("id") int id, Model model) {
		Autore autore = autoreService.getAutoreById(id);
		model.addAttribute("autore", autore);
		return "modifica-autori";
	}
	
	@PostMapping("update/{id}")
	public String modificaAutore(@PathVariable("id") int id, @ModelAttribute("autore") Autore autore) {
		autoreService.modificaAutore(autore);
		return "redirect:/autore";
	}
	
		

}

