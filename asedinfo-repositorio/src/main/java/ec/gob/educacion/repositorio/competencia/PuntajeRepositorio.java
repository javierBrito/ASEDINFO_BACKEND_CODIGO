package ec.gob.educacion.repositorio.competencia;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.modelo.competencia.Puntaje;

@Repository
public interface PuntajeRepositorio extends JpaRepository<Puntaje, Long> {

	List<Puntaje> findByEstadoOrderByCodigo(String estado);

	Puntaje findByCodigo(Long codigo);
}
