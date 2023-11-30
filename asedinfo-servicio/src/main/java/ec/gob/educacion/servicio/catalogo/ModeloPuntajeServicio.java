package ec.gob.educacion.servicio.catalogo;

import java.util.List;
import ec.gob.educacion.modelo.catalogo.ModeloPuntaje;

public interface ModeloPuntajeServicio {
	/**
	 * Permite listar ModeloPuntaje
	 * 
	 * @param null
	 * @return lista ModeloPuntaje
	 */
	List<ModeloPuntaje> listarTodosModeloPuntaje();

	/**
	 * Permite listar ModeloPuntaje Activo
	 * 
	 * @param estado
	 * @return lista ModeloPuntaje
	 */
	List<ModeloPuntaje> listarModeloPuntajeActivo(String estado);

	/**
	 * Permite obtener ModeloPuntaje
	 * 
	 * @param codigo
	 * @return ModeloPuntaje
	 */
	ModeloPuntaje buscarModeloPuntajePorCodigo(Long codigo);

	/**
	 * Permite registrar ModeloPuntaje
	 * 
	 * @param ModeloPuntaje
	 * @return ModeloPuntaje
	 */
	ModeloPuntaje registrar(ModeloPuntaje modeloPuntaje);
	ModeloPuntaje crearModeloPuntaje(ModeloPuntaje modeloPuntaje);
	
}
