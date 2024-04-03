package ec.gob.educacion.servicio.catalogo;

import java.util.List;
import ec.gob.educacion.modelo.catalogo.ModeloPuntajeOp;

public interface ModeloPuntajeOpServicio {
	/**
	 * Permite listar ModeloPuntajeOp
	 * 
	 * @param null
	 * @return lista ModeloPuntajeOp
	 */
	List<ModeloPuntajeOp> listarTodosModeloPuntajeOp();

	/**
	 * Permite listar ModeloPuntajeOp Activo
	 * 
	 * @param estado
	 * @return lista ModeloPuntajeOp
	 */
	List<ModeloPuntajeOp> listarModeloPuntajeOpActivo(String estado);

	/**
	 * Permite obtener ModeloPuntajeOp
	 * 
	 * @param codigo
	 * @return ModeloPuntajeOp
	 */
	ModeloPuntajeOp buscarModeloPuntajeOpPorCodigo(Long codigo);

	/**
	 * Permite registrar ModeloPuntajeOp
	 * 
	 * @param ModeloPuntajeOp
	 * @return ModeloPuntajeOp
	 */
	ModeloPuntajeOp registrar(ModeloPuntajeOp modeloPuntajeOp);
	ModeloPuntajeOp crearModeloPuntajeOp(ModeloPuntajeOp modeloPuntajeOp);
	
}
