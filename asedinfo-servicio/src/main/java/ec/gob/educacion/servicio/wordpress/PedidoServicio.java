package ec.gob.educacion.servicio.wordpress;

import java.util.List;

import ec.gob.educacion.modelo.wordpress.Pedido;

public interface PedidoServicio {
	/**
	 * Permite listar Pedido
	 * 
	 * @param null
	 * @return lista Pedido
	 */
	List<Pedido> listarTodosPedido();

	/**
	 * Permite listar Pedido Activo
	 * 
	 * @param estado
	 * @return lista Pedido
	 */
	List<Pedido> listarPedidoActivo(String estado);

	/**
	 * Permite obtener Pedido
	 * 
	 * @param codigo
	 * @return Pedido
	 */
	Pedido buscarPedidoPorOrderId(Long orderId);

	/**
	 * Permite obtener lista Pedido
	 * 
	 * @param codPersona
	 * @return listaPedido
	 */
	List<Pedido> listarPedidoPorCliente(Long customerId);

	/**
	 * Permite registrar Pedido
	 * 
	 * @param Pedido
	 * @return Pedido
	 */
	Pedido registrar(Pedido pedido);

}
