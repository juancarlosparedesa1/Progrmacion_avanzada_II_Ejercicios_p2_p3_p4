package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IItemnRepository;
import com.example.demo.repository.modelo.Item;

@Service
public class ItemServiceImpl implements IItemnService {

	@Autowired
	private IItemnRepository itemnRepository;

	@Override
	public void agregar(Item item) {
		// TODO Auto-generated method

		Item itembd = this.itemnRepository.buscarPorCodigoBarras(item.getCodigoBarras());

		if (itembd == null) {
			this.itemnRepository.insertar(item);

		} else {
//			Item itembd = this.itemnRepository.buscarPorCodigoBarras(item.getCodigoBarras());
			itembd.setStock(itembd.getStock() + item.getStock());
			this.itemnRepository.actualizar(itembd);
		}
	}

	@Override
	public Item buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.itemnRepository.buscar(id);
	}

	@Override
	public void actualizar(Item item) {
		// TODO Auto-generated method stub
		this.itemnRepository.actualizar(item);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.itemnRepository.eliminar(id);
	}

}
