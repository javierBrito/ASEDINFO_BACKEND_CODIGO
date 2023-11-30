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
import ec.gob.educacion.modelo.catalogo.ModeloPuntaje;
import ec.gob.educacion.venta.resources.EstadoEnum;
import ec.gob.educacion.servicio.catalogo.ModeloPuntajeServicio;

@RestController
@RequestMapping("catalogo/")
public class ModeloPuntajeControlador {

	@Autowired
	private ModeloPuntajeServicio modeloPuntajeServicio;

	@GetMapping(value = "listarTodosModeloPuntaje")
	public ResponseGenerico<ModeloPuntaje> listarTodosModeloPuntaje() {
		List<ModeloPuntaje> listaModeloPuntaje = modeloPuntajeServicio.listarTodosModeloPuntaje();
		// Respuesta
		ResponseGenerico<ModeloPuntaje> response = new ResponseGenerico<>();
		response.setListado(listaModeloPuntaje);
		response.setTotalRegistros((long) listaModeloPuntaje.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarModeloPuntajeActivo")
	public ResponseGenerico<ModeloPuntaje> listarModeloPuntajeActivo() {
		List<ModeloPuntaje> listaModeloPuntaje = modeloPuntajeServicio.listarModeloPuntajeActivo(EstadoEnum.ACTIVO.getDescripcion());
		// Respuesta
		ResponseGenerico<ModeloPuntaje> response = new ResponseGenerico<>();
		response.setListado(listaModeloPuntaje);
		response.setTotalRegistros((long) listaModeloPuntaje.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener ModeloPuntaje
	 * 
	 * @return ModeloPuntaje
	 */
	@GetMapping(value = "buscarModeloPuntajePorCodigo/{codigo}")
	public ResponseGenerico<ModeloPuntaje> buscarModeloPuntajePorCodigo(@PathVariable("codigo") Long codigo) {
		ModeloPuntaje modeloPuntaje = modeloPuntajeServicio.buscarModeloPuntajePorCodigo(codigo);
		// Respuesta
		ResponseGenerico<ModeloPuntaje> response = new ResponseGenerico<>();
		response.setObjeto(modeloPuntaje);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar ModeloPuntaje
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarModeloPuntaje")
	public ResponseGenerico<ModeloPuntaje> guardarModeloPuntaje(@RequestBody ModeloPuntaje modeloPuntaje) {
		modeloPuntaje = modeloPuntajeServicio.registrar(modeloPuntaje);
		// Respuesta
		ResponseGenerico<ModeloPuntaje> response = new ResponseGenerico<>();
		response.setObjeto(modeloPuntaje);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarModeloPuntajePorId/{codigo}")
	public ResponseGenerico<ModeloPuntaje> eliminarModeloPuntaje(@PathVariable("codigo") Long codigo) {
		ModeloPuntaje modeloPuntaje = modeloPuntajeServicio.buscarModeloPuntajePorCodigo(codigo);
		modeloPuntaje.setEstado(EstadoEnum.INACTIVO.getDescripcion());
		modeloPuntajeServicio.registrar(modeloPuntaje);
		// Respuesta
		ResponseGenerico<ModeloPuntaje> response = new ResponseGenerico<>();
		response.setObjeto(modeloPuntaje);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
