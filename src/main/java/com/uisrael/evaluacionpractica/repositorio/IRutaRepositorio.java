package com.uisrael.evaluacionpractica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.evaluacionpractica.modelo.Ruta;

public interface IRutaRepositorio extends JpaRepository<Ruta, Integer>{

	public List<Ruta> findByIdRuta(int idRuta);
	
}
