package com.serch.service;

import java.util.Date;
import java.util.List;

import com.serch.model.Horario;

public interface HorariosService {

	public void save(Horario horario);
	
	public List<Horario> findByIdPelicula(int id, Date fecha);
	
	public List<Horario> findAllByIdPelicula(int id);
	
	public Horario findById(int id);
	
	public void delete(int id);
	
}
