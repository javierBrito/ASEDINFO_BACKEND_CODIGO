package ec.gob.educacion.servicio.competencia;

import java.util.List;
import ec.gob.educacion.modelo.competencia.CuentaClave;

public interface CuentaClaveServicio {
	/**
	 * Permite listar CuentaClave
	 * 
	 * @param null
	 * @return lista CuentaClave
	 */
	List<CuentaClave> listarTodosCuentaClave();

	/**
	 * Permite listar CuentaClave Activo
	 * 
	 * @param estado
	 * @return lista CuentaClave
	 */
	List<CuentaClave> listarCuentaClaveActivo(String estado);

	/**
	 * Permite listar CuentaClave Activo
	 * 
	 * @param estado
	 * @return lista CuentaClave
	 */
	List<CuentaClave> listarCuentaClavePorTransaccion(Long codTransaccion);
	
	Integer eliminarCuentaClavePorCodTransaccion(Long codTransaccion);

	/**
	 * Permite obtener CuentaClave
	 * 
	 * @param codigo
	 * @return CuentaClave
	 */
	CuentaClave buscarCuentaClavePorCodigo(Long codigo);

	/**
	 * Permite obtener CuentaClave
	 * 
	 * @param denominacion
	 * @return CuentaClave
	 */
	CuentaClave buscarCuentaClavePorCuenta(String cuenta, Long codTransaccion);

	/**
	 * Permite registrar CuentaClave
	 * 
	 * @param CuentaClave
	 * @return CuentaClave
	 */
	CuentaClave registrar(CuentaClave cuentaClave);
	CuentaClave crearCuentaClave(CuentaClave cuentaClave);
	
}
