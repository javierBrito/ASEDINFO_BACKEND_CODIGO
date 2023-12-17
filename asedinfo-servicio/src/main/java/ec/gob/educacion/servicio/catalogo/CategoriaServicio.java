package ec.gob.educacion.servicio.catalogo;

import java.util.List;
import ec.gob.educacion.modelo.catalogo.Categoria;

public interface CategoriaServicio {
	/**
	 * Permite listar Categoria
	 * 
	 * @param null
	 * @return lista Categoria
	 */
	List<Categoria> listarTodosCategoria();

	/**
	 * Permite listar Categoria Activo
	 * 
	 * @param estado
	 * @return lista Categoria
	 */
	List<Categoria> listarCategoriaActivo(String estado);

	/**
	 * Permite obtener Categoria
	 * 
	 * @param codigo
	 * @return Categoria
	 */
	Categoria buscarCategoriaPorCodigo(Long codigo);

	/**
	 * Permite obtener Categoria
	 * 
	 * @param denominacion
	 * @return Categoria
	 */
	Categoria buscarCategoriaPorDenominacion(String denominacion);

	/**
	 * Permite registrar Categoria
	 * 
	 * @param Categoria
	 * @return Categoria
	 */
	Categoria registrar(Categoria categoria);
	Categoria crearCategoria(Categoria categoria);
	
}
