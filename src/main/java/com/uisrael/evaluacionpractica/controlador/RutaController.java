package com.uisrael.evaluacionpractica.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.evaluacionpractica.modelo.Ruta;
import com.uisrael.evaluacionpractica.servicio.IRutaService;

@Controller
public class RutaController {

	@Autowired
	private IRutaService serviceRuta;

	@GetMapping("/verRutas")
	public String abrirRutas(Model model) {
		model.addAttribute("listaRuta", serviceRuta.listarRuta());
		return "Ruta/ListarRuta";

	}

	@GetMapping("/nuevaRuta")
	public String nuevaRuta(Model model) {
		Ruta nuevaRuta = new Ruta();
		model.addAttribute("nuevaRuta", nuevaRuta);
		return "Ruta/NuevaRuta";

	}

	@PostMapping("/guardarRuta")
	public String actualizarRuta(@ModelAttribute("nuevaRuta") Ruta nuevoHtml) {
		nuevoHtml.setEstado(true);
		serviceRuta.insertRuta(nuevoHtml);
		return "redirect:/verRutas";

	}

	@GetMapping("/editarRuta/{idruta}")
	public String editarCliente(@PathVariable("idruta") int idRuta, Model model) {
		model.addAttribute("nuevaRuta", serviceRuta.buscarRutaId(idRuta)); // 
		return "Ruta/NuevaRuta";
	}

	@GetMapping("/eliminarRuta/{idruta}")
	public String eliminarRuta(@PathVariable("idruta") int idRuta, Model model) {
		serviceRuta.eliminarRuta(idRuta);
		return "redirect:/verRutas";
	}

	
}
