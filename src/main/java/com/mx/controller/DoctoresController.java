package com.mx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mx.model.Doctores;
import com.mx.repository.DoctoresRepository;

@Controller
@RequestMapping("/")
public class DoctoresController {
	
	private final Logger logg = LoggerFactory.getLogger(Doctores.class);
	
	@Autowired
	private DoctoresRepository doctoresRepository;
	
	@GetMapping("")
	public String home(Model model)
	{
		model.addAttribute("doctores", doctoresRepository.findAll());
		return "home";
	}
	
	
	@GetMapping("/create")
	public String create()
	{
		return "createDoctores";
	}
	
	@PostMapping("/guardar")
	public String guardar(Doctores doctores, RedirectAttributes redirect)
	{
		doctoresRepository.save(doctores);
		redirect.addFlashAttribute("msgExito", "El contacto ha sido agregado con exito!");
		return "redirect:/doctores";
	}
	
	//Doctor
	@GetMapping("/doctores")
	public String doctor(Model model)
	{
		model.addAttribute("doctores", doctoresRepository.findAll());
		return "doctores";
	}
	
	@GetMapping("/editar/{id_doctor}")
	public String editar(@PathVariable Integer id_doctor, Model model)
	{
		Doctores doctor = doctoresRepository.getOne(id_doctor);
		logg.info("Corregir recuperado {}", doctor);
		model.addAttribute("doctores", doctor);
		
		return "editarDoctores";
	}
	
	@GetMapping("/eliminar/{id_doctor}")
	public String eliminar(@PathVariable Integer id_doctor, RedirectAttributes redirect)
	{
		Doctores doctor = doctoresRepository.getOne(id_doctor);
		redirect.addFlashAttribute("msgExito", "Ya eliminsate :(");
		doctoresRepository.delete(doctor);
		
		return "redirect:/doctores";
	}
}
