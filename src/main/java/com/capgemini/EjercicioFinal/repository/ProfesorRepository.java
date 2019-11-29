package com.capgemini.EjercicioFinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.EjercicioFinal.model.Profesor;

@Repository
public interface ProfesorRepository extends CrudRepository <Profesor, Long>{

	Profesor findByIdProfesor (int id);
	Profesor findByMail (String mail);
}
