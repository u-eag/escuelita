package com.capgemini.EjercicioFinal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.capgemini.EjercicioFinal.model.Profesor;
import com.capgemini.EjercicioFinal.repository.ProfesorRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/principal").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        
        Profesor profesor = profesorRepository.findByIdProfesor(1);
        @SuppressWarnings("deprecation")
		UserDetails profe1 =
                User.withDefaultPasswordEncoder() // está tachado porque está deprecado pero todavía sirve
                   .username(profesor.getMail())
                   .password(profesor.getPassword())
                   .roles("USER")
                   .build();

        return new InMemoryUserDetailsManager(profe1);
    }
}
