package ec.gob.educacion.servicio.impl.catalogo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.modelo.catalogo.Subcategoria;
import ec.gob.educacion.repositorio.catalogo.SubcategoriaRepositorio;
import ec.gob.educacion.servicio.catalogo.SubcategoriaServicio;

@Service
public class SubcategoriaServicioImpl implements SubcategoriaServicio {

	@Autowired
	private SubcategoriaRepositorio SubcategoriaRepositorio;

	@Override
	public List<Subcategoria> listarTodosSubcategoria() {
		return SubcategoriaRepositorio.findAll();
	}

	@Override
	public List<Subcategoria> listarSubcategoriaPorCategoria(Long codCategoria) {
		return SubcategoriaRepositorio.listarSubcategoriaPorCategoria(codCategoria);
	}

	@Override
	public List<Subcategoria> listarSubcategoriaActivo(String estado) {
		return SubcategoriaRepositorio.findByEstadoOrderByCodigo(estado);
	}

	@Override
	public Subcategoria buscarSubcategoriaPorCodigo(Long codigo) {
		return SubcategoriaRepositorio.findByCodigo(codigo);
	}

	@Override
	public Subcategoria registrar(Subcategoria subcategoria) {
		return SubcategoriaRepositorio.save(subcategoria);
	}

	@Override
	public Subcategoria crearSubcategoria(Subcategoria subcategoria) {
		return SubcategoriaRepositorio.save(subcategoria);
	}
	
}
