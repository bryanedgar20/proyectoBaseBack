package com.uisrael.evaluacionpractica.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.evaluacionpractica.modelo.Cliente;
import com.uisrael.evaluacionpractica.modelo.Pedido;

public interface IPedidoRepositorio extends JpaRepository<Pedido, Integer>{

	@Query("SELECT ped FROM Pedido ped WHERE ped.fechaPedido BETWEEN ?1 AND ?2")
	public List<Pedido> findByDateMinMax(Date fechaInicio, Date fechaFin);
	

	public List<Cliente> findByEstado(boolean estado);

	public List<Cliente> findByIdPedido(int idPedido);
	
	
	// Consulta para filtrar por fechas
	@Query("SELECT ped FROM Pedido ped WHERE (:clienteId IS NULL OR ped.cliente.idCliente = :clienteId) " +
		       "AND (:descripcion IS NULL OR ped.descripcionPedido LIKE %:descripcion%)")
    List<Pedido> buscarPedidos(@Param("clienteId") Long clienteId, @Param("descripcion") String descripcion);
}
