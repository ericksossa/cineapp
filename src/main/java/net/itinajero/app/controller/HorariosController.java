package net.itinajero.app.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
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

import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IPeliculasService;

@Controller
@RequestMapping(value = "/horarios")
public class HorariosController {
	
	@Autowired
	IPeliculasService servicePeliculas;
	
	@GetMapping(value= "/create")
	public String crear(@ModelAttribute Horario horario, Model model) {
		List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
		model.addAttribute("peliculas", listaPeliculas);
		return "horarios/frmHorario";
	}
	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Horario horario, BindingResult result) {
		
		if (result.hasErrors()) {
			return "horarios/frmHorario";
		}
		System.out.println(horario);
		return "redirect:/horarios/create";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		// nuevo formato de la fecha, not null
		binder.registerCustomEditor(Date.class, "fecha", new CustomDateEditor(dateFormat, false));
	}

}
