package com.capgemini.EjercicioFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="temas")
public class Tema {

	@Id
	@Column(name="idtema")
	private int idTema;
	
	@Column(name="nombre_tema")
	private String nombre_tema;
	
	@Column(name="id_curso")
	private int id_curso;
	
	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	public String getNombre_tema() {
		return nombre_tema;
	}
	public void setNombre_tema(String nombre_tema) {
		this.nombre_tema = nombre_tema;
	}
	public int getId_curso() {
		return id_curso;
	}
	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}
	
	@Override
	public String toString() {
		return "Tema [idTema=" + idTema + ", nombre_tema=" + nombre_tema + ", id_curso=" + id_curso + "]";
	}
	
}
