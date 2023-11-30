package ec.gob.educacion.servicio.impl.wordpress;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.modelo.wordpress.ClienteWP;
import ec.gob.educacion.repositorio.wordpress.ClienteWPRepositorio;
import ec.gob.educacion.servicio.wordpress.ClienteWPServicio;

@Service
public class ClienteWPServicioImpl implements ClienteWPServicio {

	@Autowired
	private ClienteWPRepositorio clienteWPRepositorio;
	
	@Override
	public List<ClienteWP> listarTodosClienteWP() {
		return clienteWPRepositorio.findAll();
	}

	@Override
	public ClienteWP buscarClienteWPPorCustomerId(Long customerId) {
		return clienteWPRepositorio.findByCustomerId(customerId);
	}

	@Override
	public List<ClienteWP> listarClienteWPPorEstado(String estadoPedido) {
		return clienteWPRepositorio.listarClienteWPPorEstado(estadoPedido);
	}

	@Override
	public ClienteWP registrar(ClienteWP ClienteWP) {
		/*
		if (ClienteWP.getCodPersona() != null && ClienteWP.getCodPersona() != 0) {
			Persona persona = new Persona();
			persona = personaServicio.buscarPersonaPorCodigo(ClienteWP.getCodPersona());
			if (persona != null) {
				ClienteWP.setPersona(persona);
			}
		}
		*/
		return clienteWPRepositorio.save(ClienteWP);
	}
	
}
