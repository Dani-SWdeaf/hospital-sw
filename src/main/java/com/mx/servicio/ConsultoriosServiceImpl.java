package com.mx.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.model.Consultorios;
import com.mx.repository.ConsultoriosRepository;

@Service
public class ConsultoriosServiceImpl implements ConsultoriosService {

	@Autowired
	private ConsultoriosRepository consultoriosRepository;
	
	@Override
	public Consultorios insertaActualizaConsultorios(Consultorios obj) {
		
		return consultoriosRepository.save(obj);
	}

	@Override
	public void eliminaConsultorios(int id) {
		consultoriosRepository.deleteById(id);
	}

	@Override
	public List<Consultorios> listarTodo() {
		return consultoriosRepository.findAll();
	}

	@Override
	public List<Consultorios> listarPorNumero_consultorio(String numero_consultorio) {
		return null;//return consultoriosRepository.listaPorNumero_consultorio(numero_consultorio);
	}

	@Override
	public Optional<Consultorios> buscarId(int id) {
		
		return consultoriosRepository.findById(id);
	}

}
