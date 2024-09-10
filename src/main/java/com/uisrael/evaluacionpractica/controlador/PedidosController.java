package com.uisrael.evaluacionpractica.controlador;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.uisrael.evaluacionpractica.modelo.Pedido;
import com.uisrael.evaluacionpractica.servicio.IClienteService;
import com.uisrael.evaluacionpractica.servicio.IPedidoservice;
import com.uisrael.evaluacionpractica.vo.PedidoVO;


@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class PedidosController {
	@Autowired
	private IClienteService serviceCliente;

	@Autowired
	private IPedidoservice servicePedido;
	
	
	@PostMapping("/buscarPorFecha")
    public String mostrarFormulario( @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin, Model model) {
        Date fechaInicioDate = Date.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaFinDate = Date.from(fechaFin.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        model.addAttribute("listaPedidos", servicePedido.listarPedidoPorFechas(fechaInicioDate, fechaFinDate));
        
        return "Pedido/ListarPedido";
    } 

	
	
	@GetMapping("/verPedidos")
	public String abrirPedido(Model model) {
		model.addAttribute("listaPedidos", servicePedido.listarPedido());
		return "Pedido/ListarPedido";

	}
	
	@GetMapping("/listarPedidos")
	public ResponseEntity<List<Pedido>> listarPedidos() {
		System.out.print("INGRESA A METODO");
		//return ResponseEntity.ok(Collections.EMPTY_LIST);
		return ResponseEntity.ok(this.servicePedido.listarPedido());
	}
	
	
	@GetMapping("/listPedidos")
	public ResponseEntity<List<PedidoVO>> listPedidos() {
		System.out.print("INGRESA A METODO");
		//return ResponseEntity.ok(Collections.EMPTY_LIST);
		return ResponseEntity.ok(this.servicePedido.listarPedidoVO());
	}
	
	
	@GetMapping("/nuevoPedido")
	public String nuevoPedido(Model model) {
		model.addAttribute("nuevoPedido", new Pedido());
		model.addAttribute("listaClientes", serviceCliente.listCliente());
		return "Pedido/NuevoPedido";

	}
	
	

	@PostMapping("/guardarPedido")
	public String actualizarPedido(@ModelAttribute("nuevoPedido") Pedido nuevoHtml) {

		nuevoHtml.setEstado(true);
		System.out.print("fecha"+nuevoHtml.getFechaPedido());
		servicePedido.insertPedido(nuevoHtml);
		return "redirect:/verPedidos";

	}
	
	@PostMapping("/savePedido")
	public ResponseEntity<List<Pedido>> savePedido(@RequestBody Pedido pedido) {

		pedido.setEstado(true);
		servicePedido.insertPedido(pedido);
		return ResponseEntity.ok(this.servicePedido.listarPedido());

	}

	@GetMapping("/editarPedido/{idpedido}")
	public String editarPedido(@PathVariable("idpedido") int idPedido, Model model) {
		model.addAttribute("nuevoPedido", servicePedido.buscarPedidoId(idPedido)); // 
		model.addAttribute("listaClientes", serviceCliente.listCliente());
		return "Pedido/NuevoPedido";
	}

	@GetMapping("/eliminarPedido/{idpedido}")
	public String eliminarPedido(@PathVariable("idpedido") int idPedido, Model model) {
		servicePedido.eliminarPedido(idPedido);
		return "redirect:/verPedidos";
	}
}
