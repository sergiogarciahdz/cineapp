package com.serch.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="peliculas")
public class Pelicula {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //MYSQL -> IDENTITY :: ORACLE -> SEQUENCE
	private int id;
	
	private String titulo;
	private int duracion=100;
	private String clasificacion="A";
	private String genero;
	private String imagen="cinema.png";
	private Date fechaEstreno;
	private String status;
	
	//@Transient //ignora el atributo durante la persistencia
	@OneToOne
	@JoinColumn(name="idDetalles")
	private Detalle detalle;
	
	@OneToMany(mappedBy="pelicula", fetch=FetchType.EAGER)
	private List<Horario> horarios;
	
	Pelicula(){}

	public Pelicula(int id, String titulo, int duracion, String clasificacion, String genero, String imagen,
			Date fechaEstreno, String status) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.duracion = duracion;
		this.clasificacion = clasificacion;
		this.genero = genero;
		this.imagen = imagen;
		this.fechaEstreno = fechaEstreno;
		this.status = status;
	}

	public Pelicula(String titulo, int duracion, String clasificacion, String genero, String imagen, Date fechaEstreno,
			String status) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.clasificacion = clasificacion;
		this.genero = genero;
		this.imagen = imagen;
		this.fechaEstreno = fechaEstreno;
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

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", duracion=" + duracion + ", clasificacion="
				+ clasificacion + ", genero=" + genero + ", imagen=" + imagen + ", fechaEstreno=" + fechaEstreno
				+ ", status=" + status + ", detalle=" + detalle + "]";
	}

}
