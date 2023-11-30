package ec.gob.educacion.controlador.competencia;

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
import ec.gob.educacion.modelo.competencia.Participante;
import ec.gob.educacion.servicio.competencia.ParticipanteServicio;

@RestController
@RequestMapping("wordpress/")
public class ParticipanteControlador {

	@Autowired
	private ParticipanteServicio participanteServicio;

	@GetMapping(value = "listarTodosParticipante")
	public ResponseGenerico<Participante> listarTodosParticipante() {
		List<Participante> listaParticipante = participanteServicio.listarTodosParticipante();
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setListado(listaParticipante);
		response.setTotalRegistros((long) listaParticipante.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarParticipantePorEstado/{estadoPedido}")
	public ResponseGenerico<Participante> listarParticipantePorEstado(@PathVariable("estadoPedido") String estadoPedido) {
		List<Participante> listaParticipante = participanteServicio.listarParticipantePorEstado(estadoPedido);
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setListado(listaParticipante);
		response.setTotalRegistros((long) listaParticipante.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener Socio
	 * 
	 * @return Socio
	 */
	@GetMapping(value = "buscarParticipantePorCodigo/{codigo}")
	public ResponseGenerico<Participante> buscarParticipantePorCodigo(@PathVariable("codigo") Long codigo) {
		Participante Participante = participanteServicio.buscarParticipantePorCodigo(codigo);
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setObjeto(Participante);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar Participante
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarParticipante")
	public ResponseGenerico<Participante> guardarParticipante(@RequestBody Participante Participante) {
		Participante = participanteServicio.registrar(Participante);
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setObjeto(Participante);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarParticipantePorId/{codigo}")
	public ResponseGenerico<Participante> eliminarParticipante(@PathVariable("codigo") Long codigo) {
		Participante participante = participanteServicio.buscarParticipantePorCodigo(codigo);
		//Participante.setStatus("Eliminar");
		participanteServicio.registrar(participante);
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setObjeto(participante);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
