package com.mx.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consultaCitas")
public class ConsultaCitas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_consultaCita;

	private String fecha_alta_cita;

	private String consultorio_alta_cita;

	private String doctor_alta_cita;

	public ConsultaCitas() {
		super();
	}

	public Integer getId_consultaCita() {
		return id_consultaCita;
	}

	public void setId_consultaCita(Integer id_consultaCita) {
		this.id_consultaCita = id_consultaCita;
	}

	public String getFecha_alta_cita() {
		return fecha_alta_cita;
	}

	public void setFecha_alta_cita(String fecha_alta_cita) {
		this.fecha_alta_cita = fecha_alta_cita;
	}

	public String getConsultorio_alta_cita() {
		return consultorio_alta_cita;
	}

	public void setConsultorio_alta_cita(String consultorio_alta_cita) {
		this.consultorio_alta_cita = consultorio_alta_cita;
	}

	public String getDoctor_alta_cita() {
		return doctor_alta_cita;
	}

	public void setDoctor_alta_cita(String doctor_alta_cita) {
		this.doctor_alta_cita = doctor_alta_cita;
	}

	@Override
	public String toString() {
		return "ConsultaCitas [id_consultaCita=" + id_consultaCita + ", fecha_alta_cita=" + fecha_alta_cita
				+ ", consultorio_alta_cita=" + consultorio_alta_cita + ", doctor_alta_cita=" + doctor_alta_cita + "]";
	}

}
