package com.mx.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mx.model.Citas;
import com.mx.model.Consultorios;
import com.mx.repository.ConsultoriosRepository;
import com.mx.servicio.CitasService;
import com.mx.servicio.ConsultoriosService;

@Controller
@RequestMapping("/consultorios")
@Service
public class ConsultoriosController {
	
	private final Logger logg = LoggerFactory.getLogger(Consultorios.class);
	
	@Autowired
	private ConsultoriosRepository consultoriosRepository; 
	
	@GetMapping("")
	public String consultorios(Model model)
	{
		model.addAttribute("consultorios", consultoriosRepository.findAll());
		return "consultorios";
	}
	
	@Autowired
	private CitasService citasService;
	
	@Autowired
	private ConsultoriosService consultoriosService;
	
	@RequestMapping("")
	@ResponseBody
	public List<Citas> listaCita(){
		return citasService.ListaCitas();
	}
	
	@GetMapping("/create")
	public String create(String numero_consultorio, HttpSession session)
	{
		List<Consultorios> lista = consultoriosService.listarPorNumero_consultorio(numero_consultorio + "%");
		session.setAttribute("consultorios", lista);
		return "createConsultorio";
	}
	
	@PostMapping("/guardar")
	public String guardar(Consultorios consultorio, RedirectAttributes redirect)
	{
		redirect.addFlashAttribute("msgExito", "Gracias por registrarte!");
		consultoriosRepository.save(consultorio);
		return "redirect:/consultorios";
	}
	
	@PostMapping("/actuzilar")
	public String actuzliar(Consultorios consultorio, RedirectAttributes redirect)
	{
		redirect.addFlashAttribute("msgActualizar", "Ya has actualizado!");
		consultoriosRepository.save(consultorio);
		return "redirect:/consultorios";
	}
	
	@GetMapping("/editar/{id_consultorio}")
	public String editar(@PathVariable Integer id_consultorio, Model model, RedirectAttributes redirect)
	{
		Consultorios consultorio = consultoriosRepository.getOne(id_consultorio);
		model.addAttribute("consultorios", consultorio);
		
		return "editarConsultorios";
	}
	
	@GetMapping("/eliminar/{id_consultorio}")
	public String eliminar(@PathVariable Integer id_consultorio, RedirectAttributes redirect)
	{
		Consultorios consultorios = consultoriosRepository.getOne(id_consultorio);
		redirect.addFlashAttribute("msgDelete", "Ya eliminsate :(");
		consultoriosRepository.delete(consultorios);
		
		return "redirect:/consultorios";
	}
} 
