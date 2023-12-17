package ec.gob.educacion.servicio.impl.catalogo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.modelo.catalogo.Categoria;
import ec.gob.educacion.modelo.catalogo.Subcategoria;
import ec.gob.educacion.repositorio.catalogo.SubcategoriaRepositorio;
import ec.gob.educacion.servicio.catalogo.CategoriaServicio;
import ec.gob.educacion.servicio.catalogo.SubcategoriaServicio;

@Service
public class SubcategoriaServicioImpl implements SubcategoriaServicio {

	@Autowired
	private SubcategoriaRepositorio subcategoriaRepositorio;
	@Autowired
	private CategoriaServicio categoriaServicio;

	@Override
	public List<Subcategoria> listarTodosSubcategoria() {
		return subcategoriaRepositorio.findAll();
	}

	@Override
	public List<Subcategoria> listarSubcategoriaPorCategoria(Long codCategoria) {
		return subcategoriaRepositorio.listarSubcategoriaPorCategoria(codCategoria);
	}

	@Override
	public List<Subcategoria> listarSubcategoriaActivo(String estado) {
		return subcategoriaRepositorio.findByEstadoOrderByCodigo(estado);
	}

	@Override
	public Subcategoria buscarSubcategoriaPorCodigo(Long codigo) {
		return subcategoriaRepositorio.findByCodigo(codigo);
	}

	@Override
	public Subcategoria buscarSubcategoriaPorDenominacion(String denominacion, Long codCategoria) {
		return subcategoriaRepositorio.buscarSubcategoriaPorDenominacion(denominacion, codCategoria);
	}

	@Override
	public Subcategoria registrar(Subcategoria subcategoria) {
		if (subcategoria.getCodCategoria() != 0) {
			Categoria categoria = categoriaServicio.buscarCategoriaPorCodigo(subcategoria.getCodCategoria());
			subcategoria.setCategoria(categoria);
		}
		return subcategoriaRepositorio.save(subcategoria);
	}

	@Override
	public Subcategoria crearSubcategoria(Subcategoria subcategoria) {
		if (subcategoria.getCodCategoria() != 0) {
			Categoria categoria = categoriaServicio.buscarCategoriaPorCodigo(subcategoria.getCodCategoria());
			subcategoria.setCategoria(categoria);
		}
		return subcategoriaRepositorio.save(subcategoria);
	}
	
}
