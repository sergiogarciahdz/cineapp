package com.serch.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serch.model.Noticia;

@Repository
//public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {

	//CONSULTA PERSONALIZADA SOLO CON AGREGAR EL ATRIBUTO CORRECTO
	//select * from Noticia where status = ?
	List<Noticia> findByStatus(String status); 
	
	List<Noticia> findByFecha(Date fecha);
	
	List<Noticia> findByStatusAndFecha(String status, Date fecha);
	
	List<Noticia> findByStatusOrFecha(String status, Date fecha);
	
	List<Noticia> findByFechaBetween(Date fechaIni, Date fechaFin);
	
	List<Noticia> findByIdBetween(int idIni, int idFin);
}	
