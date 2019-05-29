package com.serch.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serch.model.Horario;
import com.serch.repository.HorariosRepository;

@Service
public class HorariosServiceJPA implements HorariosService{

	@Autowired
	private HorariosRepository horariosRepository;
	
	@Override
	public void save(Horario horario) {
		horariosRepository.save(horario);
	}
	
	@Override
	public List<Horario> findByIdPelicula(int id, Date fecha) {
		return horariosRepository.findByPelicula_IdAndFechaOrderByHora(id, fecha);
	}

	@Override
	public List<Horario> findAllByIdPelicula(int id) {
		return horariosRepository.findByPelicula_Id(id);
	}

	@Override
	public Horario findById(int id) {
		Optional<Horario> horario = horariosRepository.findById(id);
		if (horario.isPresent()) {
			return horario.get();
		}else {
			return null;
		}
	}

	@Override
	public void delete(int id) {
		horariosRepository.deleteById(id);
	}

}
