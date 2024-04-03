package ec.gob.educacion.repositorio.catalogo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.modelo.catalogo.ModeloPuntajeOp;

@Repository
public interface ModeloPuntajeOpRepositorio extends JpaRepository<ModeloPuntajeOp, Long> {

	List<ModeloPuntajeOp> findByEstadoOrderByCodigo(String estado);

	ModeloPuntajeOp findByCodigo(Long codigo);
}
