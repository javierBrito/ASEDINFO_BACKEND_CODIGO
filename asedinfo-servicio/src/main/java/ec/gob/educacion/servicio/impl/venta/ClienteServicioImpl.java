package ec.gob.educacion.servicio.impl.venta;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.modelo.catalogo.Persona;
import ec.gob.educacion.modelo.venta.Cliente;
import ec.gob.educacion.modelo.venta.DataClientes;
import ec.gob.educacion.repositorio.venta.ClienteRepositorio;
import ec.gob.educacion.servicio.catalogo.PersonaServicio;
import ec.gob.educacion.servicio.venta.ClienteServicio;

@Service
public class ClienteServicioImpl implements ClienteServicio {

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	@Autowired
	private PersonaServicio personaServicio;
	
	@Override
	public List<Cliente> listarTodosCliente() {
		return clienteRepositorio.findAll();
	}

	@Override
	public List<Cliente> listarClienteActivo(String estado) {
		return clienteRepositorio.findByEstadoOrderByCodigo(estado);
	}

	@Override
	public List<Cliente> listarClienteActivoOrdenNombre() {
		return clienteRepositorio.listarClienteActivoOrdenNombre();
	}

	@Override
	public Cliente buscarClientePorCodigo(Long codigo) {
		return clienteRepositorio.findByCodigo(codigo);
	}

	@Override
	public List<Cliente> listarClientePorPersona(Long codPersona) {
		return clienteRepositorio.listarClientePorPersona(codPersona);
	}

	@Override
	public List<Cliente> listarClientePorPersonaIdentificacion(String identificacion) {
		return clienteRepositorio.listarClientePorPersonaIdentificacion(identificacion);
	}

	@Override
	public List<Cliente> listarClientePorPersonaNombre(String nombre) {
		return clienteRepositorio.listarClientePorPersonaNombre(nombre);
	}

	@Override
	public List<DataClientes> listarDataClientes() {
		List<DataClientes> listaDataClientes = new ArrayList<>();
		clienteRepositorio.listarDataClientes().forEach(objects -> {
			DataClientes dataClientes = new DataClientes();

			if (objects[0] != null && objects[0] != "") {
				dataClientes.setNombre(String.valueOf(objects[0]));
			}
			if (objects[1] != null && objects[1] != "") {
				dataClientes.setIdentificacion(String.valueOf(objects[1]));
			}
			if (objects[2] != null && objects[2] != "") {
				dataClientes.setCorreo(String.valueOf(objects[2]));
			}
			if (objects[3] != null && objects[3] != "") {
				dataClientes.setCelular(String.valueOf(objects[3]));
			}

			listaDataClientes.add(dataClientes);
		});

		return listaDataClientes;
	}

	@Override
	public Cliente registrar(Cliente cliente) {
		if (cliente.getCodPersona() != null && cliente.getCodPersona() != 0) {
			Persona persona = new Persona();
			persona = personaServicio.buscarPersonaPorCodigo(cliente.getCodPersona());
			if (persona != null) {
				cliente.setPersona(persona);
			}
		}

		return clienteRepositorio.save(cliente);
	}
	
}
