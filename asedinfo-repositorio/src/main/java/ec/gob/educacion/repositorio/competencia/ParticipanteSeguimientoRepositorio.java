package ec.gob.educacion.repositorio.competencia;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.modelo.competencia.*;

@Repository
public interface ParticipanteSeguimientoRepositorio extends JpaRepository<ParticipanteSeguimiento, Long> {

	List<ParticipanteSeguimiento> findByEstadoOrderByCodigo(String estado);

	@Query(nativeQuery = false, value = "select i from ParticipanteSeguimiento i where i.codParticipante = :codParticipante and i.estado = 'A'")
	List<ParticipanteSeguimiento> listarParticipanteSeguimientoPorParticipante(@Param("codParticipante") Long codParticipante);

	ParticipanteSeguimiento findByCodigo(Long codigo);
}
