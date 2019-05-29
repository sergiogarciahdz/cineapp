package com.serch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serch.model.Detalle;
import com.serch.repository.DetallesRepository;

@Service
public class DetalleServiceJPA implements DetallesService{

	@Autowired
	private DetallesRepository detalleRepository;
	
	@Override
	public void insertar(Detalle detalle) {
		detalleRepository.save(detalle);
	}

	@Override
	public void delete(int id) {
		detalleRepository.deleteById(id);
	}

}
