package ec.gob.educacion.repositorio.competencia;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.modelo.competencia.Participante;

@Repository
public interface ParticipanteRepositorio extends JpaRepository<Participante, Long> {

	@Query(nativeQuery = false, value = "select par from Participante par where par.persona.estado = 'A' order by par.numParticipante, par.email, par.subcategoria.categoria.codigo, par.subcategoria.codigo")
	List<Participante> listarParticipantePorEstado(@Param("estadoPedido") String estadoPedido);

	@Query(nativeQuery = false, value = "select r from Participante r where r.persona.codigo = :codPersona")
	List<Participante> listarParticipantePorPersona(@Param("codPersona") Long codPersona);

	@Query(nativeQuery = false, value = "select r from Participante r where r.subcategoria.codigo = :codSubcategoria")
	List<Participante> listarParticipantePorSubcategoria(@Param("codSubcategoria") Long codSubcategoria);

	@Query(nativeQuery = false, value = "select r from Participante r join r.persona where r.persona.codigo = (select u.persona.codigo from Usuario u where u.persona.codigo = r.persona.codigo)")
	List<Participante> listarParticipanteUsuario();

	@Query(nativeQuery = false, value = "select r from Participante r where r.subcategoria.codigo = :codSubcategoria and r.instancia.codigo = :codInstancia and r.persona.estado = 'A'")
	List<Participante> listarParticipantePorSubcategoriaInstancia(@Param("codSubcategoria") Long codSubcategoria, @Param("codInstancia") Long codInstancia);

	@Query(nativeQuery = false, value = "select r from Participante r where r.subcategoria.codigo = :codSubcategoria and r.instancia.codigo = :codInstancia and r.estadoCompetencia.codigo = :codEstadoCompetencia")
	List<Participante> listarParticipantePorSubcategoriaInstanciaEnEscenario(@Param("codSubcategoria") Long codSubcategoria, @Param("codInstancia") Long codInstancia, @Param("codEstadoCompetencia") Long codEstadoCompetencia);

	@Query(nativeQuery = false, value = "select r from Participante r where r.estadoCompetencia.codigo = :codEstadoCompetencia")
	List<Participante> listarParticipantePorEstadoCompetencia(@Param("codEstadoCompetencia") Long codEstadoCompetencia);

	@Query(nativeQuery = false, value = "select par from Participante par where par.email = :email and par.estadoCompetencia.codigo = 1 and par.persona.estado = 'A' order by par.numParticipante, par.email, par.subcategoria.categoria.codigo, par.subcategoria.codigo")
	List<Participante> listarParticipantePorEmail(@Param("email") String email);

	@Query(nativeQuery = false, value = "select max(r.numParticipante) from Participante r")
	Integer obtenerMaxNumParticipante();

	Participante findByCodigo(Long codigo);
}
