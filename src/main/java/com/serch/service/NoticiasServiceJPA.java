package com.serch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serch.model.Noticia;
import com.serch.repository.NoticiasRepository;

@Service
public class NoticiasServiceJPA implements NoticiasService{
	
	@Autowired
	private NoticiasRepository noticiasRepository;

	@Override
	public List<Noticia> all() {
		return noticiasRepository.findAll();
	}

	@Override
	public void save(Noticia noticia) {
		noticiasRepository.save(noticia);
	}
	
	@Override
	public void delete(int id) {
		noticiasRepository.deleteById(id);
	}

	@Override
	public Noticia findById(int id) {
		Optional<Noticia> noticia = noticiasRepository.findById(id);
		if (noticia.isPresent()) {
			return noticia.get();
		}else {
			return null;
		}
	}

	
}
