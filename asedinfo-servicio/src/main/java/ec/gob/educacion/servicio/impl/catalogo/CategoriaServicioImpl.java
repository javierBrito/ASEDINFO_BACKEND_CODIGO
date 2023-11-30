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
	private CategoriaRepositorio CategoriaRepositorio;

	@Override
	public List<Categoria> listarTodosCategoria() {
		return CategoriaRepositorio.findAll();
	}

	@Override
	public List<Categoria> listarCategoriaActivo(String estado) {
		return CategoriaRepositorio.findByEstadoOrderByCodigo(estado);
	}

	@Override
	public Categoria buscarCategoriaPorCodigo(Long codigo) {
		return CategoriaRepositorio.findByCodigo(codigo);
	}

	@Override
	public Categoria registrar(Categoria categoria) {
		return CategoriaRepositorio.save(categoria);
	}

	@Override
	public Categoria crearCategoria(Categoria categoria) {
		return CategoriaRepositorio.save(categoria);
	}
	
}
