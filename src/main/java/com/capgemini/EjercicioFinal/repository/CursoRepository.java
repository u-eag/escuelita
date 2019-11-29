package com.capgemini.EjercicioFinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.EjercicioFinal.model.Curso;

@Repository
public interface CursoRepository extends CrudRepository <Curso, Long>{

	Curso findByIdCurso (int idCurso);
}
