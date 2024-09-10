package com.uisrael.evaluacionpractica.servicio;

import java.util.List;
import com.uisrael.evaluacionpractica.modelo.Cliente;
import com.uisrael.evaluacionpractica.modelo.Ruta;

public interface IClienteService {

	public void insetCliente(Cliente cliente);
	
	public List<Cliente> listCliente();

	public List<Cliente> listarClientePorRuta(Ruta ruta);
	
	public Cliente buscarClienteId(int idCliente);
	
	public List<Cliente> findByNombre(String nombre);

	public List<Cliente> findByEstado(boolean estado);
	
	public List<Cliente> findByIdCliente(int idCliente);
	
	public void eliminarCliente(int idCliente);
}
