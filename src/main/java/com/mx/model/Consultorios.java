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
@Table(name = "consultorios")
public class Consultorios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_consultorio;
	
	private String numero_consultorio;
	
	private String Piso;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cita")
	private Citas citas;

	public Consultorios() {
		super();
	}

	public Integer getId_consultorio() {
		return id_consultorio;
	}

	public void setId_consultorio(Integer id_consultorio) {
		this.id_consultorio = id_consultorio;
	}

	public String getNumero_consultorio() {
		return numero_consultorio;
	}

	public void setNumero_consultorio(String numero_consultorio) {
		this.numero_consultorio = numero_consultorio;
	}

	public String getPiso() {
		return Piso;
	}

	public void setPiso(String piso) {
		Piso = piso;
	}

	public Citas getCitas() {
		return citas;
	}

	public void setCitas(Citas citas) {
		this.citas = citas;
	}

	@Override
	public String toString() {
		return "Consultorios [id_consultorio=" + id_consultorio + ", numero_consultorio=" + numero_consultorio
				+ ", Piso=" + Piso + ", citas=" + citas + "]";
	}

}
