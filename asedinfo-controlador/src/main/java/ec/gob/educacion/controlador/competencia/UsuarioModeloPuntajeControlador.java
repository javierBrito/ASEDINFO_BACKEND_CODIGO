package ec.gob.educacion.controlador.competencia;

import java.util.ArrayList;
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
import ec.gob.educacion.modelo.competencia.UsuarioModeloPuntaje;
import ec.gob.educacion.venta.resources.EstadoEnum;
import ec.gob.educacion.servicio.competencia.UsuarioModeloPuntajeServicio;

@RestController
@RequestMapping("competencia/")
public class UsuarioModeloPuntajeControlador {

	@Autowired
	private UsuarioModeloPuntajeServicio usuarioModeloPuntajeServicio;

	@GetMapping(value = "listarTodosUsuarioModeloPuntaje")
	public ResponseGenerico<UsuarioModeloPuntaje> listarTodosUsuarioModeloPuntaje() {
		List<UsuarioModeloPuntaje> listaUsuarioModeloPuntaje = usuarioModeloPuntajeServicio.listarTodosUsuarioModeloPuntaje();
		// Respuesta
		ResponseGenerico<UsuarioModeloPuntaje> response = new ResponseGenerico<>();
		response.setListado(listaUsuarioModeloPuntaje);
		response.setTotalRegistros((long) listaUsuarioModeloPuntaje.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarUsuarioModeloPuntajeActivo")
	public ResponseGenerico<UsuarioModeloPuntaje> listarUsuarioModeloPuntajeActivo() {
		List<UsuarioModeloPuntaje> listaUsuarioModeloPuntaje = usuarioModeloPuntajeServicio.listarUsuarioModeloPuntajeActivo(EstadoEnum.ACTIVO.getDescripcion());
		// Respuesta
		ResponseGenerico<UsuarioModeloPuntaje> response = new ResponseGenerico<>();
		response.setListado(listaUsuarioModeloPuntaje);
		response.setTotalRegistros((long) listaUsuarioModeloPuntaje.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener UsuarioModeloPuntaje
	 * 
	 * @return UsuarioModeloPuntaje
	 */
	@GetMapping(value = "buscarUsuarioModeloPuntajePorCodigo/{codigo}")
	public ResponseGenerico<UsuarioModeloPuntaje> buscarUsuarioModeloPuntajePorCodigo(@PathVariable("codigo") Long codigo) {
		UsuarioModeloPuntaje UsuarioModeloPuntaje = usuarioModeloPuntajeServicio.buscarUsuarioModeloPuntajePorCodigo(codigo);
		// Respuesta
		ResponseGenerico<UsuarioModeloPuntaje> response = new ResponseGenerico<>();
		response.setObjeto(UsuarioModeloPuntaje);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener UsuarioModeloPuntaje
	 * 
	 * @return UsuarioModeloPuntaje
	 */
	@GetMapping(value = "listarUsuarioModeloPuntajePorUsuario/{codUsuario}")
	public ResponseGenerico<UsuarioModeloPuntaje> listarUsuarioModeloPuntajePorUsuario(@PathVariable("codUsuario") Long codUsuario) {
		List<UsuarioModeloPuntaje> listaUsuarioModeloPuntaje = usuarioModeloPuntajeServicio.listarUsuarioModeloPuntajePorUsuario(codUsuario);
		// Respuesta
		ResponseGenerico<UsuarioModeloPuntaje> response = new ResponseGenerico<>();
		response.setListado(listaUsuarioModeloPuntaje);
		response.setTotalRegistros((long) listaUsuarioModeloPuntaje.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar UsuarioModeloPuntaje
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarListaUsuarioModeloPuntaje")
	public ResponseGenerico<UsuarioModeloPuntaje> guardarListaUsuarioModeloPuntaje(@RequestBody List<UsuarioModeloPuntaje> listaUsuarioModeloPuntaje) {
		Long codUsuario = 0L;
		UsuarioModeloPuntaje usuarioModeloPuntaje = new UsuarioModeloPuntaje();
		List<UsuarioModeloPuntaje> listaUsuarioModeloPuntajeEliminar = new ArrayList<>();
		if (listaUsuarioModeloPuntaje.size() > 0) {
			codUsuario = listaUsuarioModeloPuntaje.get(0).getCodUsuario();
			listaUsuarioModeloPuntajeEliminar = usuarioModeloPuntajeServicio.listarUsuarioModeloPuntajePorUsuario(codUsuario);
			if (listaUsuarioModeloPuntajeEliminar != null) {
				for (UsuarioModeloPuntaje usuarioModeloPuntajeAux : listaUsuarioModeloPuntajeEliminar) {
					usuarioModeloPuntajeAux.setEstado(EstadoEnum.INACTIVO.getDescripcion());
					usuarioModeloPuntajeServicio.registrar(usuarioModeloPuntajeAux);
				}	
			}
		}
		if (listaUsuarioModeloPuntaje.size() > 0) {
			for (UsuarioModeloPuntaje usuarioModeloPuntajeAux : listaUsuarioModeloPuntaje) {
				usuarioModeloPuntaje = usuarioModeloPuntajeServicio.registrar(usuarioModeloPuntajeAux);
			}
		}
		// Respuesta
		ResponseGenerico<UsuarioModeloPuntaje> response = new ResponseGenerico<>();
		response.setObjeto(usuarioModeloPuntaje);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * REST para guardar o actualizar UsuarioModeloPuntaje
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarUsuarioModeloPuntaje")
	public ResponseGenerico<UsuarioModeloPuntaje> guardarUsuarioModeloPuntaje(@RequestBody UsuarioModeloPuntaje usuarioModeloPuntaje) {
		usuarioModeloPuntaje = usuarioModeloPuntajeServicio.registrar(usuarioModeloPuntaje);
		// Respuesta
		ResponseGenerico<UsuarioModeloPuntaje> response = new ResponseGenerico<>();
		response.setObjeto(usuarioModeloPuntaje);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarUsuarioModeloPuntajePorId/{codigo}")
	public ResponseGenerico<UsuarioModeloPuntaje> eliminarUsuarioModeloPuntajePorId(@PathVariable("codigo") Long codigo) {
		UsuarioModeloPuntaje usuarioModeloPuntaje = usuarioModeloPuntajeServicio.buscarUsuarioModeloPuntajePorCodigo(codigo);
		usuarioModeloPuntaje.setEstado(EstadoEnum.INACTIVO.getDescripcion());
		usuarioModeloPuntajeServicio.registrar(usuarioModeloPuntaje);
		// Respuesta
		ResponseGenerico<UsuarioModeloPuntaje> response = new ResponseGenerico<>();
		response.setObjeto(usuarioModeloPuntaje);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
