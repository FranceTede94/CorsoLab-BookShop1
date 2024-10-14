package it.corso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.corso.dao.LibroDao;
import it.corso.model.Libro;
import jakarta.persistence.EntityNotFoundException;


@Service
public class LibroServiceImp implements LibroService {

	@Autowired
	LibroDao libroDao;
	
	
	@Override
	public List<Libro> getAll() {
		List<Libro> libro = (List<Libro>) libroDao.findAll(Sort.by(Sort.Direction.ASC, "titolo"));
		return libro;
	}
	
	@Override
	public void saveLibro(Libro libro) {
	libroDao.save(libro);
	
	}
	
	@Override
	public Libro getlibroById(int id) {
	Optional<Libro> libroOptional = libroDao.findById(id);
		
		if(libroOptional.isPresent()) {
			return libroOptional.get();
		}
		throw new EntityNotFoundException("Non trovato");
	}
	
	@Override
	public void deleteLibro(Libro libro) {
		libroDao.delete(libro);		
	}

	@Override
	public void modificaLibro(Libro libro) {
		libroDao.save(libro);		
	}


}