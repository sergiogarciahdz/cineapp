package com.serch.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.serch.model.Banner;
import com.serch.model.Noticia;
import com.serch.model.Pelicula;
import com.serch.service.BannerService;
import com.serch.service.HorariosService;
import com.serch.service.NoticiasService;
import com.serch.service.PeliculasService;
import com.serch.util.Utileria;
import com.serch.util.Views;

@Controller
public class HomeController {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@Autowired
	private PeliculasService peliculasService;

	@Autowired
	private HorariosService horariosService;

	@Autowired
	private BannerService bannerService;

	@Autowired
	private NoticiasService noticiasService;

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		System.out.println("HomeController index() " + dateFormat.format(new Date()));
		return Views.HOME;
	}

	@PostMapping("/search")
	public String buscar(@RequestParam("fecha") String fecha, Model model) {
		model.addAttribute("fechaBusqueda", fecha);
		System.out.println("HomeController buscar() " + fecha);
		return Views.HOME;
	}
	
	@GetMapping("/formLogin")
	public String login() {
		return Views.FORM_LOGIN;
	}

	@ModelAttribute("fechas")
	public List<String> getNextDays() {
		return Utileria.getNextDays(4);
	}

	@ModelAttribute("peliculas")
	public List<Pelicula> allPeliculas() {
		return peliculasService.all();
	}

	@ModelAttribute("banners")
	public List<Banner> allBanners() {
		return bannerService.all();
	}

	@ModelAttribute("noticias")
	public List<Noticia> allNoticias() {
		return noticiasService.all();
	}

	// @RequestMapping(value="/detail/{_id}/{_fecha}", method=RequestMethod.GET)
	// public String mostrarDetalle(Model model, @PathVariable("_id") int
	// idPelicula, @PathVariable("_fecha") String fecha) {
	@GetMapping(value = "/detail")
	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula,
			@RequestParam("fecha") Date fecha) {
		model.addAttribute("horarios", horariosService.findByIdPelicula(idPelicula, fecha));
		model.addAttribute("fechaBusqueda", dateFormat.format(fecha));
		model.addAttribute("pelicula", peliculasService.findById(idPelicula));
		return Views.DETALLE;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
