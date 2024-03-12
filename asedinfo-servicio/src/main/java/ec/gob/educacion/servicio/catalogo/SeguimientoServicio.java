package ec.gob.educacion.servicio.catalogo;

import java.util.List;
import ec.gob.educacion.modelo.catalogo.Seguimiento;

public interface SeguimientoServicio {
	/**
	 * Permite listar Seguimiento
	 * 
	 * @param null
	 * @return lista Seguimiento
	 */
	List<Seguimiento> listarTodosSeguimiento();

	/**
	 * Permite listar Seguimiento Activo
	 * 
	 * @param estado
	 * @return lista Seguimiento
	 */
	List<Seguimiento> listarSeguimientoActivo(String estado);

	/**
	 * Permite obtener Seguimiento
	 * 
	 * @param codigo
	 * @return Seguimiento
	 */
	Seguimiento buscarSeguimientoPorCodigo(Long codigo);

	/**
	 * Permite registrar Seguimiento
	 * 
	 * @param Seguimiento
	 * @return Seguimiento
	 */
	Seguimiento registrar(Seguimiento seguimiento);
	Seguimiento crearSeguimiento(Seguimiento seguimiento);
	
}
