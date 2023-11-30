package ec.gob.educacion.controlador.wordpress;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.gob.educacion.controlador.util.Constantes;
import ec.gob.educacion.modelo.response.ResponseGenerico;
import ec.gob.educacion.modelo.wordpress.Pedido;
import ec.gob.educacion.servicio.wordpress.PedidoServicio;

@RestController
@RequestMapping("wordpress/")
public class PedidoControlador {

	@Autowired
	private PedidoServicio PedidoServicio;

	@GetMapping(value = "listarTodosPedido")
	public ResponseGenerico<Pedido> listarTodosPedido() {
		List<Pedido> listaPedido = PedidoServicio.listarTodosPedido();
		// Respuesta
		ResponseGenerico<Pedido> response = new ResponseGenerico<>();
		response.setListado(listaPedido);
		response.setTotalRegistros((long) listaPedido.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarPedidoActivo")
	public ResponseGenerico<Pedido> listarPedidoActivo() {
		List<Pedido> listaPedido = PedidoServicio.listarPedidoActivo("wc-on-hold");
		// Respuesta
		ResponseGenerico<Pedido> response = new ResponseGenerico<>();
		response.setListado(listaPedido);
		response.setTotalRegistros((long) listaPedido.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarPedidoPorCliente/{customerId}")
	public ResponseGenerico<Pedido> listarPedidoPorPersona(@PathVariable("customerId") Long customerId) {
		List<Pedido> listaPedido = PedidoServicio.listarPedidoPorCliente(customerId);
		// Respuesta
		ResponseGenerico<Pedido> response = new ResponseGenerico<>();
		response.setListado(listaPedido);
		response.setTotalRegistros((long) listaPedido.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener Socio
	 * 
	 * @return Socio
	 */
	@GetMapping(value = "buscarPedidoPorCodigo/{orderId}")
	public ResponseGenerico<Pedido> buscarPedidoPorCodigo(@PathVariable("orderId") Long orderId) {
		Pedido Pedido = PedidoServicio.buscarPedidoPorOrderId(orderId);
		// Respuesta
		ResponseGenerico<Pedido> response = new ResponseGenerico<>();
		response.setObjeto(Pedido);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar Pedido
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarPedido")
	public ResponseGenerico<Pedido> guardarPedido(@RequestBody Pedido Pedido) {
		Pedido = PedidoServicio.registrar(Pedido);
		// Respuesta
		ResponseGenerico<Pedido> response = new ResponseGenerico<>();
		response.setObjeto(Pedido);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarPedidoPorId/{orderId}")
	public ResponseGenerico<Pedido> eliminarPedido(@PathVariable("orderId") Long orderId) {
		Pedido Pedido = PedidoServicio.buscarPedidoPorOrderId(orderId);
		Pedido.setStatus("Eliminar");
		PedidoServicio.registrar(Pedido);
		// Respuesta
		ResponseGenerico<Pedido> response = new ResponseGenerico<>();
		response.setObjeto(Pedido);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
