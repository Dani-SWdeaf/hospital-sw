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

import com.mx.model.Citas;
import com.mx.model.Consultorios;
import com.mx.model.Doctores;
import com.mx.repository.CitasRepository;

@Controller
@RequestMapping("/citas")
public class CitasController {
	private final Logger logger = LoggerFactory.getLogger(Citas.class);
	
	@Autowired
	private CitasRepository citasRepository;
	
	@GetMapping("")
	public String citas(Model model)
	{
		model.addAttribute("citas", citasRepository.findAll());
		return "citas";
	}
	
	@GetMapping("/create")
	public String create()
	{
		return "createCitas";
	}
	
	@PostMapping("/guardar")
	public String guardar(Citas citas, RedirectAttributes redirect)
	{
		redirect.addFlashAttribute("msgExito", "Gracias por registrarte!");
		citasRepository.save(citas);
		return "redirect:/citas";
	}
	
	@PostMapping("/actuzilar")
	public String actuzliar(Citas consultorio, RedirectAttributes redirect)
	{
		redirect.addFlashAttribute("msgActualizar", "Ya has actualizado!");
		citasRepository.save(consultorio);
		return "redirect:/citas";
	}
	
	@GetMapping("/editar/{id_cita}")
	public String editar(@PathVariable Integer id_cita, Model model, RedirectAttributes redirect)
	{
		Citas citas = citasRepository.getOne(id_cita);
		redirect.addFlashAttribute("msgActualizar", "Ya has actualizado!");
		model.addAttribute("citas", citas);
		
		return "editarCitas";
	}
	
	@GetMapping("/eliminar/{id_cita}")
	public String eliminar(@PathVariable Integer id_cita, RedirectAttributes redirect)
	{
		Citas citas = citasRepository.getOne(id_cita);
		redirect.addFlashAttribute("msgExito", "Ya eliminsate :(");
		citasRepository.delete(citas);
		
		return "redirect:/citas";
	}
	
}
