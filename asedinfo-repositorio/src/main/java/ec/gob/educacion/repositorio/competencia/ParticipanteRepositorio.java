package ec.gob.educacion.repositorio.competencia;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.modelo.competencia.Participante;

@Repository
public interface ParticipanteRepositorio extends JpaRepository<Participante, Long> {

	@Query(nativeQuery = false, value = "select par from Participante par")
	List<Participante> listarParticipantePorEstado(@Param("estadoPedido") String estadoPedido);

	@Query(nativeQuery = false, value = "select r from Participante r where r.persona.codigo = :codPersona")
	List<Participante> listarParticipantePorPersona(@Param("codPersona") Long codPersona);

	Participante findByCodigo(Long codigo);
}
