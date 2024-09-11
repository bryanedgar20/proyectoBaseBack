package com.uisrael.evaluacionpractica.servicio.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.evaluacionpractica.modelo.Pedido;
import com.uisrael.evaluacionpractica.repositorio.IPedidoRepositorio;
import com.uisrael.evaluacionpractica.servicio.IPedidoservice;
import com.uisrael.evaluacionpractica.vo.ClienteVO;
import com.uisrael.evaluacionpractica.vo.PedidoVO;

@Service
@Component
public class PedidoServiceImpl implements IPedidoservice{

	@Autowired
	IPedidoRepositorio pedidoRepositorio;
	
	@Override
	public void insertPedido(Pedido pedido) {

		pedidoRepositorio.save(pedido);
		
	}

	@Override
	public List<Pedido> listarPedido() {
		// TODO Auto-generated method stub
		return pedidoRepositorio.findAll();
	}

	@Override
	public List<Pedido> listarPedidoPorFechas(Date fechaInicio, Date fechaFin) {
		// TODO Auto-generated method stub
		return this.pedidoRepositorio.findByDateMinMax(fechaInicio, fechaFin);
	}

	@Override
	public Pedido buscarPedidoId(int idPedido) {
		// TODO Auto-generated method stub
		return pedidoRepositorio.findById(idPedido).get();
	}

	@Override
	public List<Pedido> findByEstado(boolean estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPedido(int idPedido) {
		// TODO Auto-generated method stub
		pedidoRepositorio.deleteById(idPedido);
	}

	@Override
	public List<PedidoVO> listarPedidoVO() {
		return pedidoRepositorio.findAll().stream()
		        .map(PedidoVO::new)  // Usa el constructor para mapear
		        .collect(Collectors.toList());
	}

	@Override
	public List<Pedido> listarPedidoPorClienteNombreFechas(Long idCliente, String descripcionPedido) {
		// TODO Auto-generated method stub
		return this.pedidoRepositorio.buscarPedidos(idCliente, descripcionPedido);
	}

}
