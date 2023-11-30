package ec.gob.educacion.servicio.impl.wordpress;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.modelo.wordpress.Pedido;
import ec.gob.educacion.repositorio.wordpress.PedidoRepositorio;
import ec.gob.educacion.servicio.wordpress.PedidoServicio;

@Service
public class PedidoServicioImpl implements PedidoServicio {

	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Override
	public List<Pedido> listarTodosPedido() {
		return pedidoRepositorio.findAll();
	}

	@Override
	public List<Pedido> listarPedidoActivo(String status) {
		return pedidoRepositorio.findByStatusOrderByOrderId(status);
	}

	@Override
	public Pedido buscarPedidoPorOrderId(Long orderId) {
		return pedidoRepositorio.findByOrderId(orderId);
	}

	@Override
	public List<Pedido> listarPedidoPorCliente(Long customerId) {
		return pedidoRepositorio.listarPedidoPorCliente(customerId);
	}

	@Override
	public Pedido registrar(Pedido pedido) {
		/*
		if (Pedido.getCodPersona() != null && Pedido.getCodPersona() != 0) {
			Persona persona = new Persona();
			persona = personaServicio.buscarPersonaPorCodigo(Pedido.getCodPersona());
			if (persona != null) {
				Pedido.setPersona(persona);
			}
		}
		*/
		return pedidoRepositorio.save(pedido);
	}
	
}
