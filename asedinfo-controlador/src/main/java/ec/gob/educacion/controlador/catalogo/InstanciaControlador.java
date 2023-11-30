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
import ec.gob.educacion.modelo.catalogo.Instancia;
import ec.gob.educacion.venta.resources.EstadoEnum;
import ec.gob.educacion.servicio.catalogo.InstanciaServicio;

@RestController
@RequestMapping("catalogo/")
public class InstanciaControlador {

	@Autowired
	private InstanciaServicio instanciaServicio;

	@GetMapping(value = "listarTodosInstancia")
	public ResponseGenerico<Instancia> listarTodosInstancia() {
		List<Instancia> listaInstancia = instanciaServicio.listarTodosInstancia();
		// Respuesta
		ResponseGenerico<Instancia> response = new ResponseGenerico<>();
		response.setListado(listaInstancia);
		response.setTotalRegistros((long) listaInstancia.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarInstanciaActivo")
	public ResponseGenerico<Instancia> listarInstanciaActivo() {
		List<Instancia> listaInstancia = instanciaServicio.listarInstanciaActivo(EstadoEnum.ACTIVO.getDescripcion());
		// Respuesta
		ResponseGenerico<Instancia> response = new ResponseGenerico<>();
		response.setListado(listaInstancia);
		response.setTotalRegistros((long) listaInstancia.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener Instancia
	 * 
	 * @return Instancia
	 */
	@GetMapping(value = "buscarInstanciaPorCodigo/{codigo}")
	public ResponseGenerico<Instancia> buscarInstanciaPorCodigo(@PathVariable("codigo") Long codigo) {
		Instancia Instancia = instanciaServicio.buscarInstanciaPorCodigo(codigo);
		// Respuesta
		ResponseGenerico<Instancia> response = new ResponseGenerico<>();
		response.setObjeto(Instancia);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar Instancia
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarInstancia")
	public ResponseGenerico<Instancia> guardarInstancia(@RequestBody Instancia instancia) {
		instancia = instanciaServicio.registrar(instancia);
		// Respuesta
		ResponseGenerico<Instancia> response = new ResponseGenerico<>();
		response.setObjeto(instancia);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarInstanciaPorId/{codigo}")
	public ResponseGenerico<Instancia> eliminarInstancia(@PathVariable("codigo") Long codigo) {
		Instancia instancia = instanciaServicio.buscarInstanciaPorCodigo(codigo);
		instancia.setEstado(EstadoEnum.INACTIVO.getDescripcion());
		instanciaServicio.registrar(instancia);
		// Respuesta
		ResponseGenerico<Instancia> response = new ResponseGenerico<>();
		response.setObjeto(instancia);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
