package it.corso.service;

import java.util.List;
import it.corso.model.Libro;

public interface LibroService {
	
	List<Libro> getAll();
	
	void saveLibro(Libro libro);
	
	Libro getlibroById(int id);
    
    void deleteLibro(Libro libro);
    
    void modificaLibro(Libro libro);

	

}
