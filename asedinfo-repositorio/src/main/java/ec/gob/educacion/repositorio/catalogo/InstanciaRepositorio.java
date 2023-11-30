package ec.gob.educacion.repositorio.catalogo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.modelo.catalogo.Instancia;

@Repository
public interface InstanciaRepositorio extends JpaRepository<Instancia, Long> {

	List<Instancia> findByEstadoOrderByCodigo(String estado);

	Instancia findByCodigo(Long codigo);
}
