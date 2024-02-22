package ec.gob.educacion.servicio.impl.wordpress;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.modelo.DTO.UsuarioWPDTO;
import ec.gob.educacion.modelo.wordpress.ClienteWP;
import ec.gob.educacion.modelo.wordpress.PedidoProducto;
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
	public List<ClienteWP> migrarClienteWP() {
		return clienteWPRepositorio.migrarClienteWP();
	}

	@Override
	public List<ClienteWP> migrarClienteWPCategoria() {
		return clienteWPRepositorio.migrarClienteWPCategoria();
	}

	@Override
	public List<UsuarioWPDTO> migrarUsuarioWP() {
		return clienteWPRepositorio.migrarUsuarioWP();
	}

	@Override
	public List<PedidoProducto> migrarClienteWPedidoProducto() {
		return clienteWPRepositorio.migrarClienteWPedidoProducto();
	}

	@Override
	public ClienteWP registrar(ClienteWP ClienteWP) {
		return clienteWPRepositorio.save(ClienteWP);
	}
	
}
