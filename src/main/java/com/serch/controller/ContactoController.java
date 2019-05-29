package com.serch.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.serch.model.Contacto;
import com.serch.service.PeliculasService;
import com.serch.util.Views;

@Controller
@RequestMapping("/contacto")
public class ContactoController {
	
	@Autowired
	private PeliculasService peliculasService;
	
	@GetMapping("")
	public String index(@ModelAttribute Contacto contacto, Model model) {
		model.addAttribute("generos", peliculasService.searchGenero());
		model.addAttribute("tipoNotificacion", tipoNotificaciones());
		System.out.println( "ContactoController index() "+ peliculasService.searchGenero() + " AND "+tipoNotificaciones() );
		return Views.FORM_CONTACTO;
	}
	
	@PostMapping("")
	public String guardar(@ModelAttribute Contacto contacto) {
		System.out.println( "ContactoController guardar() "+contacto );
		return "redirect:/contacto";
	}
	
	private List<String> tipoNotificaciones(){
		List<String> tipos = new LinkedList<>();
		tipos.add("Estrenos");
		tipos.add("Promociones");
		tipos.add("Noticias");
		tipos.add("Preventas");
		return tipos;
	}

}
