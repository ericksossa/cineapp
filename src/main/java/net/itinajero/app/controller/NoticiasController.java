package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import net.itinajero.app.model.Noticia;
import net.itinajero.app.service.INoticiasService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {
	
	@Autowired
	private INoticiasService serviceNoticia;
	
	@GetMapping(value = "/create")
	public String crear() {
		return "noticias/frmNoticia";
	}
	
	@PostMapping(value = "/save")
	public String guardar(Noticia noticia) {
		
		serviceNoticia.guardar(noticia);
		
		
		return "noticias/frmNoticia";
	}
}
