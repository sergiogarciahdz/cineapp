package com.serch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="noticias")
public class Noticia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //MYSQL -> IDENTITY :: ORACLE -> SEQUENCE
	private int id;
	private String titulo;
	
	@Column(name="detalle")
	private String detalles;
	private String status;
	private Date fecha;

	public Noticia() {
		this.fecha = new Date();
	}

	public Noticia(int id, String titulo, String detalles, String status, Date fecha) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.detalles = detalles;
		this.status = status;
		this.fecha = getFecha();
	}

	public Noticia(String titulo, String detalles, String status) {
		super();
		this.titulo = titulo;
		this.detalles = detalles;
		this.status = status;
		this.fecha = getFecha();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", detalles=" + detalles + ", status=" + status + ", fecha="
				+ fecha + "]";
	}
	
	
	
}
