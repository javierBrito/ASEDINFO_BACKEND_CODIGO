package ec.gob.educacion.controlador.venta;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.gob.educacion.controlador.util.Constantes;
import ec.gob.educacion.modelo.catalogo.Persona;
import ec.gob.educacion.modelo.response.ResponseGenerico;
import ec.gob.educacion.modelo.venta.Cliente;
import ec.gob.educacion.modelo.venta.DataClientes;
import ec.gob.educacion.servicio.catalogo.PersonaServicio;
import ec.gob.educacion.servicio.venta.ClienteServicio;
import ec.gob.educacion.venta.resources.EstadoEnum;

@RestController
@RequestMapping("venta/")
public class ClienteControlador {

	@Autowired
	private ClienteServicio clienteServicio;
	@Autowired
	private PersonaServicio personaServicio;

	@GetMapping(value = "listarTodosCliente")
	public ResponseGenerico<Cliente> listarTodosCliente() {
		List<Cliente> listaCliente = clienteServicio.listarTodosCliente();
		// Respuesta
		ResponseGenerico<Cliente> response = new ResponseGenerico<>();
		response.setListado(listaCliente);
		response.setTotalRegistros((long) listaCliente.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarClienteActivo")
	public ResponseGenerico<Cliente> listarClienteActivo() {
		List<Cliente> listaCliente = clienteServicio.listarClienteActivo(EstadoEnum.ACTIVO.getDescripcion());
		// Respuesta
		ResponseGenerico<Cliente> response = new ResponseGenerico<>();
		response.setListado(listaCliente);
		response.setTotalRegistros((long) listaCliente.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarClienteActivoOrdenNombre")
	public ResponseGenerico<Cliente> listarClienteActivoOrdenNombre() {
		List<Cliente> listaCliente = clienteServicio.listarClienteActivoOrdenNombre();
		// Respuesta
		ResponseGenerico<Cliente> response = new ResponseGenerico<>();
		response.setListado(listaCliente);
		response.setTotalRegistros((long) listaCliente.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarClientePorPersona/{codPersona}")
	public ResponseGenerico<Cliente> listarClientePorPersona(@PathVariable("codPersona") Long codPersona) {
		List<Cliente> listaCliente = clienteServicio.listarClientePorPersona(codPersona);
		// Respuesta
		ResponseGenerico<Cliente> response = new ResponseGenerico<>();
		response.setListado(listaCliente);
		response.setTotalRegistros((long) listaCliente.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarClientePorPersonaIdentificacion/{identificacion}")
	public ResponseGenerico<Cliente> listarClientePorPersonaIdentificacion(@PathVariable("identificacion") String identificacion) {
		List<Cliente> listaCliente = clienteServicio.listarClientePorPersonaIdentificacion(identificacion);
		// Respuesta
		ResponseGenerico<Cliente> response = new ResponseGenerico<>();
		response.setListado(listaCliente);
		response.setTotalRegistros((long) listaCliente.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarClientePorPersonaNombre/{nombre}")
	public ResponseGenerico<Cliente> listarClientePorPersonaNombre(@PathVariable("nombre") String nombre) {
		List<Cliente> listaCliente = clienteServicio.listarClientePorPersonaNombre(nombre);
		// Respuesta
		ResponseGenerico<Cliente> response = new ResponseGenerico<>();
		response.setListado(listaCliente);
		response.setTotalRegistros((long) listaCliente.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener Socio
	 * 
	 * @return Socio
	 */
	@GetMapping(value = "buscarClientePorCodigo/{codigo}")
	public ResponseGenerico<Cliente> buscarClientePorCodigo(@PathVariable("codigo") Long codigo) {
		Cliente cliente = clienteServicio.buscarClientePorCodigo(codigo);
		// Respuesta
		ResponseGenerico<Cliente> response = new ResponseGenerico<>();
		response.setObjeto(cliente);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar cliente
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarCliente")
	public ResponseGenerico<Cliente> guardarCliente(@RequestBody Cliente cliente) {
		cliente = clienteServicio.registrar(cliente);
		// Respuesta
		ResponseGenerico<Cliente> response = new ResponseGenerico<>();
		response.setObjeto(cliente);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarClientePorId/{codigo}")
	public ResponseGenerico<Cliente> eliminarCliente(@PathVariable("codigo") Long codigo) {
		Cliente cliente = clienteServicio.buscarClientePorCodigo(codigo);
		cliente.setEstado(EstadoEnum.INACTIVO.getDescripcion());
		clienteServicio.registrar(cliente);
		// Respuesta
		ResponseGenerico<Cliente> response = new ResponseGenerico<>();
		response.setObjeto(cliente);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}

	@GetMapping(value = "migrarCliente")
	public ResponseGenerico<DataClientes> migrarCliente() {
		List<DataClientes> listaDataClientes = clienteServicio.listarDataClientes();
		if (listaDataClientes.size() > 0) {
			for (DataClientes dataClientes : listaDataClientes) {
				// Mover datos desde DataClientes a Persona
				Persona persona = new Persona();
				// Verificar si ya existe Persona
				List<Persona> listaPersona = personaServicio.buscarPorIdentificacion(dataClientes.getIdentificacion());
				if (listaPersona.size() > 0) {
					persona = listaPersona.get(0);
				}
				// Registro nuevo
				persona.setIdentificacion(dataClientes.getIdentificacion());
				if (dataClientes.getNombre().indexOf(" ") == -1) {
					persona.setNombres(dataClientes.getNombre().toUpperCase());
					persona.setApellidos(dataClientes.getNombre().toUpperCase());
				} else {
					persona.setNombres(dataClientes.getNombre().substring(0, dataClientes.getNombre().indexOf(" ")).toUpperCase());
					persona.setApellidos(dataClientes.getNombre().substring(dataClientes.getNombre().indexOf(" ")+1).toUpperCase());
				}
				persona.setCorreo(dataClientes.getCorreo());
				persona.setCelular(dataClientes.getCelular());
				persona.setEstado("A");
				// Guardar la Persona
				persona = personaServicio.registrar(persona);
				
				// Mover datos desde DataClientes a Cliente
				Cliente cliente = new Cliente();
				// Verificar si ya existe Cliente
				List<Cliente> listaCliente = clienteServicio.listarClientePorPersona(persona.getCodigo());
				if (listaCliente.size() > 0) {
					cliente = listaCliente.get(0);
				}
				// Datos por default al migrar
				cliente.setFechaInicio(new Date());
				cliente.setTipoCliente("REGULAR");;
				cliente.setEstado("A");;
				// Datos de la persona relacionada
				cliente.setCodPersona(persona.getCodigo());
				cliente.setPersona(persona);
				
				// Guardar el registro
				clienteServicio.registrar(cliente);
			}
		}
		// Respuesta
		ResponseGenerico<DataClientes> response = new ResponseGenerico<>();
		response.setListado(listaDataClientes);
		response.setTotalRegistros((long) listaDataClientes.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
}
