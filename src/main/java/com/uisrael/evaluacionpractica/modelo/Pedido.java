package com.uisrael.evaluacionpractica.modelo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	private String descripcionPedido;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaPedido;
	private boolean estado;
	
	
	 @ManyToOne
	 @JoinColumn(name = "cliente_id")
	 @JsonIgnore
	 private Cliente cliente;
	
}
