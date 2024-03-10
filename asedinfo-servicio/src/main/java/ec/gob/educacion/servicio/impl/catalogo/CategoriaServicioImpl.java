package ec.gob.educacion.servicio.impl.catalogo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.modelo.catalogo.Categoria;
import ec.gob.educacion.repositorio.catalogo.CategoriaRepositorio;
import ec.gob.educacion.servicio.catalogo.CategoriaServicio;

@Service
public class CategoriaServicioImpl implements CategoriaServicio {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	@Override
	public List<Categoria> listarTodosCategoria() {
		return categoriaRepositorio.findAll();
	}

	@Override
	public List<Categoria> listarCategoriaActivo(String estado) {
		return categoriaRepositorio.findByEstadoOrderByCodigo(estado);
	}

	@Override
	public Categoria buscarCategoriaPorCodigo(Long codigo) {
		return categoriaRepositorio.findByCodigo(codigo);
	}

	@Override
	public Categoria buscarCategoriaPorDenominacion(String denominacion) {
		return categoriaRepositorio.findByDenominacion(denominacion);
	}

	@Override
	public Categoria registrar(Categoria categoria) {
		return categoriaRepositorio.save(categoria);
	}

	@Override
	public Categoria crearCategoria(Categoria categoria) {
		return categoriaRepositorio.save(categoria);
	}
	
}
