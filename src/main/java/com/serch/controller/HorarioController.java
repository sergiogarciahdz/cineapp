package com.serch.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.serch.model.Horario;
import com.serch.model.Pelicula;
import com.serch.service.HorariosService;
import com.serch.service.PeliculasService;
import com.serch.util.Views;

@Controller
@RequestMapping("/horario")
public class HorarioController {

	@Autowired
	private PeliculasService peliculasService;
	
	@Autowired
	private HorariosService horariosService;
	
	@GetMapping("")
	public String index(@ModelAttribute Horario horario) {
		System.out.println( "HorarioController index() "+horario );
		return Views.HORARIOS_LIST_PELICULA;
	}
	
	@GetMapping("/horary")
	public String horarios(@RequestParam("id") int id, Model model) {
		model.addAttribute("horarios", horariosService.findAllByIdPelicula(id));
		System.out.println( "HorarioController horarios() "+horariosService.findAllByIdPelicula(id) );
		return Views.HORARIOS_LIST_HORARIO;
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Horario horario) {
		System.out.println( "HorarioController crear() "+horario );
		return Views.HORARIOS_FORM_HORARIO;
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Horario horario, BindingResult result, RedirectAttributes redirect) {
		
		if (result.hasErrors()) {
			System.out.println("ERROR");
			return Views.HORARIOS_FORM_HORARIO;
		}
		
		horariosService.save(horario);
		redirect.addFlashAttribute("msj", "Guardado exitosamente.");
		System.out.println( "HorarioController guardar() "+horario );
		return "redirect:/horario";
	}
	
	@GetMapping("/edit")
	public String editar(@RequestParam("id") int id, Model model) {
		model.addAttribute("horario", horariosService.findById(id));
		System.out.println( "HorarioController editar() "+ horariosService.findById(id));
		return Views.HORARIOS_FORM_HORARIO;
	}
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int id, RedirectAttributes redirect) {
		horariosService.delete(id);
		redirect.addFlashAttribute("msj", "Guardado exitosamente.");
		System.out.println( "HorarioController eliminar() "+id );
		return "redirect:/horario";
	}
	
	@ModelAttribute("peliculas")
	public List<Pelicula> allPeliculas(){
		return peliculasService.all();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
}
