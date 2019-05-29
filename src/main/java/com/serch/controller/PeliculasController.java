package com.serch.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.serch.model.Pelicula;
import com.serch.service.DetallesService;
import com.serch.service.PeliculasService;
import com.serch.util.Utileria;
import com.serch.util.Views;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
	
	@Autowired
	private PeliculasService peliculasService;
	
	@Autowired
	private DetallesService detallesService;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("peliculas", peliculasService.all());
		System.out.println( "PeliculasController index() "+peliculasService.all() );
		return Views.PELICULAS_LIST_PELICULA;
	}

	
	@GetMapping("/create")
	public String crear(@ModelAttribute Pelicula pelicula) {
		System.out.println( "PeliculasController crear() "+pelicula );
		return Views.PELICULAS_FORM_PELICULA;
	}
	
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes redirect,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {
		
		if (result.hasErrors()) {
			System.out.println("ERROR");
			return Views.PELICULAS_FORM_PELICULA;
		}
		
		/*
		for(ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage());
		}
		*/
		
		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			pelicula.setImagen(nombreImagen);
		}
		
		detallesService.insertar(pelicula.getDetalle());
		peliculasService.insert(pelicula);
		
		redirect.addFlashAttribute("msj", "Guardado exitosamente.");
		System.out.println( "PeliculasController guardar() "+pelicula );
		return "redirect:/peliculas";
	}
	
	
	@GetMapping("/edit")
	public String editar(@RequestParam("id") int id, Model model) {
		model.addAttribute("pelicula", peliculasService.findById(id));
		System.out.println( "PeliculasController editar() "+peliculasService.findById(id) );
		return Views.PELICULAS_FORM_PELICULA;
	}
	
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int id, RedirectAttributes redirect) {
		Pelicula pelicula = peliculasService.findById(id);
		peliculasService.delete(id);
		detallesService.delete(pelicula.getDetalle().getId());
		redirect.addFlashAttribute("msj", "Eliminado exitosamente.");
		System.out.println( "PeliculasController delete() "+pelicula );
		return "redirect:/peliculas";
	}
	
	
	@ModelAttribute("generos")
	public List<String> searchGenero(){
		return peliculasService.searchGenero();
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
}
