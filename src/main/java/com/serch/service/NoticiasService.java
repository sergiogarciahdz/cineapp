package com.serch.service;

import java.util.List;

import com.serch.model.Noticia;

public interface NoticiasService {
	
	public List<Noticia> all();
	
	public void save(Noticia noticia);
	
	public void delete(int id);
	
	public Noticia findById(int id);

}
