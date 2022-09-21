package com.mx.servicio;

import java.util.List;
import java.util.Optional;

import com.mx.model.Consultorios;

public interface ConsultoriosService {
	public abstract Consultorios insertaActualizaConsultorios(Consultorios obj);
	public abstract void eliminaConsultorios(int id);
	public abstract List<Consultorios> listarTodo();
	public abstract List<Consultorios> listarPorNumero_consultorio(String numero_consultorio);
	public abstract Optional<Consultorios> buscarId(int id);
}
