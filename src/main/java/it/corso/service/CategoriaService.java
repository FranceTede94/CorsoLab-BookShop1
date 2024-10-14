package it.corso.service;

import java.util.List;

import it.corso.model.Categoria;

public interface CategoriaService {
	
	List<Categoria> getAll();
	
	 void save(Categoria categoria);
	 
	 Categoria getCategoriaById(int id);
	    
	 void deleteCategoria (Categoria categoria);
	 
	 void modificaCategoria(Categoria categoria);

}
