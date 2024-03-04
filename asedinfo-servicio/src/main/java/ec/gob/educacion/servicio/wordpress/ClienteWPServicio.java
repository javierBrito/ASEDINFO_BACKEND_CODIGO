package ec.gob.educacion.servicio.wordpress;

import java.util.List;

import ec.gob.educacion.modelo.DTO.UsuarioWPDTO;
import ec.gob.educacion.modelo.wordpress.ClienteWP;
import ec.gob.educacion.modelo.wordpress.PedidoProducto;

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
	List<ClienteWP> migrarClienteWP();

	/**
	 * Permite obtener lista ClienteWP
	 * 
	 * @param codPersona
	 * @return listaClienteWP
	 */
	List<ClienteWP> migrarClienteWPCategoria();

	List<UsuarioWPDTO> listarUsuarioWP();

	/**
	 * Permite obtener lista ClienteWP
	 * 
	 * @param codPersona
	 * @return listaClienteWP
	 */
	List<PedidoProducto> migrarClienteWPedidoProducto();

	/**
	 * Permite registrar ClienteWP
	 * 
	 * @param ClienteWP
	 * @return ClienteWP
	 */
	ClienteWP registrar(ClienteWP ClienteWP);

}
