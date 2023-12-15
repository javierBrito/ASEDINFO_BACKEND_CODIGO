package ec.gob.educacion.repositorio.wordpress;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.modelo.wordpress.ClienteWP;
import ec.gob.educacion.modelo.wordpress.PedidoProducto;

@Repository
public interface ClienteWPRepositorio extends JpaRepository<ClienteWP, Long> {

	@Query(nativeQuery = false, value = "select ped.clienteWP from Pedido ped join ped.clienteWP cli join cli.user use where ped.status = 'wc-completed'")
	List<ClienteWP> migrarClienteWP();

	//@Query(nativeQuery = false, value = "select distinct(ped.clienteWP) from PedidoProducto pp join pp.pedido ped join pp.clienteWP cli join cli.user use join pp.productoWP pro where pro.postType = 'product' and ped.status = 'wc-completed'")
	@Query(nativeQuery = false, value = "select distinct(cli.customerId), use.Id as userId, cli.username, cli.firstName, cli.lastName, cli.dateLastActive, cli.dateRegistered, pp.postExcerpt as postExcerpt from PedidoProducto pp join pp.pedido ped join pp.clienteWP cli join cli.user use join pp.productoWP pro where pro.postType = 'product' and ped.status = 'wc-completed'")
	List<ClienteWP> migrarClienteWPCategoria();

	@Query(nativeQuery = false, value = "select pp from PedidoProducto pp join pp.pedido ped join ped.clienteWP cli join cli.user use join pp.productoWP pro where pro.postType = 'product' and ped.status = 'wc-completed'")
	List<PedidoProducto> migrarClienteWPedidoProducto();

	ClienteWP findByCustomerId(Long customerId);
}
