package com.uisrael.evaluacionpractica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uisrael.evaluacionpractica.modelo.Cliente;
import com.uisrael.evaluacionpractica.modelo.Pedido;
import com.uisrael.evaluacionpractica.modelo.Ruta;
import com.uisrael.evaluacionpractica.servicio.IClienteService;
import com.uisrael.evaluacionpractica.servicio.IPedidoservice;
import com.uisrael.evaluacionpractica.servicio.IRutaService;

@SpringBootTest
class EvaluacionpracticaApplicationTests {

	@Autowired
	private IClienteService serviceCliente;

	@Autowired
	private IRutaService serviceRuta;

	@Autowired
	private IPedidoservice servicePedido;

	@Test
	void contextLoads() {

		// *************************************RUTA

		Ruta newRuta = new Ruta();
		newRuta.setPuntoSalida("Colon");
		newRuta.setEstado(true);
		serviceRuta.insertRuta(newRuta);

		// ************************************CLIENTE

		Cliente newCliente = new Cliente();

		newCliente.setNombre("Bryan");
		newCliente.setApellido("Freire");
		newCliente.setDireccion("La bota");
		newCliente.setIdentificacion("1003828835");
		newCliente.setEstado(true);

		newCliente.setRuta(newRuta);
		serviceCliente.insetCliente(newCliente);

		List<Cliente> listCli = serviceCliente.listCliente();

		if (!listCli.isEmpty()) {
			for (Cliente client : listCli) {
				System.out.println(client.getNombre());
			}
		}

		// CREAR PEDIDO

		Pedido newPedido = new Pedido();

		newPedido.setDescripcionPedido("Equipo móvil");
		newPedido.setFechaPedido(this.obtenerFecha("07/11/2023"));
		newPedido.setCliente(newCliente);
		newPedido.setEstado(true);

		servicePedido.insertPedido(newPedido);

		// Listar los pedidos realizado en un rango de fechas

		List<Pedido> listaPedidoPorFecha = this.servicePedido.listarPedidoPorFechas(this.obtenerFecha("05/11/2023"),
				this.obtenerFecha("06/11/2023"));

		if (!listaPedidoPorFecha.isEmpty()) {
			listaPedidoPorFecha.forEach(pedido -> {
				System.out.println("FechaPedido:" + pedido.getFechaPedido().toString());
			});
		}

		// Listar los clientes por sectores seleccionado

		Ruta rutaBota = new Ruta();
		rutaBota.setIdRuta(7);
		rutaBota.setEstado(Boolean.TRUE);

		List<Cliente> listarClientePorRuta = this.serviceCliente.listarClientePorRuta(rutaBota);

		if (!listarClientePorRuta.isEmpty()) {
			listarClientePorRuta.forEach(cliente -> {
				System.out.println("Cliente:" + cliente.getNombre() + cliente.getApellido());
			});
		}

	}

	private Date obtenerFecha(String fechaString) {

		Date fechaPedido = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			fechaPedido = formato.parse(fechaString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return fechaPedido;
	}

}
