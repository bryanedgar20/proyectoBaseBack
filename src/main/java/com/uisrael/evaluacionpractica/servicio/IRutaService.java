package com.uisrael.evaluacionpractica.servicio;

import java.util.List;

import com.uisrael.evaluacionpractica.modelo.Ruta;

public interface IRutaService {

	public void insertRuta(Ruta ruta);
	
	public List<Ruta> listarRuta();
	
	public void eliminarRuta(int idRuta);
	public List<Ruta> findByIdRuta(int idRuta);
	public Ruta buscarRutaId(int idRuta);
	
}
