package ec.gob.educacion.servicio.competencia;

import java.util.List;
import ec.gob.educacion.modelo.competencia.Integrante;

public interface IntegranteServicio {
	/**
	 * Permite listar Integrante
	 * 
	 * @param null
	 * @return lista Integrante
	 */
	List<Integrante> listarTodosIntegrante();

	/**
	 * Permite listar Integrante Activo
	 * 
	 * @param estado
	 * @return lista Integrante
	 */
	List<Integrante> listarIntegranteActivo(String estado);

	/**
	 * Permite listar Integrante Activo
	 * 
	 * @param estado
	 * @return lista Integrante
	 */
	List<Integrante> listarIntegrantePorParticipante(Long codParticipante);

	/**
	 * Permite obtener Integrante
	 * 
	 * @param codigo
	 * @return Integrante
	 */
	Integrante buscarIntegrantePorCodigo(Long codigo);

	/**
	 * Permite obtener Integrante
	 * 
	 * @param denominacion
	 * @return Integrante
	 */
	Integrante buscarIntegrantePorNombre(String nombre, Long codParticipante);

	/**
	 * Permite registrar Integrante
	 * 
	 * @param Integrante
	 * @return Integrante
	 */
	Integrante registrar(Integrante integrante);
	Integrante crearIntegrante(Integrante integrante);
	
}
