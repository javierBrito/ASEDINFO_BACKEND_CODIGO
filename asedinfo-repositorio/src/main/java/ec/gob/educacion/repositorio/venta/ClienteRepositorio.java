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

	@Query(nativeQuery = false, value = "select r from Cliente r where r.persona.codigo = :codPersona and r.estado = 'A'")
	List<Cliente> listarClientePorPersona(@Param("codPersona") Long codPersona);

	@Query(nativeQuery = false, value = "select r from Cliente r where r.persona.identificacion = :identificacion and r.estado = 'A'")
	List<Cliente> listarClientePorPersonaIdentificacion(@Param("identificacion") String identificacion);

	Cliente findByCodigo(Long codigo);
}
