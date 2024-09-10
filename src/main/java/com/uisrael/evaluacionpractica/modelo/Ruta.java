package com.uisrael.evaluacionpractica.modelo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Ruta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRuta;
	private String puntoSalida;
	private boolean estado;
	
	
	 @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
	 private List<Cliente> clientes;
	
}
