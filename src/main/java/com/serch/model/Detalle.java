package com.serch.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detalles")
public class Detalle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //MYSQL -> IDENTITY :: ORACLE -> SEQUENCE
	private int id;
	
	private String director;
	private String actores;
	private String sinopsis;
	private String trailer;
	
	public Detalle(){}

	public Detalle(int id, String director, String actores, String sinopsis, String trailer) {
		super();
		this.id = id;
		this.director = director;
		this.actores = actores;
		this.sinopsis = sinopsis;
		this.trailer = trailer;
	}

	public Detalle(String director, String actores, String sinopsis, String trailer) {
		super();
		this.director = director;
		this.actores = actores;
		this.sinopsis = sinopsis;
		this.trailer = trailer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActores() {
		return actores;
	}

	public void setActores(String actores) {
		this.actores = actores;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	@Override
	public String toString() {
		return "Detalle [id=" + id + ", director=" + director + ", actores=" + actores + ", sinopsis=" + sinopsis
				+ ", trailer=" + trailer + "]";
	}
	
}
