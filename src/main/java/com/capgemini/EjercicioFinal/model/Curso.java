package com.capgemini.EjercicioFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cursos")
public class Curso {

	@Id
	@Column(name="idcurso")
	private int idCurso;
	
	@Column(name="nombre_curso")
	private String nombre_curso;
	
	@Column(name="id_profesor")
	private int id_profesor;
	
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getNombre_curso() {
		return nombre_curso;
	}
	public void setNombre_curso(String nombre_curso) {
		this.nombre_curso = nombre_curso;
	}
	public int getId_profesor() {
		return id_profesor;
	}
	public void setId_profesor(int id_profesor) {
		this.id_profesor = id_profesor;
	}
	
	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", nombre_curso=" + nombre_curso + ", id_profesor=" + id_profesor + "]";
	}

}
