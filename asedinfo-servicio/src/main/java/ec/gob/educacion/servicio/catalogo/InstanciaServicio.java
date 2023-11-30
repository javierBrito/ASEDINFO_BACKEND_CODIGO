package ec.gob.educacion.servicio.catalogo;

import java.util.List;
import ec.gob.educacion.modelo.catalogo.Instancia;

public interface InstanciaServicio {
	/**
	 * Permite listar Instancia
	 * 
	 * @param null
	 * @return lista Instancia
	 */
	List<Instancia> listarTodosInstancia();

	/**
	 * Permite listar Instancia Activo
	 * 
	 * @param estado
	 * @return lista Instancia
	 */
	List<Instancia> listarInstanciaActivo(String estado);

	/**
	 * Permite obtener Instancia
	 * 
	 * @param codigo
	 * @return Instancia
	 */
	Instancia buscarInstanciaPorCodigo(Long codigo);

	/**
	 * Permite registrar Instancia
	 * 
	 * @param Instancia
	 * @return Instancia
	 */
	Instancia registrar(Instancia instancia);
	Instancia crearInstancia(Instancia instancia);
	
}
