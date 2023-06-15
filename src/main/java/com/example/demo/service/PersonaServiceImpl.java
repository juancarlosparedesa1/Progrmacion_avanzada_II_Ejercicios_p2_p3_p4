package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IPersonaRepository;
import com.example.demo.repository.modelo.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaRepository personaRepository;

	@Override
	public void guarda(Persona persona) {
		// TODO Auto-generated method stub
		this.personaRepository.insertar(persona);
	}

	@Override
	public Persona seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.personaRepository.Seleccionar(id);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.personaRepository.actualizar(persona);

	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.personaRepository.eliminar(id);

	}

}
