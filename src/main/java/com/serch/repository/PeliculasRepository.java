package com.serch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serch.model.Pelicula;

@Repository
public interface PeliculasRepository extends JpaRepository<Pelicula, Integer>{

	
	
}
