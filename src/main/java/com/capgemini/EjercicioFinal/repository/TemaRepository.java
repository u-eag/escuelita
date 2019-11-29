package com.capgemini.EjercicioFinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.EjercicioFinal.model.Tema;


@Repository
public interface TemaRepository extends CrudRepository <Tema, Long>{

	Tema findByIdTema (int idTema);
}
