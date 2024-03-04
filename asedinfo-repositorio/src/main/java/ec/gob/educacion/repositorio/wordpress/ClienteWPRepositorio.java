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
	@Query(nativeQuery = false, value = "select distinct(pp.clienteWP) from PedidoProducto pp join pp.pedido ped join pp.clienteWP cli join cli.user use join pp.productoWP pro where pro.postType = 'product' and ped.status = 'wc-completed'")
	List<ClienteWP> migrarClienteWPCategoria();

	@Query(nativeQuery = false, value = "select distinct(pp) from PedidoProducto pp join pp.pedido ped join ped.clienteWP cli join cli.user use join pp.productoWP pro where pro.postType = 'product' and ped.status = 'wc-completed' and pro.postExcerpt <> ''")
	List<PedidoProducto> migrarClienteWPedidoProducto();

	@Query(nativeQuery = true, value = 
			  " select distinct (us.user_email) as email, us.user_login as username, us.user_registered as dateLastActive, "
			+ "        (select um1.meta_value from dsm2vxjUGBhZGj.wp_usermeta um1 where um1.meta_key='first_name' and um1.user_id=us.ID) as firstName, " 
			+ "        (select um1.meta_value from dsm2vxjUGBhZGj.wp_usermeta um1 where um1.meta_key='last_name' and um1.user_id=us.ID) as lastName " 
			+ "   from dsm2vxjUGBhZGj.wp_users us, dsm2vxjUGBhZGj.wp_usermeta um "
			+ "  where us.ID = um.user_id " 
			+ "    and um.meta_key='wp_user_level' and um.meta_value='0' " ) 
	List<Object[]> listarUsuarioWP();

	ClienteWP findByCustomerId(Long customerId);
}
