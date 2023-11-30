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
import ec.gob.educacion.modelo.catalogo.Categoria;
import ec.gob.educacion.venta.resources.EstadoEnum;
import ec.gob.educacion.servicio.catalogo.CategoriaServicio;

@RestController
@RequestMapping("catalogo/")
public class CategoriaControlador {

	@Autowired
	private CategoriaServicio categoriaServicio;

	@GetMapping(value = "listarTodosCategoria")
	public ResponseGenerico<Categoria> listarTodosCategoria() {
		List<Categoria> listaCategoria = categoriaServicio.listarTodosCategoria();
		// Respuesta
		ResponseGenerico<Categoria> response = new ResponseGenerico<>();
		response.setListado(listaCategoria);
		response.setTotalRegistros((long) listaCategoria.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarCategoriaActivo")
	public ResponseGenerico<Categoria> listarCategoriaActivo() {
		List<Categoria> listaCategoria = categoriaServicio.listarCategoriaActivo(EstadoEnum.ACTIVO.getDescripcion());
		// Respuesta
		ResponseGenerico<Categoria> response = new ResponseGenerico<>();
		response.setListado(listaCategoria);
		response.setTotalRegistros((long) listaCategoria.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener Categoria
	 * 
	 * @return Categoria
	 */
	@GetMapping(value = "buscarCategoriaPorCodigo/{codigo}")
	public ResponseGenerico<Categoria> buscarCategoriaPorCodigo(@PathVariable("codigo") Long codigo) {
		Categoria categoria = categoriaServicio.buscarCategoriaPorCodigo(codigo);
		// Respuesta
		ResponseGenerico<Categoria> response = new ResponseGenerico<>();
		response.setObjeto(categoria);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar Categoria
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarCategoria")
	public ResponseGenerico<Categoria> guardarCategoria(@RequestBody Categoria categoria) {
		categoria = categoriaServicio.registrar(categoria);
		// Respuesta
		ResponseGenerico<Categoria> response = new ResponseGenerico<>();
		response.setObjeto(categoria);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarCategoriaPorId/{codigo}")
	public ResponseGenerico<Categoria> eliminarCategoria(@PathVariable("codigo") Long codigo) {
		Categoria categoria = categoriaServicio.buscarCategoriaPorCodigo(codigo);
		categoria.setEstado(EstadoEnum.INACTIVO.getDescripcion());
		categoriaServicio.registrar(categoria);
		// Respuesta
		ResponseGenerico<Categoria> response = new ResponseGenerico<>();
		response.setObjeto(categoria);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
