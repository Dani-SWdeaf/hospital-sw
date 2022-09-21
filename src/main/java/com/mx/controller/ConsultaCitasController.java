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

import com.mx.model.ConsultaCitas;
import com.mx.repository.ConsultaCitasRepository;

@Controller
@RequestMapping("/consulta")
public class ConsultaCitasController {
	private final Logger logger = LoggerFactory.getLogger(ConsultaCitas.class);
	
	@Autowired
	private ConsultaCitasRepository consultoriosRepository;
	
	@GetMapping("")
	public String consultaCitas(Model model) {
		model.addAttribute("consulta", consultoriosRepository.findAll());
		return "Altacita2";
	}
	
	@GetMapping("/create")
	public String create()
	{
		return "createConsultaCitas";
	}
	
	@PostMapping("/guardar")
	public String guardar(ConsultaCitas citas, RedirectAttributes redirect)
	{
		redirect.addFlashAttribute("msgExito1", "Gracias por registrarte!");
		consultoriosRepository.save(citas);
		return "redirect:/consulta";
	}
	
	@PostMapping("/actuzilar")
	public String actuzliar(ConsultaCitas consultorio, RedirectAttributes redirect)
	{
		redirect.addFlashAttribute("msgActualizar1", "Ya has actualizado!");
		consultoriosRepository.save(consultorio);
		return "redirect:/consulta";
	}
	
	@GetMapping("/editar/{id_consultaCita}")
	public String editar(@PathVariable Integer id_consultaCita, Model model, RedirectAttributes redirect)
	{
		ConsultaCitas cita = consultoriosRepository.getOne(id_consultaCita);
		model.addAttribute("consulta", cita);
		
		return "editarconsultaCitas";
	}
	
	@GetMapping("/eliminar/{id_consultaCita}")
	public String eliminar(@PathVariable Integer id_consultaCita, RedirectAttributes redirect)
	{
		ConsultaCitas cita = consultoriosRepository.getOne(id_consultaCita);
		redirect.addFlashAttribute("msgDelete1", "Ya eliminsate :(");
		consultoriosRepository.delete(cita);
		
		return "redirect:/consulta";
	}
}
