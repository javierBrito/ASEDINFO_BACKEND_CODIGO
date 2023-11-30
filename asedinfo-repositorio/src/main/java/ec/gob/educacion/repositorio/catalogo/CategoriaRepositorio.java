package ec.gob.educacion.repositorio.catalogo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.modelo.catalogo.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

	List<Categoria> findByEstadoOrderByCodigo(String estado);

	Categoria findByCodigo(Long codigo);
}
