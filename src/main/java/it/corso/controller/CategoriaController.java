package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Categoria;
import it.corso.service.CategoriaService;


@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public String getCategoria(Model model) {
		Categoria categoria = new Categoria();
		model.addAttribute("categorie", categoriaService.getAll());
		model.addAttribute("categoria", categoria);
		return "home-categoria";
	}
	
	
	@PostMapping("save")
	public String saveCategoria(@ModelAttribute("categoria") Categoria categoria) {
		categoriaService.save(categoria);
		return "redirect:/categoria";
	}
	
	@GetMapping("delete")
	public String deleteCategoria(@RequestParam("id") int id) {
		categoriaService.deleteCategoria(categoriaService.getCategoriaById(id));
		return "redirect:/categoria";
	}
	
	@GetMapping("/update")
	public String editCategoria(@RequestParam("id") int id, Model model) {
		Categoria categoria = categoriaService.getCategoriaById(id);
		model.addAttribute("categoria", categoria);
		return "modifica-categoria";
	}
	
	
	@PostMapping("/update/{id}")
	public String modificaCategoria(@PathVariable("id") int id, @ModelAttribute("categoria") Categoria categoria) {
		categoriaService.modificaCategoria(categoria);
		return "redirect:/categoria";
	}
	

}
