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
import ec.gob.educacion.modelo.catalogo.Seguimiento;
import ec.gob.educacion.venta.resources.EstadoEnum;
import ec.gob.educacion.servicio.catalogo.SeguimientoServicio;

@RestController
@RequestMapping("catalogo/")
public class SeguimientoControlador {

	@Autowired
	private SeguimientoServicio seguimientoServicio;

	@GetMapping(value = "listarTodosSeguimiento")
	public ResponseGenerico<Seguimiento> listarTodosSeguimiento() {
		List<Seguimiento> listaSeguimiento = seguimientoServicio.listarTodosSeguimiento();
		// Respuesta
		ResponseGenerico<Seguimiento> response = new ResponseGenerico<>();
		response.setListado(listaSeguimiento);
		response.setTotalRegistros((long) listaSeguimiento.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarSeguimientoActivo")
	public ResponseGenerico<Seguimiento> listarSeguimientoActivo() {
		List<Seguimiento> listaSeguimiento = seguimientoServicio.listarSeguimientoActivo(EstadoEnum.ACTIVO.getDescripcion());
		// Respuesta
		ResponseGenerico<Seguimiento> response = new ResponseGenerico<>();
		response.setListado(listaSeguimiento);
		response.setTotalRegistros((long) listaSeguimiento.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener Seguimiento
	 * 
	 * @return Seguimiento
	 */
	@GetMapping(value = "buscarSeguimientoPorCodigo/{codigo}")
	public ResponseGenerico<Seguimiento> buscarSeguimientoPorCodigo(@PathVariable("codigo") Long codigo) {
		Seguimiento seguimiento = seguimientoServicio.buscarSeguimientoPorCodigo(codigo);
		// Respuesta
		ResponseGenerico<Seguimiento> response = new ResponseGenerico<>();
		response.setObjeto(seguimiento);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar Seguimiento
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarSeguimiento")
	public ResponseGenerico<Seguimiento> guardarSeguimiento(@RequestBody Seguimiento seguimiento) {
		seguimiento = seguimientoServicio.registrar(seguimiento);
		// Respuesta
		ResponseGenerico<Seguimiento> response = new ResponseGenerico<>();
		response.setObjeto(seguimiento);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarSeguimientoPorId/{codigo}")
	public ResponseGenerico<Seguimiento> eliminarSeguimiento(@PathVariable("codigo") Long codigo) {
		Seguimiento seguimiento = seguimientoServicio.buscarSeguimientoPorCodigo(codigo);
		seguimiento.setEstado(EstadoEnum.INACTIVO.getDescripcion());
		seguimientoServicio.registrar(seguimiento);
		// Respuesta
		ResponseGenerico<Seguimiento> response = new ResponseGenerico<>();
		response.setObjeto(seguimiento);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
