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
import ec.gob.educacion.modelo.competencia.UsuarioModeloPuntajeOp;
import ec.gob.educacion.venta.resources.EstadoEnum;
import ec.gob.educacion.servicio.competencia.UsuarioModeloPuntajeOpServicio;

@RestController
@RequestMapping("competencia/")
public class UsuarioModeloPuntajeOpControlador {

	@Autowired
	private UsuarioModeloPuntajeOpServicio usuarioModeloPuntajeOpServicio;

	@GetMapping(value = "listarTodosUsuarioModeloPuntajeOp")
	public ResponseGenerico<UsuarioModeloPuntajeOp> listarTodosUsuarioModeloPuntajeOp() {
		List<UsuarioModeloPuntajeOp> listaUsuarioModeloPuntajeOp = usuarioModeloPuntajeOpServicio.listarTodosUsuarioModeloPuntajeOp();
		// Respuesta
		ResponseGenerico<UsuarioModeloPuntajeOp> response = new ResponseGenerico<>();
		response.setListado(listaUsuarioModeloPuntajeOp);
		response.setTotalRegistros((long) listaUsuarioModeloPuntajeOp.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarUsuarioModeloPuntajeOpActivo")
	public ResponseGenerico<UsuarioModeloPuntajeOp> listarUsuarioModeloPuntajeOpActivo() {
		List<UsuarioModeloPuntajeOp> listaUsuarioModeloPuntajeOp = usuarioModeloPuntajeOpServicio.listarUsuarioModeloPuntajeOpActivo(EstadoEnum.ACTIVO.getDescripcion());
		// Respuesta
		ResponseGenerico<UsuarioModeloPuntajeOp> response = new ResponseGenerico<>();
		response.setListado(listaUsuarioModeloPuntajeOp);
		response.setTotalRegistros((long) listaUsuarioModeloPuntajeOp.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener UsuarioModeloPuntajeOp
	 * 
	 * @return UsuarioModeloPuntajeOp
	 */
	@GetMapping(value = "buscarUsuarioModeloPuntajeOpPorCodigo/{codigo}")
	public ResponseGenerico<UsuarioModeloPuntajeOp> buscarUsuarioModeloPuntajeOpPorCodigo(@PathVariable("codigo") Long codigo) {
		UsuarioModeloPuntajeOp UsuarioModeloPuntajeOp = usuarioModeloPuntajeOpServicio.buscarUsuarioModeloPuntajeOpPorCodigo(codigo);
		// Respuesta
		ResponseGenerico<UsuarioModeloPuntajeOp> response = new ResponseGenerico<>();
		response.setObjeto(UsuarioModeloPuntajeOp);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener UsuarioModeloPuntajeOp
	 * 
	 * @return UsuarioModeloPuntajeOp
	 */
	@GetMapping(value = "listarUsuarioModeloPuntajeOpPorUsuario/{codUsuario}")
	public ResponseGenerico<UsuarioModeloPuntajeOp> listarUsuarioModeloPuntajeOpPorUsuario(@PathVariable("codUsuario") Long codUsuario) {
		List<UsuarioModeloPuntajeOp> listaUsuarioModeloPuntajeOp = usuarioModeloPuntajeOpServicio.listarUsuarioModeloPuntajeOpPorUsuario(codUsuario);
		// Respuesta
		ResponseGenerico<UsuarioModeloPuntajeOp> response = new ResponseGenerico<>();
		response.setListado(listaUsuarioModeloPuntajeOp);
		response.setTotalRegistros((long) listaUsuarioModeloPuntajeOp.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar UsuarioModeloPuntajeOp
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarListaUsuarioModeloPuntajeOp")
	public ResponseGenerico<UsuarioModeloPuntajeOp> guardarListaUsuarioModeloPuntajeOp(@RequestBody List<UsuarioModeloPuntajeOp> listaUsuarioModeloPuntajeOp) {
		Long codUsuario = 0L;
		UsuarioModeloPuntajeOp usuarioModeloPuntajeOp = new UsuarioModeloPuntajeOp();
		List<UsuarioModeloPuntajeOp> listaUsuarioModeloPuntajeOpEliminar = new ArrayList<>();
		if (listaUsuarioModeloPuntajeOp.size() > 0) {
			codUsuario = listaUsuarioModeloPuntajeOp.get(0).getCodUsuario();
			listaUsuarioModeloPuntajeOpEliminar = usuarioModeloPuntajeOpServicio.listarUsuarioModeloPuntajeOpPorUsuario(codUsuario);
			if (listaUsuarioModeloPuntajeOpEliminar != null) {
				for (UsuarioModeloPuntajeOp usuarioModeloPuntajeOpAux : listaUsuarioModeloPuntajeOpEliminar) {
					usuarioModeloPuntajeOpAux.setEstado(EstadoEnum.INACTIVO.getDescripcion());
					usuarioModeloPuntajeOpServicio.registrar(usuarioModeloPuntajeOpAux);
				}	
			}
		}
		if (listaUsuarioModeloPuntajeOp.size() > 0) {
			for (UsuarioModeloPuntajeOp usuarioModeloPuntajeOpAux : listaUsuarioModeloPuntajeOp) {
				usuarioModeloPuntajeOp = usuarioModeloPuntajeOpServicio.registrar(usuarioModeloPuntajeOpAux);
			}
		}
		// Respuesta
		ResponseGenerico<UsuarioModeloPuntajeOp> response = new ResponseGenerico<>();
		response.setObjeto(usuarioModeloPuntajeOp);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * REST para guardar o actualizar UsuarioModeloPuntajeOp
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarUsuarioModeloPuntajeOp")
	public ResponseGenerico<UsuarioModeloPuntajeOp> guardarUsuarioModeloPuntajeOp(@RequestBody UsuarioModeloPuntajeOp usuarioModeloPuntajeOp) {
		usuarioModeloPuntajeOp = usuarioModeloPuntajeOpServicio.registrar(usuarioModeloPuntajeOp);
		// Respuesta
		ResponseGenerico<UsuarioModeloPuntajeOp> response = new ResponseGenerico<>();
		response.setObjeto(usuarioModeloPuntajeOp);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarUsuarioModeloPuntajeOpPorId/{codigo}")
	public ResponseGenerico<UsuarioModeloPuntajeOp> eliminarUsuarioModeloPuntajeOpPorId(@PathVariable("codigo") Long codigo) {
		UsuarioModeloPuntajeOp usuarioModeloPuntajeOp = usuarioModeloPuntajeOpServicio.buscarUsuarioModeloPuntajeOpPorCodigo(codigo);
		usuarioModeloPuntajeOp.setEstado(EstadoEnum.INACTIVO.getDescripcion());
		usuarioModeloPuntajeOpServicio.registrar(usuarioModeloPuntajeOp);
		// Respuesta
		ResponseGenerico<UsuarioModeloPuntajeOp> response = new ResponseGenerico<>();
		response.setObjeto(usuarioModeloPuntajeOp);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
