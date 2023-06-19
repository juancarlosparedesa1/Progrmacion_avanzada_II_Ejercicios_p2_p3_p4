package com.example.demo.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.repository.IHabitacionRepository;
import com.example.demo.hotel.repository.modelo.Habitacion;

@Service
public class HabitacionServiceImpl implements IHabitacionService {

	@Autowired
	private IHabitacionRepository habitacionRepository;

	@Override
	public void ingresar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.habitacionRepository.insertar(habitacion);
	}

	@Override
	public Habitacion buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.buscar(id);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.habitacionRepository.actualizar(habitacion);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.habitacionRepository.eliminar(id);
	}

}
