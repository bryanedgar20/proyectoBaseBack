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
public class Producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	private String nombreProducto;
	private String descripcion;
	private String marca;
	private int stock;
	private boolean estado;
	
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Precio> precios;
	
}
