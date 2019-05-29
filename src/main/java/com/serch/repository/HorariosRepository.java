package com.serch.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serch.model.Horario;

@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer>{

	public List<Horario> findByPelicula_IdAndFechaOrderByHora(int id, Date fecha);
	
	public List<Horario> findByPelicula_Id(int id);
	
}
