package com.mx.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "citas")

public class Citas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cita;
	
	private String consultorio;
	
	private String doctor;
	
	private String horario_consulta;
	
	private String nombre_paciente;
	
	public Citas() {
		super();
	}

	public Integer getId_cita() {
		return id_cita;
	}

	public void setId_cita(Integer id_cita) {
		this.id_cita = id_cita;
	}

	public String getHorario_consulta() {
		return horario_consulta;
	}

	public void setHorario_consulta(String horario_consulta) {
		this.horario_consulta = horario_consulta;
	}

	public String getNombre_paciente() {
		return nombre_paciente;
	}

	public void setNombre_paciente(String nombre_paciente) {
		this.nombre_paciente = nombre_paciente;
	}

	public String getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(String consultorio) {
		this.consultorio = consultorio;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Citas [id_cita=" + id_cita + ", consultorio=" + consultorio + ", doctor=" + doctor
				+ ", horario_consulta=" + horario_consulta + ", nombre_paciente=" + nombre_paciente + "]";
	}
	
}
