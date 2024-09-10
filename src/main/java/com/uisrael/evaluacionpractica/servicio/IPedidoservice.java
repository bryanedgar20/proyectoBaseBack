package com.uisrael.evaluacionpractica.servicio;

import java.util.Date;
import java.util.List;

import com.uisrael.evaluacionpractica.modelo.Cliente;
import com.uisrael.evaluacionpractica.modelo.Pedido;
import com.uisrael.evaluacionpractica.vo.PedidoVO;

public interface IPedidoservice {

	public void insertPedido(Pedido pedido);
	
	public List<Pedido> listarPedido();
	
	public List<Pedido> listarPedidoPorFechas(Date fechaInicio, Date fechaFin);
	
	public Pedido buscarPedidoId(int idPedido);

	public List<Pedido> findByEstado(boolean estado);
	
	public void eliminarPedido(int idPedido);
	
	public List<PedidoVO> listarPedidoVO();
}
