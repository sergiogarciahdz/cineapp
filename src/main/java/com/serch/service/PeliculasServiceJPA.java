package com.serch.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serch.model.Pelicula;
import com.serch.repository.PeliculasRepository;

@Service
public class PeliculasServiceJPA implements PeliculasService{

	@Autowired
	private PeliculasRepository peliculasRepository;
	
	@Override
	public List<Pelicula> all() {
		return peliculasRepository.findAll();
	}

	@Override
	public Pelicula findById(int id) {
		Optional<Pelicula> pelicula = peliculasRepository.findById(id);
		if (pelicula.isPresent()) {
			return pelicula.get();
		}else {
			return null;
		}
	}

	@Override
	public void insert(Pelicula pelicula) {
		peliculasRepository.save(pelicula);
	}

	@Override
	public List<String> searchGenero() {
		List<String> generos = new LinkedList<>();
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");
		return generos;
	}

	@Override
	public void delete(int id) {
		peliculasRepository.deleteById(id);
	}
	
	

}
