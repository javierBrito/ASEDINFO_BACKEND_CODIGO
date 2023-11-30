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
import ec.gob.educacion.modelo.competencia.Participante;
import ec.gob.educacion.modelo.response.ResponseGenerico;
import ec.gob.educacion.modelo.wordpress.ClienteWP;
import ec.gob.educacion.servicio.competencia.ParticipanteServicio;
import ec.gob.educacion.servicio.wordpress.ClienteWPServicio;

@RestController
@RequestMapping("wordpress/")
public class ClienteWPControlador {

	@Autowired
	private ClienteWPServicio clienteWPServicio;
	@Autowired
	private ParticipanteServicio participanteServicio;

	@GetMapping(value = "listarTodosClienteWP")
	public ResponseGenerico<ClienteWP> listarTodosClienteWP() {
		List<ClienteWP> listaClienteWP = clienteWPServicio.listarTodosClienteWP();
		// Respuesta
		ResponseGenerico<ClienteWP> response = new ResponseGenerico<>();
		response.setListado(listaClienteWP);
		response.setTotalRegistros((long) listaClienteWP.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarClienteWPPorEstado/{estadoPedido}")
	public ResponseGenerico<ClienteWP> listarClienteWPPorEstado(@PathVariable("estadoPedido") String estadoPedido) {
		List<ClienteWP> listaClienteWP = clienteWPServicio.listarClienteWPPorEstado(estadoPedido);
		System.out.println("listaClienteWP.size() = "+listaClienteWP.size());
		if (listaClienteWP.size() > 0) {
			for (ClienteWP clienteWP : listaClienteWP) {
				System.out.println("clienteWP.getCustomerId() = "+clienteWP.getCustomerId());
				// Mover datos desde ClienteWP a Participante
				Participante participante = new Participante();
				participante.setCustomerId(clienteWP.getCustomerId());
				participante.setDateLastActive(clienteWP.getDateLastActive());
				participante.setDateRegistered(clienteWP.getDateRegistered());
				participante.setEmail(clienteWP.getEmail());
				participante.setFirstName(clienteWP.getFirstName());
				participante.setLastName(clienteWP.getLastName());
				participante.setUserId(clienteWP.getUserId());
				participante.setUsername(clienteWP.getUsername());
				
				// Guardar el registro
				System.out.println("participante.getCustomerId() = "+participante.getCustomerId());
				participanteServicio.registrar(participante);
				System.out.println("Registro guardado = "+participante.getFirstName() + "" + participante.getLastName());
			}
		}
		// Respuesta
		ResponseGenerico<ClienteWP> response = new ResponseGenerico<>();
		response.setListado(listaClienteWP);
		response.setTotalRegistros((long) listaClienteWP.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener Socio
	 * 
	 * @return Socio
	 */
	@GetMapping(value = "buscarClienteWPPorCodigo/{customerId}")
	public ResponseGenerico<ClienteWP> buscarClienteWPPorCodigo(@PathVariable("customerId") Long customerId) {
		ClienteWP ClienteWP = clienteWPServicio.buscarClienteWPPorCustomerId(customerId);
		// Respuesta
		ResponseGenerico<ClienteWP> response = new ResponseGenerico<>();
		response.setObjeto(ClienteWP);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar ClienteWP
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarClienteWP")
	public ResponseGenerico<ClienteWP> guardarClienteWP(@RequestBody ClienteWP ClienteWP) {
		ClienteWP = clienteWPServicio.registrar(ClienteWP);
		// Respuesta
		ResponseGenerico<ClienteWP> response = new ResponseGenerico<>();
		response.setObjeto(ClienteWP);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarClienteWPPorId/{customerId}")
	public ResponseGenerico<ClienteWP> eliminarClienteWP(@PathVariable("customerId") Long customerId) {
		ClienteWP clienteWP = clienteWPServicio.buscarClienteWPPorCustomerId(customerId);
		//ClienteWP.setStatus("Eliminar");
		clienteWPServicio.registrar(clienteWP);
		// Respuesta
		ResponseGenerico<ClienteWP> response = new ResponseGenerico<>();
		response.setObjeto(clienteWP);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
