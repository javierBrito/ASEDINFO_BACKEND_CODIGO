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
import ec.gob.educacion.modelo.competencia.Integrante;
import ec.gob.educacion.venta.resources.EstadoEnum;
import ec.gob.educacion.servicio.competencia.IntegranteServicio;

@RestController
@RequestMapping("competencia/")
public class IntegranteControlador {

	@Autowired
	private IntegranteServicio integranteServicio;

	@GetMapping(value = "listarTodosIntegrante")
	public ResponseGenerico<Integrante> listarTodosIntegrante() {
		List<Integrante> listaIntegrante = integranteServicio.listarTodosIntegrante();
		// Respuesta
		ResponseGenerico<Integrante> response = new ResponseGenerico<>();
		response.setListado(listaIntegrante);
		response.setTotalRegistros((long) listaIntegrante.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarIntegranteActivo")
	public ResponseGenerico<Integrante> listarIntegranteActivo() {
		List<Integrante> listaIntegrante = integranteServicio.listarIntegranteActivo(EstadoEnum.ACTIVO.getDescripcion());
		// Respuesta
		ResponseGenerico<Integrante> response = new ResponseGenerico<>();
		response.setListado(listaIntegrante);
		response.setTotalRegistros((long) listaIntegrante.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarIntegrantePorParticipante/{codParticipante}")
	public ResponseGenerico<Integrante> listarIntegrantePorParticipante(@PathVariable("codParticipante") Long codParticipante) {
		List<Integrante> listaIntegrante = integranteServicio.listarIntegrantePorParticipante(codParticipante);
		// Respuesta
		ResponseGenerico<Integrante> response = new ResponseGenerico<>();
		response.setListado(listaIntegrante);
		response.setTotalRegistros((long) listaIntegrante.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener Integrante
	 * 
	 * @return Integrante
	 */
	@GetMapping(value = "buscarIntegrantePorCodigo/{codigo}")
	public ResponseGenerico<Integrante> buscarIntegrantePorCodigo(@PathVariable("codigo") Long codigo) {
		Integrante Integrante = integranteServicio.buscarIntegrantePorCodigo(codigo);
		// Respuesta
		ResponseGenerico<Integrante> response = new ResponseGenerico<>();
		response.setObjeto(Integrante);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener Participante
	 * 
	 * @return Participante
	 */
	@GetMapping(value = "buscarIntegrantePorNombre/{nombre}/{codParticipante}")
	public ResponseGenerico<Integrante> buscarParticipantePorNombre(@PathVariable("nombre") String nombre, @PathVariable("codParticipante") Long codParticipante) {
		Integrante integrante = integranteServicio.buscarIntegrantePorNombre(nombre, codParticipante);
		// Respuesta
		ResponseGenerico<Integrante> response = new ResponseGenerico<>();
		response.setObjeto(integrante);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar Integrante
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarListaIntegrante")
	public ResponseGenerico<Integrante> guardarListaIntegrante(@RequestBody List<Integrante> listaIntegrante) {
		Integrante integrante = new Integrante();
		if (listaIntegrante.size() > 0) {
			for (Integrante integranteAux : listaIntegrante) {
				integrante = integranteServicio.registrar(integranteAux);
			}
		}
		// Respuesta
		ResponseGenerico<Integrante> response = new ResponseGenerico<>();
		response.setObjeto(integrante);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * REST para guardar o actualizar Integrante
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarIntegrante")
	public ResponseGenerico<Integrante> guardarIntegrante(@RequestBody Integrante integrante) {
		integrante = integranteServicio.registrar(integrante);
		// Respuesta
		ResponseGenerico<Integrante> response = new ResponseGenerico<>();
		response.setObjeto(integrante);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarIntegrantePorId/{codigo}")
	public ResponseGenerico<Integrante> eliminarIntegrante(@PathVariable("codigo") Long codigo) {
		Integrante integrante = integranteServicio.buscarIntegrantePorCodigo(codigo);
		integrante.setEstado(EstadoEnum.INACTIVO.getDescripcion());
		integranteServicio.registrar(integrante);
		// Respuesta
		ResponseGenerico<Integrante> response = new ResponseGenerico<>();
		response.setObjeto(integrante);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
