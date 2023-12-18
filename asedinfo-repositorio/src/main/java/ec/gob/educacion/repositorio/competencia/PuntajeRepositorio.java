package ec.gob.educacion.repositorio.competencia;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.modelo.competencia.Puntaje;

@Repository
public interface PuntajeRepositorio extends JpaRepository<Puntaje, Long> {

	List<Puntaje> findByEstadoOrderByCodigo(String estado);

	Puntaje findByCodigo(Long codigo);

	@Query(nativeQuery = false, value = "select r from Puntaje r where r.subcategoria.codigo = :codSubcategoria and  r.instancia.codigo = :codInstancia")
	List<Puntaje> listarPuntajePorSubcategoria(@Param("codSubcategoria") Long codSubcategoria, @Param("codInstancia") Long codInstancia);
	
	@Query(nativeQuery = false, value = "select r from Puntaje r where r.subcategoria.codigo = :codSubcategoria and r.instancia.codigo = :codInstancia and r.codUsuarioJuez = :codUsuarioJuez and r.modeloPuntaje.codigo = 99")
	List<Puntaje> listarPuntajePorSubcategoriaRegTotal(@Param("codSubcategoria") Long codSubcategoria, @Param("codInstancia") Long codInstancia, @Param("codUsuarioJuez") Long codUsuarioJuez);

	@Query(nativeQuery = false, value = "select r from Puntaje r where r.participante.codigo = :codParticipante and r.instancia.codigo = :codInstancia")
	List<Puntaje> listarPuntajePorParticipante(@Param("codParticipante") Long codParticipante, @Param("codInstancia") Long codInstancia);

	@Query(nativeQuery = false, value = "select r from Puntaje r where r.participante.codigo = :codParticipante and r.subcategoria.codigo = :codSubcategoria and r.instancia.codigo = :codInstancia and r.codUsuarioJuez = :codUsuarioJuez")
	List<Puntaje> listarPuntajePorParticipanteSubcategoriaInstancia(@Param("codParticipante") Long codParticipante, @Param("codSubcategoria") Long codSubcategoria, @Param("codInstancia") Long codInstancia, @Param("codUsuarioJuez") Long codUsuarioJuez);

	@Query(nativeQuery = false, value = "select r from Puntaje r where r.participante.codigo = :codParticipante and r.instancia.codigo = :codInstancia and r.codUsuarioJuez = :codUsuarioJuez and r.modeloPuntaje.codigo = :codModeloPuntaje")
	List<Puntaje> listarPuntajePorParticipanteRegTotal(@Param("codParticipante") Long codParticipante, @Param("codInstancia") Long codInstancia, @Param("codUsuarioJuez") Long codUsuarioJuez, @Param("codModeloPuntaje") Long codModeloPuntaje);

	@Query(nativeQuery = false, value = "select r.codigo as codigo, avg(r.puntaje) as puntaje, r.subcategoria.codigo as codSubcategoria, r.instancia.codigo as codInstancia, r.participante.codigo as codParticipante, r.estado, r.modeloPuntaje.codigo as codModeloPuntaje, r.codUsuarioJuez from Puntaje r where r.subcategoria.codigo = :codSubcategoria and r.instancia.codigo = :codInstancia and r.modeloPuntaje.codigo = 99 group by r.subcategoria.codigo, r.instancia.codigo, r.participante.codigo")
	List<Puntaje> listarPuntajePorSubcategoriaInstanciaRegAVG(@Param("codSubcategoria") Long codSubcategoria, @Param("codInstancia") Long codInstancia);
}
