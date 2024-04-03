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
import ec.gob.educacion.modelo.catalogo.ModeloPuntajeOp;
import ec.gob.educacion.venta.resources.EstadoEnum;
import ec.gob.educacion.servicio.catalogo.ModeloPuntajeOpServicio;

@RestController
@RequestMapping("catalogo/")
public class ModeloPuntajeOpControlador {

	@Autowired
	private ModeloPuntajeOpServicio modeloPuntajeOpServicio;

	@GetMapping(value = "listarTodosModeloPuntajeOp")
	public ResponseGenerico<ModeloPuntajeOp> listarTodosModeloPuntajeOp() {
		List<ModeloPuntajeOp> listaModeloPuntajeOp = modeloPuntajeOpServicio.listarTodosModeloPuntajeOp();
		// Respuesta
		ResponseGenerico<ModeloPuntajeOp> response = new ResponseGenerico<>();
		response.setListado(listaModeloPuntajeOp);
		response.setTotalRegistros((long) listaModeloPuntajeOp.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarModeloPuntajeOpActivo")
	public ResponseGenerico<ModeloPuntajeOp> listarModeloPuntajeOpActivo() {
		List<ModeloPuntajeOp> listaModeloPuntajeOp = modeloPuntajeOpServicio.listarModeloPuntajeOpActivo(EstadoEnum.ACTIVO.getDescripcion());
		// Respuesta
		ResponseGenerico<ModeloPuntajeOp> response = new ResponseGenerico<>();
		response.setListado(listaModeloPuntajeOp);
		response.setTotalRegistros((long) listaModeloPuntajeOp.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener ModeloPuntajeOp
	 * 
	 * @return ModeloPuntajeOp
	 */
	@GetMapping(value = "buscarModeloPuntajeOpPorCodigo/{codigo}")
	public ResponseGenerico<ModeloPuntajeOp> buscarModeloPuntajeOpPorCodigo(@PathVariable("codigo") Long codigo) {
		ModeloPuntajeOp modeloPuntajeOp = modeloPuntajeOpServicio.buscarModeloPuntajeOpPorCodigo(codigo);
		// Respuesta
		ResponseGenerico<ModeloPuntajeOp> response = new ResponseGenerico<>();
		response.setObjeto(modeloPuntajeOp);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar ModeloPuntajeOp
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarModeloPuntajeOp")
	public ResponseGenerico<ModeloPuntajeOp> guardarModeloPuntajeOp(@RequestBody ModeloPuntajeOp modeloPuntajeOp) {
		modeloPuntajeOp = modeloPuntajeOpServicio.registrar(modeloPuntajeOp);
		// Respuesta
		ResponseGenerico<ModeloPuntajeOp> response = new ResponseGenerico<>();
		response.setObjeto(modeloPuntajeOp);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarModeloPuntajeOpPorId/{codigo}")
	public ResponseGenerico<ModeloPuntajeOp> eliminarModeloPuntajeOp(@PathVariable("codigo") Long codigo) {
		ModeloPuntajeOp modeloPuntajeOp = modeloPuntajeOpServicio.buscarModeloPuntajeOpPorCodigo(codigo);
		modeloPuntajeOp.setEstado(EstadoEnum.INACTIVO.getDescripcion());
		modeloPuntajeOpServicio.registrar(modeloPuntajeOp);
		// Respuesta
		ResponseGenerico<ModeloPuntajeOp> response = new ResponseGenerico<>();
		response.setObjeto(modeloPuntajeOp);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
