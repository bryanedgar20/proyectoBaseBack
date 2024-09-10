package com.uisrael.evaluacionpractica.vo;

import java.util.Date;

import com.uisrael.evaluacionpractica.modelo.Pedido;

import lombok.Data;

@Data
public class PedidoVO {

	private int idPedido;
	private String descripcionPedido;
	private Date fechaPedido;
	private boolean estado;
	
	private ClienteVO clienteVO;
	

    // Constructor de mapeo
    public PedidoVO(Pedido pedido) {
        this.descripcionPedido = pedido.getDescripcionPedido();
        this.clienteVO = ClienteVO.builder()
                                  .apellido(pedido.getCliente().getApellido())
                                  .build();
    }
}
