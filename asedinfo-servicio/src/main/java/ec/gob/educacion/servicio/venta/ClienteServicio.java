package ec.gob.educacion.servicio.venta;

import java.util.List;

import ec.gob.educacion.modelo.venta.Cliente;
import ec.gob.educacion.modelo.venta.DataClientes;

public interface ClienteServicio {
	/**
	 * Permite listar Socio
	 * 
	 * @param null
	 * @return lista Socio
	 */
	List<Cliente> listarTodosCliente();

	/**
	 * Permite listar Socio Activo
	 * 
	 * @param estado
	 * @return lista Socio
	 */
	List<Cliente> listarClienteActivo(String estado);

	/**
	 * Permite listar Socio Activo
	 * 
	 * @param estado
	 * @return lista Socio
	 */
	List<Cliente> listarClienteActivoOrdenNombre();

	/**
	 * Permite obtener Socio
	 * 
	 * @param codigo
	 * @return Socio
	 */
	Cliente buscarClientePorCodigo(Long codigo);

	/**
	 * Permite obtener lista Socio
	 * 
	 * @param codPersona
	 * @return listaCliente
	 */
	List<Cliente> listarClientePorPersona(Long codPersona);

	/**
	 * Permite obtener lista Cliente
	 * 
	 * @param identificacion
	 * @return listaCliente
	 */

	List<Cliente> listarClientePorPersonaIdentificacion(String identificacion);

	/**
	 * Permite obtener lista Cliente
	 * 
	 * @param nombre
	 * @return listaCliente
	 */
	List<Cliente> listarClientePorPersonaNombre(String nombre);

	List<DataClientes> listarDataClientes();

	/**
	 * Permite registrar Socio
	 * 
	 * @param Socio
	 * @return Socio
	 */
	Cliente registrar(Cliente Cliente);

}
