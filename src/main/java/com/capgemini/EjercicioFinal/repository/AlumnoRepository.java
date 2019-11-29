package com.capgemini.EjercicioFinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.EjercicioFinal.model.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository <Alumno, Long>{

	
}
