package ec.gob.educacion.controlador.catalogo;

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
import ec.gob.educacion.modelo.catalogo.EstadoCompetencia;
import ec.gob.educacion.venta.resources.EstadoEnum;
import ec.gob.educacion.servicio.catalogo.EstadoCompetenciaServicio;

@RestController
@RequestMapping("catalogo/")
public class EstadoCompetenciaControlador {

	@Autowired
	private EstadoCompetenciaServicio estadoCompetenciaServicio;

	@GetMapping(value = "listarTodosEstadoCompetencia")
	public ResponseGenerico<EstadoCompetencia> listarTodosEstadoCompetencia() {
		List<EstadoCompetencia> listaEstadoCompetencia = estadoCompetenciaServicio.listarTodosEstadoCompetencia();
		// Respuesta
		ResponseGenerico<EstadoCompetencia> response = new ResponseGenerico<>();
		response.setListado(listaEstadoCompetencia);
		response.setTotalRegistros((long) listaEstadoCompetencia.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarEstadoCompetenciaActivo")
	public ResponseGenerico<EstadoCompetencia> listarEstadoCompetenciaActivo() {
		List<EstadoCompetencia> listaEstadoCompetencia = estadoCompetenciaServicio.listarEstadoCompetenciaActivo(EstadoEnum.ACTIVO.getDescripcion());
		// Respuesta
		ResponseGenerico<EstadoCompetencia> response = new ResponseGenerico<>();
		response.setListado(listaEstadoCompetencia);
		response.setTotalRegistros((long) listaEstadoCompetencia.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener EstadoCompetencia
	 * 
	 * @return EstadoCompetencia
	 */
	@GetMapping(value = "buscarEstadoCompetenciaPorCodigo/{codigo}")
	public ResponseGenerico<EstadoCompetencia> buscarEstadoCompetenciaPorCodigo(@PathVariable("codigo") Long codigo) {
		EstadoCompetencia estadoCompetencia = estadoCompetenciaServicio.buscarEstadoCompetenciaPorCodigo(codigo);
		// Respuesta
		ResponseGenerico<EstadoCompetencia> response = new ResponseGenerico<>();
		response.setObjeto(estadoCompetencia);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar EstadoCompetencia
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarEstadoCompetencia")
	public ResponseGenerico<EstadoCompetencia> guardarEstadoCompetencia(@RequestBody EstadoCompetencia estadoCompetencia) {
		estadoCompetencia = estadoCompetenciaServicio.registrar(estadoCompetencia);
		// Respuesta
		ResponseGenerico<EstadoCompetencia> response = new ResponseGenerico<>();
		response.setObjeto(estadoCompetencia);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarEstadoCompetenciaPorId/{codigo}")
	public ResponseGenerico<EstadoCompetencia> eliminarEstadoCompetencia(@PathVariable("codigo") Long codigo) {
		EstadoCompetencia estadoCompetencia = estadoCompetenciaServicio.buscarEstadoCompetenciaPorCodigo(codigo);
		estadoCompetencia.setEstado(EstadoEnum.INACTIVO.getDescripcion());
		estadoCompetenciaServicio.registrar(estadoCompetencia);
		// Respuesta
		ResponseGenerico<EstadoCompetencia> response = new ResponseGenerico<>();
		response.setObjeto(estadoCompetencia);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
