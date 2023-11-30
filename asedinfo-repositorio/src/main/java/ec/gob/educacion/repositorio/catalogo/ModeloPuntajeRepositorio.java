package ec.gob.educacion.repositorio.catalogo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.modelo.catalogo.ModeloPuntaje;

@Repository
public interface ModeloPuntajeRepositorio extends JpaRepository<ModeloPuntaje, Long> {

	List<ModeloPuntaje> findByEstadoOrderByCodigo(String estado);

	ModeloPuntaje findByCodigo(Long codigo);
}
