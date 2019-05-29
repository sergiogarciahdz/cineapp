package com.serch.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="horarios")
public class Horario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //MYSQL -> IDENTITY :: ORACLE -> SEQUENCE
	private int id;
	private Date fecha;
	private String hora;
	private String sala;
	private double precio;
	
	//@Transient //ignora el atributo durante la persistencia
	@ManyToOne
	@JoinColumn(name="idPeliculas")
	private Pelicula pelicula;
	
	Horario(){}

	public Horario(int id, Date fecha, String hora, String sala, double precio, Pelicula pelicula) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.sala = sala;
		this.precio = precio;
		this.pelicula = pelicula;
	}

	public Horario(Date fecha, String hora, String sala, double precio, Pelicula pelicula) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.sala = sala;
		this.precio = precio;
		this.pelicula = pelicula;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	@Override
	public String toString() {
		return "Horario [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", sala=" + sala + ", precio=" + precio
				+ ", pelicula=" + pelicula + "]";
	}
	
}
