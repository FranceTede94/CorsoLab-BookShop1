package it.corso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import it.corso.dao.AutoreDao;
import it.corso.model.Autore;
import jakarta.persistence.EntityNotFoundException;


@Service
public class AutoreServiceImp implements AutoreService {

	@Autowired 
	private AutoreDao autoreDao;
	
	@Override
	public List<Autore> getAll() {
		List<Autore> autori = (List<Autore>) autoreDao.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		return autori;
	}
	
	@Override
	public void save(Autore autore) {
	autoreDao.save(autore);
	
	}
	
	@Override
	public Autore getAutoreById(int id) {
	Optional<Autore> autoreoOptional = autoreDao.findById(id);
		
		if(autoreoOptional.isPresent()) {
			return autoreoOptional.get();
		}
		throw new EntityNotFoundException("Non trovato");
	}

	@Override
	public void deleteAutore(Autore autore) {
		autoreDao.delete(autore);		
	}

	
	@Override
	public void modificaAutore(Autore autore) {
		autoreDao.save(autore);		
	}

	
}