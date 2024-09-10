package com.uisrael.evaluacionpractica.controlador;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GetMapping("/index")
	public String verIndex() {
		return "index";//nombre fisico de la pagina
	}


}
