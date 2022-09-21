package com.mx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.model.Consultorios;

public interface ConsultoriosRepository extends JpaRepository<Consultorios, Integer> {
	

}
