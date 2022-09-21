package com.mx.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.model.Citas;
import com.mx.repository.CitasRepository;

@Service
public class CitasServiceImpl implements CitasService {

	@Autowired
	private CitasRepository citasRepository;
	
	@Override
	public List<Citas> ListaCitas() {
		return citasRepository.findAll();
	}
	
}
