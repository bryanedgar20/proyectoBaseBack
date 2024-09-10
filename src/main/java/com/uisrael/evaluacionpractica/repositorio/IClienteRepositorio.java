package com.uisrael.evaluacionpractica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.evaluacionpractica.modelo.Cliente;
import com.uisrael.evaluacionpractica.modelo.Ruta;

public interface IClienteRepositorio extends JpaRepository<Cliente, Integer> {

	public List<Cliente> findByRuta(Ruta ruta);

	public List<Cliente> findByApellido(String apellido);

	public List<Cliente> findByNombre(String nombre);

	public List<Cliente> findByEstado(boolean estado);

	public List<Cliente> findByIdCliente(int idCliente);
}
