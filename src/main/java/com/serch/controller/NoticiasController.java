package com.serch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.serch.model.Noticia;
import com.serch.service.NoticiasService;
import com.serch.util.Views;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {
	
	@Autowired
	private NoticiasService noticiasService;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("noticias", noticiasService.all());
		System.out.println( "NoticiasController index() "+ noticiasService.all());
		return Views.NOTICIAS_LIST_NOTICIA;
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Noticia noticia) {
		System.out.println( "NoticiasController crear() "+noticia );
		return Views.NOTICIAS_FORM_NOTICIA;
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Noticia noticia, RedirectAttributes redirect) {
		noticiasService.save(noticia);
		redirect.addFlashAttribute("msj", "Guardado exitosamente.");
		System.out.println( "NoticiasController guardar() "+noticia );
		return "redirect:/noticias";
	}
	
	@GetMapping("/edit")
	public String editar(@RequestParam("id") int id, Model model) {
		model.addAttribute("noticia", noticiasService.findById(id));
		System.out.println( "NoticiasController editar() "+noticiasService.findById(id) );
		return Views.NOTICIAS_FORM_NOTICIA;
	}
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int id, RedirectAttributes redirect) {
		noticiasService.delete(id);
		redirect.addFlashAttribute("msj", "Eliminado exitosamente.");
		System.out.println( "NoticiasController eliminar() "+id );
		return "redirect:/noticias";
	}

}
