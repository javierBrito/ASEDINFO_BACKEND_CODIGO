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
import ec.gob.educacion.modelo.competencia.Puntaje;
import ec.gob.educacion.venta.resources.EstadoEnum;
import ec.gob.educacion.servicio.competencia.PuntajeServicio;

@RestController
@RequestMapping("competencia/")
public class PuntajeControlador {

	@Autowired
	private PuntajeServicio puntajeServicio;

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

	@GetMapping(value = "listarPuntajePorParticipanteRegTotal/{codParticipante}/{codInstancia}/{codUsuarioJuez}/{codModeloPuntaje}")
	public ResponseGenerico<Puntaje> listarPuntajePorParticipanteRegTotal(@PathVariable("codParticipante") Long codParticipante, @PathVariable("codInstancia") Long codInstancia, @PathVariable("codUsuarioJuez") Long codUsuarioJuez, @PathVariable("codModeloPuntaje") Long codModeloPuntaje) {
		List<Puntaje> listaPuntaje = puntajeServicio.listarPuntajePorParticipanteRegTotal(codParticipante, codInstancia, codUsuarioJuez, codModeloPuntaje);
		// Respuesta
		ResponseGenerico<Puntaje> response = new ResponseGenerico<>();
		response.setListado(listaPuntaje);
		response.setTotalRegistros((long) listaPuntaje.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		System.out.println();
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
}
