package ec.gob.educacion.servicio.competencia;

import java.util.List;
import ec.gob.educacion.modelo.competencia.UsuarioModeloPuntajeOp;

public interface UsuarioModeloPuntajeOpServicio {
	/**
	 * Permite listar UsuarioModeloPuntajeOp
	 * 
	 * @param null
	 * @return lista UsuarioModeloPuntajeOp
	 */
	List<UsuarioModeloPuntajeOp> listarTodosUsuarioModeloPuntajeOp();

	/**
	 * Permite listar UsuarioModeloPuntajeOp Activo
	 * 
	 * @param estado
	 * @return lista UsuarioModeloPuntajeOp
	 */
	List<UsuarioModeloPuntajeOp> listarUsuarioModeloPuntajeOpActivo(String estado);

	/**
	 * Permite obtener UsuarioModeloPuntajeOp
	 * 
	 * @param codigo
	 * @return UsuarioModeloPuntajeOp
	 */
	UsuarioModeloPuntajeOp buscarUsuarioModeloPuntajeOpPorCodigo(Long codigo);

	/**
	 * Permite obtener UsuarioModeloPuntajeOp
	 * 
	 * @param codUsuario
	 * @return UsuarioModeloPuntajeOp
	 */
	List<UsuarioModeloPuntajeOp> listarUsuarioModeloPuntajeOpPorUsuario(Long codUsuario);

	/**
	 * Permite registrar UsuarioModeloPuntajeOp
	 * 
	 * @param UsuarioModeloPuntajeOp
	 * @return UsuarioModeloPuntajeOp
	 */
	UsuarioModeloPuntajeOp registrar(UsuarioModeloPuntajeOp usuarioModeloPuntajeOp);
	UsuarioModeloPuntajeOp crearUsuarioModeloPuntajeOp(UsuarioModeloPuntajeOp usuarioModeloPuntajeOp);
	
}
