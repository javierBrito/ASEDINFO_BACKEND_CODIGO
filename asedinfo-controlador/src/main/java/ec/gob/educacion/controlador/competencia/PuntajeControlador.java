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
import ec.gob.educacion.modelo.seguridad.Usuario;
import ec.gob.educacion.modelo.catalogo.EstadoCompetencia;
import ec.gob.educacion.modelo.competencia.Participante;
import ec.gob.educacion.modelo.competencia.Puntaje;
import ec.gob.educacion.venta.resources.EstadoEnum;
import ec.gob.educacion.servicio.catalogo.EstadoCompetenciaServicio;
import ec.gob.educacion.servicio.competencia.ParticipanteServicio;
import ec.gob.educacion.servicio.competencia.PuntajeServicio;
import ec.gob.educacion.servicio.seguridad.UsuarioServicio;

@RestController
@RequestMapping("competencia/")
public class PuntajeControlador {

	@Autowired
	private PuntajeServicio puntajeServicio;
	@Autowired
	private UsuarioServicio usuarioServicio;
	@Autowired
	private ParticipanteServicio participanteServicio;
	@Autowired
	private EstadoCompetenciaServicio estadoCompetenciaServicio;

	@GetMapping(value = "listarTodosPuntaje")
	public ResponseGenerico<Puntaje> listarTodosPuntaje() {
		List<Puntaje> listaPuntaje = puntajeServicio.listarTodosPuntaje();
		// Respuesta
		ResponseGenerico<Puntaje> response = new ResponseGenerico<>();
		response.setListado(listaPuntaje);
		response.setTotalRegistros((long) listaPuntaje.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarPuntajeActivo")
	public ResponseGenerico<Puntaje> listarPuntajeActivo() {
		List<Puntaje> listaPuntaje = puntajeServicio.listarPuntajeActivo(EstadoEnum.ACTIVO.getDescripcion());
		// Respuesta
		ResponseGenerico<Puntaje> response = new ResponseGenerico<>();
		response.setListado(listaPuntaje);
		response.setTotalRegistros((long) listaPuntaje.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarPuntajePorSubcategoriaRegTotal/{codSubcategoria}/{codInstancia}/{codUsuarioJuez}")
	public ResponseGenerico<Puntaje> listarPuntajePorSubcategoriaRegTotal(@PathVariable("codSubcategoria") Long codSubcategoria, @PathVariable("codInstancia") Long codInstancia, @PathVariable("codUsuarioJuez") Long codUsuarioJuez) {
		List<Puntaje> listaPuntaje = puntajeServicio.listarPuntajePorSubcategoriaRegTotal(codSubcategoria, codInstancia, codUsuarioJuez);
		// Respuesta
		ResponseGenerico<Puntaje> response = new ResponseGenerico<>();
		response.setListado(listaPuntaje);
		response.setTotalRegistros((long) listaPuntaje.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarPuntajePorSubcategoria/{codSubcategoria}/{codInstancia}")
	public ResponseGenerico<Puntaje> listarPuntajePorSubcategoria(@PathVariable("codSubcategoria") Long codSubcategoria, @PathVariable("codInstancia") Long codInstancia) {
		List<Puntaje> listaPuntaje = puntajeServicio.listarPuntajePorSubcategoria(codSubcategoria, codInstancia);
		// Respuesta
		ResponseGenerico<Puntaje> response = new ResponseGenerico<>();
		response.setListado(listaPuntaje);
		response.setTotalRegistros((long) listaPuntaje.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarPuntajePorParticipanteSubcategoriaInstancia/{codParticipante}/{codSubcategoria}/{codInstancia}/{codUsuarioJuez}")
	public ResponseGenerico<Puntaje> listarPuntajePorParticipanteSubcategoriaInstancia(@PathVariable("codParticipante") Long codParticipante, @PathVariable("codSubcategoria") Long codSubcategoria, @PathVariable("codInstancia") Long codInstancia, @PathVariable("codUsuarioJuez") Long codUsuarioJuez) {
		List<Puntaje> listaPuntaje = puntajeServicio.listarPuntajePorParticipanteSubcategoriaInstancia(codParticipante, codSubcategoria, codInstancia, codUsuarioJuez);
		// Respuesta
		ResponseGenerico<Puntaje> response = new ResponseGenerico<>();
		response.setListado(listaPuntaje);
		response.setTotalRegistros((long) listaPuntaje.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarPuntajePorParticipanteSubcategoriaInstanciaCriterios/{codParticipante}/{codSubcategoria}/{codInstancia}")
	public ResponseGenerico<Puntaje> listarPuntajePorParticipanteSubcategoriaInstanciaCriterios(@PathVariable("codParticipante") Long codParticipante, @PathVariable("codSubcategoria") Long codSubcategoria, @PathVariable("codInstancia") Long codInstancia) {
		List<Puntaje> listaPuntaje = puntajeServicio.listarPuntajePorParticipanteSubcategoriaInstanciaCriterios(codParticipante, codSubcategoria, codInstancia);
		// Respuesta
		ResponseGenerico<Puntaje> response = new ResponseGenerico<>();
		response.setListado(listaPuntaje);
		response.setTotalRegistros((long) listaPuntaje.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarPuntajePorParticipanteRegTotal/{codParticipante}/{codSubcategoria}/{codInstancia}/{codUsuarioJuez}/{codModeloPuntaje}")
	public ResponseGenerico<Puntaje> listarPuntajePorParticipanteRegTotal(@PathVariable("codParticipante") Long codParticipante, @PathVariable("codSubcategoria") Long codSubcategoria, @PathVariable("codInstancia") Long codInstancia, @PathVariable("codUsuarioJuez") Long codUsuarioJuez, @PathVariable("codModeloPuntaje") Long codModeloPuntaje) {
		List<Puntaje> listaPuntaje = puntajeServicio.listarPuntajePorParticipanteRegTotal(codParticipante, codSubcategoria, codInstancia, codUsuarioJuez, codModeloPuntaje);
		// Respuesta
		ResponseGenerico<Puntaje> response = new ResponseGenerico<>();
		response.setListado(listaPuntaje);
		response.setTotalRegistros((long) listaPuntaje.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarPuntajePorSubcategoriaInstanciaRegAVG/{codSubcategoria}/{codInstancia}")
	public ResponseGenerico<Puntaje> listarPuntajePorSubcategoriaInstanciaRegAVG(@PathVariable("codSubcategoria") Long codSubcategoria, @PathVariable("codInstancia") Long codInstancia) {
		List<Puntaje> listaPuntaje = puntajeServicio.listarPuntajePorSubcategoriaInstanciaRegAVG(codSubcategoria, codInstancia);
		// Respuesta
		ResponseGenerico<Puntaje> response = new ResponseGenerico<>();
		response.setListado(listaPuntaje);
		response.setTotalRegistros((long) listaPuntaje.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarPuntajePorSubcategoriaInstanciaRegSUMA/{codSubcategoria}/{codInstancia}")
	public ResponseGenerico<Puntaje> listarPuntajePorSubcategoriaInstanciaRegSUMA(@PathVariable("codSubcategoria") Long codSubcategoria, @PathVariable("codInstancia") Long codInstancia) {
		List<Puntaje> listaPuntaje = puntajeServicio.listarPuntajePorSubcategoriaInstanciaRegSUMA(codSubcategoria, codInstancia);
		// Respuesta
		ResponseGenerico<Puntaje> response = new ResponseGenerico<>();
		response.setListado(listaPuntaje);
		response.setTotalRegistros((long) listaPuntaje.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarPuntajePorParticipanteSubcategoriaInstanciaRegSUMA/{codSubcategoria}/{codInstancia}/{codParticipante}")
	public ResponseGenerico<Puntaje> listarPuntajePorParticipanteSubcategoriaInstanciaRegSUMA(@PathVariable("codSubcategoria") Long codSubcategoria, @PathVariable("codInstancia") Long codInstancia, @PathVariable("codParticipante") Long codParticipante) {
		List<Puntaje> listaPuntaje = puntajeServicio.listarPuntajePorParticipanteSubcategoriaInstanciaRegSUMA(codSubcategoria, codInstancia, codParticipante);
		// Respuesta
		ResponseGenerico<Puntaje> response = new ResponseGenerico<>();
		response.setListado(listaPuntaje);
		response.setTotalRegistros((long) listaPuntaje.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener Puntaje
	 * 
	 * @return Puntaje
	 */
	@GetMapping(value = "buscarPuntajePorCodigo/{codigo}")
	public ResponseGenerico<Puntaje> buscarPuntajePorCodigo(@PathVariable("codigo") Long codigo) {
		Puntaje puntaje = puntajeServicio.buscarPuntajePorCodigo(codigo);
		// Respuesta
		ResponseGenerico<Puntaje> response = new ResponseGenerico<>();
		response.setObjeto(puntaje);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar Puntaje
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarPuntaje")
	public ResponseGenerico<Puntaje> guardarPuntaje(@RequestBody Puntaje puntaje) {
		puntaje = puntajeServicio.registrar(puntaje);
		// Respuesta
		ResponseGenerico<Puntaje> response = new ResponseGenerico<>();
		response.setObjeto(puntaje);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarPuntajePorId/{codigo}")
	public ResponseGenerico<Puntaje> eliminarPuntaje(@PathVariable("codigo") Long codigo) {
		Puntaje puntaje = puntajeServicio.buscarPuntajePorCodigo(codigo);
		puntaje.setEstado(EstadoEnum.INACTIVO.getDescripcion());
		puntajeServicio.registrar(puntaje);
		// Respuesta
		ResponseGenerico<Puntaje> response = new ResponseGenerico<>();
		response.setObjeto(puntaje);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
	
	/**
	 * REST para guardar o actualizar Puntaje
	 * 
	 * @return guardar
	 */
	@SuppressWarnings("unused")
	@PostMapping(value = "guardarListaPuntaje")
	public ResponseGenerico<Puntaje> guardarListaPuntaje(@RequestBody List<Puntaje> listaPuntaje) {
		boolean actualizarNumPuntajeJuez = false;
		Participante participante = new Participante();
		EstadoCompetencia estadoCompetencia = new EstadoCompetencia();
		Usuario usuario = new Usuario();
		Puntaje puntaje = new Puntaje();
		if (listaPuntaje.size() > 0) {
			// Obtener los datos del juez
			if (listaPuntaje.get(0).getCodUsuarioJuez() != 0) {
				usuario = usuarioServicio.buscarUsuarioPorCodigo(listaPuntaje.get(0).getCodUsuarioJuez());
			}
			// Validar el tipo de juez
			if (usuario != null && usuario.getCedula().equalsIgnoreCase("JUEZADMIN")) {
				Integer respuesta = puntajeServicio.eliminarPuntajePorParticipanteInstancia(listaPuntaje.get(0).getCodParticipante(), listaPuntaje.get(0).getCodInstancia());
				for (Puntaje puntajeAux : listaPuntaje) {
					puntaje = puntajeServicio.registrar(puntajeAux);
				}
			} else {
				if (listaPuntaje.get(0).getCodigo() == 0) {
					actualizarNumPuntajeJuez = true;
				}
				Integer respuesta = puntajeServicio.eliminarPuntajePorParticipanteUsuarioJuezInstancia(listaPuntaje.get(0).getCodParticipante(), listaPuntaje.get(0).getCodUsuarioJuez(), listaPuntaje.get(0).getCodInstancia());
				for (Puntaje puntajeAux : listaPuntaje) {
					puntaje = puntajeServicio.registrar(puntajeAux);
				}
				if (actualizarNumPuntajeJuez) {
					// Actualizar el número de puntaje por cada juez
					participante = participanteServicio.buscarParticipantePorCodigo(listaPuntaje.get(0).getCodParticipante());
					if (participante != null) {
						participante.setNumPuntajeJuez(participante.getNumPuntajeJuez() + 1);
						// Actualizar codigo estado competencia a completado = 5
						// NumJues numero de jueces que van a puntuar que se encuentra en la Subcategoria
						if (participante.getNumPuntajeJuez() == participante.getNumJueces()) {
							estadoCompetencia = estadoCompetenciaServicio.buscarEstadoCompetenciaPorCodigo(5L);
							participante.setEstadoCompetencia(estadoCompetencia);
						}
						// Actualizar los datos del participante
						participanteServicio.registrar(participante);
					}
				}
			}
			
		}
		// Respuesta
		ResponseGenerico<Puntaje> response = new ResponseGenerico<>();
		response.setObjeto(puntaje);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}
	
}
