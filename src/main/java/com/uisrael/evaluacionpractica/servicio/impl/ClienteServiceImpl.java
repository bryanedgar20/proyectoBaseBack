package com.uisrael.evaluacionpractica.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.evaluacionpractica.modelo.Cliente;
import com.uisrael.evaluacionpractica.modelo.Ruta;
import com.uisrael.evaluacionpractica.repositorio.IClienteRepositorio;
import com.uisrael.evaluacionpractica.servicio.IClienteService;

@Service
@Component
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepositorio clienteRepositorio;
	
	@Override
	public void insetCliente(Cliente newCliente) {

		clienteRepositorio.save(newCliente);
		
	}

	@Override
	public List<Cliente> listCliente() {
		// TODO Auto-generated method stub
		return clienteRepositorio.findAll();
	}

	@Override
	public List<Cliente> listarClientePorRuta(Ruta ruta) {
		// TODO Auto-generated method stub
		return this.clienteRepositorio.findByRuta(ruta);
	}

	@Override
	public Cliente buscarClienteId(int idCliente) {
		// TODO Auto-generated method stub
		return clienteRepositorio.findById(idCliente).get();
	}

	@Override
	public List<Cliente> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return clienteRepositorio.findByNombre(nombre);
	}

	@Override
	public List<Cliente> findByEstado(boolean estado) {
		// TODO Auto-generated method stub
		return clienteRepositorio.findByEstado(estado);
	}

	@Override
	public List<Cliente> findByIdCliente(int idCliente) {
		// TODO Auto-generated method stub
		return clienteRepositorio.findByIdCliente(idCliente);
	}

	@Override
	public void eliminarCliente(int idCliente) {
		// TODO Auto-generated method stub
		clienteRepositorio.deleteById(idCliente);
	}

}
