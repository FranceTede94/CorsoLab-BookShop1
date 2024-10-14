package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Libro;
import it.corso.service.AutoreService;
import it.corso.service.CategoriaService;
import it.corso.service.LibroService;

@Controller
@RequestMapping("/libro")
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	@Autowired
	private AutoreService autoreService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	 @GetMapping
	    public String getLibri(Model model) {
	        Libro libro = new Libro();
	        model.addAttribute("libri", libroService.getAll());
	        model.addAttribute("libro", libro);
	        model.addAttribute("autori", autoreService.getAll());
	        model.addAttribute("categorie", categoriaService.getAll());
	        return "home-libro";
	    }
	
	
	@PostMapping("save")
	public String saveLibro(@ModelAttribute("libro") Libro libro) {
		libroService.saveLibro(libro);
		
		return "redirect:/libro";
	}
	
	@GetMapping("delete")
	public String deleteLibro(@RequestParam("id") int id) {
		libroService.deleteLibro(libroService.getlibroById(id));
		return "redirect:/libro";
	}
	
	
	@GetMapping("update")
	public String editLibro(@RequestParam("id") int id, Model model) {
		Libro libro = libroService.getlibroById(id);
		model.addAttribute("libro", libro);
		model.addAttribute("autori", autoreService.getAll());
		model.addAttribute("categorie", categoriaService.getAll());
		return "modifica-libri";
	}
	
	@PostMapping("update/{id}")
	public String modificaLibro(@PathVariable("id") int id, @ModelAttribute("libro") Libro libro) {
		libroService.modificaLibro(libro);
		return "redirect:/libro";
	}
	

}
