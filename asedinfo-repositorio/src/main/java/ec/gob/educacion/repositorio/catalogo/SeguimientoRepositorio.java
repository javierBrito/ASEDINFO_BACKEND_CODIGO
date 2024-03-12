package ec.gob.educacion.repositorio.catalogo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.modelo.catalogo.Seguimiento;

@Repository
public interface SeguimientoRepositorio extends JpaRepository<Seguimiento, Long> {

	List<Seguimiento> findByEstadoOrderByCodigo(String estado);

	Seguimiento findByCodigo(Long codigo);
}
