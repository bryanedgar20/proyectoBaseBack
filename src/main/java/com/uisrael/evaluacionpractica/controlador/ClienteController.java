package com.uisrael.evaluacionpractica.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uisrael.evaluacionpractica.modelo.Cliente;
import com.uisrael.evaluacionpractica.modelo.Ruta;
import com.uisrael.evaluacionpractica.servicio.IClienteService;
import com.uisrael.evaluacionpractica.servicio.IRutaService;

@Controller
public class ClienteController {

	@Autowired
	private IClienteService serviceCliente;

	@Autowired
	private IRutaService serviceRuta;

	@GetMapping("/verClientes")
	public String abrirCliente(Model model) {
		model.addAttribute("listaCliente", serviceCliente.listCliente());
		model.addAttribute("listaRutas", serviceRuta.listarRuta());
		return "Cliente/ListarCliente";

	}
	
	@GetMapping("/filtrarPorRuta")
	public String filtrarPorId(@RequestParam("id") Integer id, Model model) {
        
		Ruta ruta = new Ruta();
        ruta.setIdRuta(id);
        if(id != 0) {
        	model.addAttribute("listaCliente", serviceCliente.listarClientePorRuta(ruta));
        }else {
        	model.addAttribute("listaCliente", serviceCliente.listCliente());
        }
        model.addAttribute("listaRutas", serviceRuta.listarRuta());
		return "Cliente/ListarCliente";
    }
	
	
	@GetMapping("/buscarPorRuta/{idRuta}")
    public String buscarPorRuta(@PathVariable Integer idRuta, Model model) {
        Ruta ruta = new Ruta();
        ruta.setIdRuta(idRuta);
		model.addAttribute("listaCliente", serviceCliente.listarClientePorRuta(null));
        return "vistaResultados"; // Ajusta según tu aplicación
    }
	

	@GetMapping("/nuevoCliente")
	public String nuevoCliente(Model model) {
		Cliente nuevoCliente = new Cliente();
		model.addAttribute("nuevoCliente", nuevoCliente);
		model.addAttribute("listaRutas", serviceRuta.listarRuta());
		return "Cliente/NuevoCliente";

	}

	@PostMapping("/guardarCliente")
	public String actualizarCliente(@ModelAttribute("nuevoCliente") Cliente nuevoHtml) {

		nuevoHtml.setEstado(true);
		serviceCliente.insetCliente(nuevoHtml);
		return "redirect:/verClientes";

	}

	@GetMapping("/editarCliente/{idcliente}")
	public String editarCliente(@PathVariable("idcliente") int idCliente, Model model) {
		model.addAttribute("listaRutas", serviceRuta.listarRuta());
		model.addAttribute("nuevoCliente", serviceCliente.buscarClienteId(idCliente)); // 
		return "Cliente/NuevoCliente";
	}

	@GetMapping("/eliminarCliente/{idcliente}")
	public String eliminarCliente(@PathVariable("idcliente") int idCliente, Model model) {
		serviceCliente.eliminarCliente(idCliente);
		return "redirect:/verClientes";
	}

}
