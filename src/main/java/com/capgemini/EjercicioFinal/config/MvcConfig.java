package com.capgemini.EjercicioFinal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

	public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("principal");
        registry.addViewController("/principal").setViewName("principal");
        registry.addViewController("/alumnos").setViewName("alumnos");
        registry.addViewController("/cursos").setViewName("cursos");
    }
}
