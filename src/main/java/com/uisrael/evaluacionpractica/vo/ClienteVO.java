package com.uisrael.evaluacionpractica.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteVO {

	private int idCliente;
	private String nombre;
	private String apellido;
	private String identificacion;
	private String direccion;
	private boolean estado;
}
