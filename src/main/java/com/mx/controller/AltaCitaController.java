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

import com.mx.model.AltaCita;
import com.mx.model.Consultorios;
import com.mx.repository.AltaCitaRepository;

@Controller
@RequestMapping("/altaCita")
public class AltaCitaController {
	
	private final Logger logg = LoggerFactory.getLogger(Consultorios.class);
	
	@Autowired
	private AltaCitaRepository altaCitaRepository;
	
	@GetMapping("")
	public String alta(Model model)
	{
		model.addAttribute("altaCita", altaCitaRepository.findAll());
		return "Altacita";
	}
	
	@GetMapping("/create")
	public String create()
	{
		return "createAltaCita";
	}
	
	@PostMapping("/guardar")
	public String guardar(AltaCita cita, RedirectAttributes redirect)
	{
		redirect.addFlashAttribute("msgExito", "Gracias por registrarte!");
		altaCitaRepository.save(cita);
		return "redirect:/altaCita";
	}
	
	@PostMapping("/actuzilar")
	public String actuzliar(AltaCita consultorio, RedirectAttributes redirect)
	{
		redirect.addFlashAttribute("msgActualizar", "Ya has actualizado!");
		altaCitaRepository.save(consultorio);
		return "redirect:/altaCita";
	}
	
	@GetMapping("/editar/{id_alta}")
	public String editar(@PathVariable Integer id_alta, Model model, RedirectAttributes redirect)
	{
		AltaCita cita = altaCitaRepository.getOne(id_alta);
		model.addAttribute("altaCita", cita);
		
		return "editarAltaCita";
	}
	
	@GetMapping("/eliminar/{id_alta}")
	public String eliminar(@PathVariable Integer id_alta, RedirectAttributes redirect)
	{
		AltaCita cita = altaCitaRepository.getOne(id_alta);
		redirect.addFlashAttribute("msgDelete", "Ya eliminsate :(");
		altaCitaRepository.delete(cita);
		
		return "redirect:/altaCita";
	}
}
