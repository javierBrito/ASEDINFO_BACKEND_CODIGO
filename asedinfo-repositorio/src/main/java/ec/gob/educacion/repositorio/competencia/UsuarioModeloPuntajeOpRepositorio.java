package ec.gob.educacion.repositorio.competencia;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.modelo.competencia.*;

@Repository
public interface UsuarioModeloPuntajeOpRepositorio extends JpaRepository<UsuarioModeloPuntajeOp, Long> {

	List<UsuarioModeloPuntajeOp> findByEstadoOrderByCodigo(String estado);

	@Query(nativeQuery = false, value = "select i from UsuarioModeloPuntajeOp i where i.codUsuario = :codUsuario and i.estado = 'A'")
	List<UsuarioModeloPuntajeOp> listarUsuarioModeloPuntajeOpPorUsuario(@Param("codUsuario") Long codUsuario);

	UsuarioModeloPuntajeOp findByCodigo(Long codigo);
}
