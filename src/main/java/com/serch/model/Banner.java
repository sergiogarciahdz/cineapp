package com.serch.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="banners")
public class Banner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //MYSQL -> IDENTITY :: ORACLE -> SEQUENCE
	private int id;
	private String titulo;
	private Date fecha;
	private String archivo;
	private String status;

	Banner(){
		this.fecha = new Date();
	}

	public Banner(int id, String titulo, Date fecha, String archivo, String status) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.fecha = fecha;
		this.archivo = archivo;
		this.status = status;
	}

	public Banner(String titulo, Date fecha, String archivo, String status) {
		super();
		this.titulo = titulo;
		this.fecha = fecha;
		this.archivo = archivo;
		this.status = status;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Banner [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", archivo=" + archivo + ", status="
				+ status + "]";
	}
	
	
}
