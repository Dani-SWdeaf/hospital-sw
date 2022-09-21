package com.mx.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "altaCitas")
public class AltaCita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_alta;
	
	private String nombre_paciente;
	private String fecha;
	private String hora_i_f;
	private String doctor;
	private String consultorio;
	
	public AltaCita() {
		super();
	}

	public Integer getId_alta() {
		return id_alta;
	}

	public void setId_alta(Integer id_alta) {
		this.id_alta = id_alta;
	}

	public String getNombre_paciente() {
		return nombre_paciente;
	}

	public void setNombre_paciente(String nombre_paciente) {
		this.nombre_paciente = nombre_paciente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora_i_f() {
		return hora_i_f;
	}

	public void setHora_i_f(String hora_i_f) {
		this.hora_i_f = hora_i_f;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(String consultorio) {
		this.consultorio = consultorio;
	}

	@Override
	public String toString() {
		return "AltaCita [id_alta=" + id_alta + ", nombre_paciente=" + nombre_paciente + ", fecha=" + fecha
				+ ", hora_i_f=" + hora_i_f + ", doctor=" + doctor + ", consultorio=" + consultorio + "]";
	}
}
