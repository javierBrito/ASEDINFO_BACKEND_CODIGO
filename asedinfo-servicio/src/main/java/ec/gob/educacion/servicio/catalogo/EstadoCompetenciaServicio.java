package ec.gob.educacion.servicio.catalogo;

import java.util.List;
import ec.gob.educacion.modelo.catalogo.EstadoCompetencia;

public interface EstadoCompetenciaServicio {
	/**
	 * Permite listar EstadoCompetencia
	 * 
	 * @param null
	 * @return lista EstadoCompetencia
	 */
	List<EstadoCompetencia> listarTodosEstadoCompetencia();

	/**
	 * Permite listar EstadoCompetencia Activo
	 * 
	 * @param estado
	 * @return lista EstadoCompetencia
	 */
	List<EstadoCompetencia> listarEstadoCompetenciaActivo(String estado);

	/**
	 * Permite obtener EstadoCompetencia
	 * 
	 * @param codigo
	 * @return EstadoCompetencia
	 */
	EstadoCompetencia buscarEstadoCompetenciaPorCodigo(Long codigo);

	/**
	 * Permite registrar EstadoCompetencia
	 * 
	 * @param EstadoCompetencia
	 * @return EstadoCompetencia
	 */
	EstadoCompetencia registrar(EstadoCompetencia estadoCompetencia);
	EstadoCompetencia crearEstadoCompetencia(EstadoCompetencia estadoCompetencia);
	
}
