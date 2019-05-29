package com.serch.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.serch.model.Banner;
import com.serch.service.BannerService;
import com.serch.util.Utileria;
import com.serch.util.Views;

@Controller
@RequestMapping("/banner")
public class BannerController {
	
	@Autowired
	private BannerService bannerService;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("banners", bannerService.all());
		System.out.println( "BannerController index() "+ bannerService.all());
		return Views.BANNERS_LIST_BANNER;
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Banner banner) {
		System.out.println( "BannerController crear() "+banner );
		return Views.BANNERS_FORM_BANNER;
	}
	
	@PostMapping("/save")
	public String guardar(
			@ModelAttribute Banner banner,
			BindingResult result, 
			RedirectAttributes redirect,
			@RequestParam("archivoImagen") MultipartFile multiPart,
			HttpServletRequest request) {
		
		if (result.hasErrors()) {
			System.out.println("ERROR");
			return Views.BANNERS_FORM_BANNER;
		}
		
		/*
		for(ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage());
		}
		*/
		
		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			banner.setArchivo(nombreImagen);
		}
		
		bannerService.insert(banner);
		redirect.addFlashAttribute("msj", "Guardado exitosamente.");
		System.out.println( "BannerController guardar() "+banner );
		return "redirect:/banner";
		
	}
	
	@GetMapping("/edit")
	public String editar(@RequestParam("id") int id, Model model) {
		model.addAttribute("banner", bannerService.findById(id));
		System.out.println( "BannerController editar() "+ bannerService.findById(id));
		return Views.BANNERS_FORM_BANNER;
	}
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int id, RedirectAttributes redirect) {
		bannerService.delete(id);
		redirect.addFlashAttribute("msj", "Eliminado exitosamente.");
		System.out.println( "BannerController eliminar() "+id );
		return "redirect:/banner";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
