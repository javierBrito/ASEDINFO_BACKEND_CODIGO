package ec.gob.educacion.repositorio.wordpress;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.modelo.wordpress.ClienteWP;

@Repository
public interface ClienteWPRepositorio extends JpaRepository<ClienteWP, Long> {

	@Query(nativeQuery = false, value = "select ped.clienteWP from Pedido ped join ped.clienteWP cli join cli.user use where ped.status = 'wc-completed'")
	List<ClienteWP> migrarClienteWP();

	@Query(nativeQuery = false, value = "select ped.clienteWP from PedidoProducto pp join pp.pedido ped join ped.clienteWP cli join cli.user use join pp.productoWP pro where pro.postType = 'product' and ped.status = 'wc-completed'")
	List<ClienteWP> migrarClienteWPCategoria();

	ClienteWP findByCustomerId(Long customerId);
}
