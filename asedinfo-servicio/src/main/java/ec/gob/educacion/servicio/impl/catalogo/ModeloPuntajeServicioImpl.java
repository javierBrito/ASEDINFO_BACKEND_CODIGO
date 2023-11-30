package ec.gob.educacion.servicio.impl.catalogo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.modelo.catalogo.ModeloPuntaje;
import ec.gob.educacion.repositorio.catalogo.ModeloPuntajeRepositorio;
import ec.gob.educacion.servicio.catalogo.ModeloPuntajeServicio;

@Service
public class ModeloPuntajeServicioImpl implements ModeloPuntajeServicio {

	@Autowired
	private ModeloPuntajeRepositorio ModeloPuntajeRepositorio;

	@Override
	public List<ModeloPuntaje> listarTodosModeloPuntaje() {
		return ModeloPuntajeRepositorio.findAll();
	}

	@Override
	public List<ModeloPuntaje> listarModeloPuntajeActivo(String estado) {
		return ModeloPuntajeRepositorio.findByEstadoOrderByCodigo(estado);
	}

	@Override
	public ModeloPuntaje buscarModeloPuntajePorCodigo(Long codigo) {
		return ModeloPuntajeRepositorio.findByCodigo(codigo);
	}

	@Override
	public ModeloPuntaje registrar(ModeloPuntaje modeloPuntaje) {
		return ModeloPuntajeRepositorio.save(modeloPuntaje);
	}

	@Override
	public ModeloPuntaje crearModeloPuntaje(ModeloPuntaje modeloPuntaje) {
		return ModeloPuntajeRepositorio.save(modeloPuntaje);
	}
	
}
