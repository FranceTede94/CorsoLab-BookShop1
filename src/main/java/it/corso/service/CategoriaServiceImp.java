package it.corso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import it.corso.dao.CategoriaDao;
import it.corso.model.Categoria;
import jakarta.persistence.EntityNotFoundException;


@Service
public class CategoriaServiceImp implements CategoriaService {

	@Autowired
	CategoriaDao categoriaDao;
	
	
	@Override
	public List<Categoria> getAll() {
		List<Categoria> categoria = (List<Categoria>) categoriaDao.findAll(Sort.by(Sort.Direction.ASC, "nome")); 
		return categoria;
	}
	
	@Override
	public void save(Categoria categoria) {
	categoriaDao.save(categoria);
	
	}
	
	@Override
	public Categoria getCategoriaById(int id) {
	Optional<Categoria> categoriaOptional = categoriaDao.findById(id);
		
		if(categoriaOptional.isPresent()) {
			return categoriaOptional.get();
		}
		throw new EntityNotFoundException("Non trovato");
	}

	@Override
	public void deleteCategoria(Categoria categoria) {
		categoriaDao.delete(categoria);		
	}
	
	
	@Override
	public void modificaCategoria(Categoria categoria) {
		categoriaDao.save(categoria);		
	}



}