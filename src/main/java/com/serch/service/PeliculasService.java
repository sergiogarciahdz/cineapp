package com.serch.service;

import java.util.List;

import com.serch.model.Pelicula;

public interface PeliculasService {
	
	public List<Pelicula> all();
	
	public Pelicula findById(int id);
	
	public void insert(Pelicula pelicula);
	
	public List<String> searchGenero();
	
	public void delete(int id);

}
