package ec.gob.educacion.servicio.wordpress;

import java.util.List;
import ec.gob.educacion.modelo.wordpress.ClienteWP;

public interface ClienteWPServicio {
	/**
	 * Permite listar ClienteWP
	 * 
	 * @param null
	 * @return lista ClienteWP
	 */
	List<ClienteWP> listarTodosClienteWP();

	/**
	 * Permite obtener ClienteWP
	 * 
	 * @param codigo
	 * @return ClienteWP
	 */
	ClienteWP buscarClienteWPPorCustomerId(Long customerId);

	/**
	 * Permite obtener lista ClienteWP
	 * 
	 * @param codPersona
	 * @return listaClienteWP
	 */
	List<ClienteWP> listarClienteWPPorEstado(String estadoPedido);

	/**
	 * Permite registrar ClienteWP
	 * 
	 * @param ClienteWP
	 * @return ClienteWP
	 */
	ClienteWP registrar(ClienteWP ClienteWP);

}
