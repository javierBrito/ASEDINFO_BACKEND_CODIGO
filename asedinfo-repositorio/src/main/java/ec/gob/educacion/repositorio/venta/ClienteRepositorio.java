package ec.gob.educacion.repositorio.venta;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.modelo.venta.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
	
	List<Cliente> findByEstadoOrderByCodigo(String estado);

	@Query(nativeQuery = false, value = "select r from Cliente r where r.estado = 'A' order by r.persona.nombres")
	List<Cliente> listarClienteActivoOrdenNombre();

	@Query(nativeQuery = false, value = "select r from Cliente r where r.persona.codigo = :codPersona and r.estado = 'A'")
	List<Cliente> listarClientePorPersona(@Param("codPersona") Long codPersona);

	@Query(nativeQuery = false, value = "select r from Cliente r where r.persona.nombres like %:nombre% and r.estado = 'A'")
	List<Cliente> listarClientePorPersonaIdentificacion(@Param("nombre") String nombre);

	@Query(nativeQuery = false, value = "select r from Cliente r where r.persona.identificacion = :identificacion and r.estado = 'A'")
	List<Cliente> listarClientePorPersonaNombre(@Param("identificacion") String identificacion);

	//@Query(nativeQuery = false, value = "select r from DataClientes")
	//List<DataClientes> listarDataClientes();

	@Query(nativeQuery = true, value = 
			  " select nombre, identificacion, correo, celular "
			+ "   from data_clientes where identificacion <> '' " ) 
	List<Object[]> listarDataClientes();;

	Cliente findByCodigo(Long codigo);
}
