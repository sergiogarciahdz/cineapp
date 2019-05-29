package com.serch.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

public class Utileria {

	/*
	 * Metodo que regresa una lista de String con las fechas siguientes, según el parametro count
	 */
	public static List<String> getNextDays(int count){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		//Today's date
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count); //Next N day from new
		Date endDate = cal.getTime();
		
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);
		List<String> nextDays = new ArrayList<String>();
		while (!gcal.getTime().after(endDate)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(sdf.format(d));
		}
		return nextDays;
	}
	
	//Guardar el archivo en un DD
	public static String guardarImagen(MultipartFile multiPart, HttpServletRequest request) {
		
		//Obtenemos el nombre original del archivo
		String nombreOriginal = multiPart.getOriginalFilename();
		
		//Reemplazar el nombre de las imagenes para que los espacios se reemplazen por guiones
		nombreOriginal = nombreOriginal.replace(" ", "-");
		
		//Evitar duplicaciones de nombres de las imagenes
		String nombreFinal = Utileria.randomAlphaNumeric(8)+nombreOriginal;
		
		//Obtenemos la ruta ABSOLUTA del directorio images
		//apache-tomcat/wenbapps/cineapp/resources/images/
		String rutaFinal = request.getServletContext().getRealPath("/resources/img/");
		
		try {
			//Formamos el nombre del archivo para guardarlo en el DD
			File imageFile = new File(rutaFinal+nombreFinal);
			
			//Mostrar la ruta de donde se guarda la imagen
			System.out.println(imageFile.getAbsolutePath());
		
			//Aquí se guarda fisicamente el archivo
			multiPart.transferTo(imageFile);
			
			return nombreFinal;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Gererar cadenas de longitud N de caracteres aleatorios
	public static String randomAlphaNumeric(int count) {
		String CARACTERES = "QWERTYUIOPLKJHGFDSAZXCVBNM0123456789";
		StringBuilder builder = new StringBuilder();
		while(count-- != 0) {
			int character = (int) (Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
		}
		return builder.toString();
	}
	
}
