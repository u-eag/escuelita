package com.capgemini.EjercicioFinal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.EjercicioFinal.model.Alumno;
import com.capgemini.EjercicioFinal.model.Curso;
import com.capgemini.EjercicioFinal.model.Tema;
import com.capgemini.EjercicioFinal.repository.AlumnoRepository;
import com.capgemini.EjercicioFinal.repository.CursoRepository;
import com.capgemini.EjercicioFinal.repository.TemaRepository;

@Controller
public class EscuelitaController {

	private static final Logger log = LoggerFactory.getLogger(EscuelitaController.class);

	// Alumnos:
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping("/alumnos")
	public String alumnoForm(Model model) {
		model.addAttribute("alumno", new Alumno()); // creo un objeto de la clase Alumno
		model.addAttribute("cursos", cursoRepository.findAll());
		return "alumnos"; // retorno el nombre del archivo html
	}

	@PostMapping("/alumnos")
	public String alumnoSubmit(@ModelAttribute Alumno alumno, Model model) {

		alumnoRepository.save(alumno);

		// fetch all alumnos
		log.info("Alumnos found with findAll():");
		log.info("-------------------------------");
		for (Alumno alumnoPersistido : alumnoRepository.findAll()) {
			log.info(alumnoPersistido.toString());
		}
		log.info("");
		
		model.addAttribute("curso", cursoRepository.findByIdCurso(alumno.getIdCurso()));

		return "alumnoResult";
	}

	// Temas y Cursos:
	@Autowired
	private TemaRepository temaRepository;
	
	//@Autowired
	//private CursoRepository cursoRepository;
	
	@GetMapping("/cursos")
	public String temaForm(Model model) {
	
		model.addAttribute("temaElegido", new Tema()); // declaro un objeto de tipo tema
		
		model.addAttribute("cursoEncontrado", new Curso()); // este siempre va a ser null en el get
		
		// fetch all temas
		model.addAttribute("temas", temaRepository.findAll()); // lista de todos los temas

		return "cursos";
	}
	
	@PostMapping("/cursos")
	public String temaSubmit(@ModelAttribute Tema temaElegido, Model model) {

		// fetch all temas para desplegarlos de nuevo la lista
		model.addAttribute("temas", temaRepository.findAll()); // lista de todos los temas
		
		// fetch tema buscado
		log.info("Tema found with findByIdTema():");
		log.info("-------------------------------");
		Tema temaBuscado = temaRepository.findByIdTema(temaElegido.getIdTema());
		log.info(temaBuscado.toString());
		log.info("");
		
		// fetch curso de ese tema buscado
		log.info("Curso found with findByIdCurso():");
		log.info("-------------------------------");
		Curso cursoEncontrado = cursoRepository.findByIdCurso(temaBuscado.getId_curso());
		log.info(cursoEncontrado.toString());
		log.info("");
		model.addAttribute("cursoEncontrado", cursoEncontrado);
		
		// vuelvo a hacer el get:
		model.addAttribute("temaElegido", new Tema()); 
		
		return "/cursos";
	}

}
