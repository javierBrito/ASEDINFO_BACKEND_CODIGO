package ec.gob.educacion.servicio.competencia;

import java.util.List;
import ec.gob.educacion.modelo.competencia.Puntaje;

public interface PuntajeServicio {
	/**
	 * Permite listar Puntaje
	 * 
	 * @param null
	 * @return lista Puntaje
	 */
	List<Puntaje> listarTodosPuntaje();

	/**
	 * Permite listar Puntaje Activo
	 * 
	 * @param estado
	 * @return lista Puntaje
	 */
	List<Puntaje> listarPuntajeActivo(String estado);

	/**
	 * Permite listar Puntaje Activo
	 * 
	 * @param estado
	 * @return lista Puntaje
	 */
	List<Puntaje> listarPuntajePorSubcategoria(Long codSubcategoria, Long codInstancia);

	/**
	 * Permite obtener Puntaje
	 * 
	 * @param codigo
	 * @return Puntaje
	 */
	Puntaje buscarPuntajePorCodigo(Long codigo);

	/**
	 * Permite registrar Puntaje
	 * 
	 * @param Puntaje
	 * @return Puntaje
	 */
	Puntaje registrar(Puntaje puntaje);
	Puntaje crearPuntaje(Puntaje puntaje);
	
}
