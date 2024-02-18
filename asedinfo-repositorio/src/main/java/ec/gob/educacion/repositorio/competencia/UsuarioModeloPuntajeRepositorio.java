package ec.gob.educacion.repositorio.competencia;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.modelo.competencia.*;

@Repository
public interface UsuarioModeloPuntajeRepositorio extends JpaRepository<UsuarioModeloPuntaje, Long> {

	List<UsuarioModeloPuntaje> findByEstadoOrderByCodigo(String estado);

	@Query(nativeQuery = false, value = "select i from UsuarioModeloPuntaje i where i.usuario.codigo = :codUsuario and i.estado = 'A'")
	UsuarioModeloPuntaje listarUsuarioModeloPuntajePorUsuario(@Param("codUsuario") Long codUsuario);

	UsuarioModeloPuntaje findByCodigo(Long codigo);
}
