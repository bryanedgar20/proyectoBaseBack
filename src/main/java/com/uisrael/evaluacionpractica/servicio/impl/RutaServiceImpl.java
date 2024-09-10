package com.uisrael.evaluacionpractica.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.evaluacionpractica.modelo.Ruta;
import com.uisrael.evaluacionpractica.repositorio.IRutaRepositorio;
import com.uisrael.evaluacionpractica.servicio.IRutaService;

@Service
@Component
public class RutaServiceImpl implements IRutaService{

	@Autowired
	IRutaRepositorio rutaRepositorio;
	
		@Override
	public void insertRuta(Ruta ruta) {
		// TODO Auto-generated method stub
		rutaRepositorio.save(ruta);
			
	}

	@Override
	public List<Ruta> listarRuta() {
		// TODO Auto-generated method stub
		return rutaRepositorio.findAll();
	}

	@Override
	public void eliminarRuta(int idRuta) {
		// TODO Auto-generated method stub
		rutaRepositorio.deleteById(idRuta);
	}

	@Override
	public Ruta buscarRutaId(int idRuta) {
		// TODO Auto-generated method stub
		return rutaRepositorio.findById(idRuta).get();
	}

	@Override
	public List<Ruta> findByIdRuta(int idRuta) {
		// TODO Auto-generated method stub
		return rutaRepositorio.findByIdRuta(idRuta);
	}

}
