package ec.gob.educacion.servicio.competencia;

import java.util.List;
import ec.gob.educacion.modelo.competencia.UsuarioModeloPuntaje;

public interface UsuarioModeloPuntajeServicio {
	/**
	 * Permite listar UsuarioModeloPuntaje
	 * 
	 * @param null
	 * @return lista UsuarioModeloPuntaje
	 */
	List<UsuarioModeloPuntaje> listarTodosUsuarioModeloPuntaje();

	/**
	 * Permite listar UsuarioModeloPuntaje Activo
	 * 
	 * @param estado
	 * @return lista UsuarioModeloPuntaje
	 */
	List<UsuarioModeloPuntaje> listarUsuarioModeloPuntajeActivo(String estado);

	/**
	 * Permite obtener UsuarioModeloPuntaje
	 * 
	 * @param codigo
	 * @return UsuarioModeloPuntaje
	 */
	UsuarioModeloPuntaje buscarUsuarioModeloPuntajePorCodigo(Long codigo);

	/**
	 * Permite obtener UsuarioModeloPuntaje
	 * 
	 * @param codUsuario
	 * @return UsuarioModeloPuntaje
	 */
	List<UsuarioModeloPuntaje> listarUsuarioModeloPuntajePorUsuario(Long codUsuario);

	/**
	 * Permite registrar UsuarioModeloPuntaje
	 * 
	 * @param UsuarioModeloPuntaje
	 * @return UsuarioModeloPuntaje
	 */
	UsuarioModeloPuntaje registrar(UsuarioModeloPuntaje usuarioModeloPuntaje);
	UsuarioModeloPuntaje crearUsuarioModeloPuntaje(UsuarioModeloPuntaje usuarioModeloPuntaje);
	
}
