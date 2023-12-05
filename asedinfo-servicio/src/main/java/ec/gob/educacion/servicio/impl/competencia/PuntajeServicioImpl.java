package ec.gob.educacion.servicio.impl.competencia;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.modelo.competencia.Puntaje;
import ec.gob.educacion.repositorio.competencia.PuntajeRepositorio;
import ec.gob.educacion.servicio.competencia.PuntajeServicio;

@Service
public class PuntajeServicioImpl implements PuntajeServicio {

	@Autowired
	private PuntajeRepositorio puntajeRepositorio;

	@Override
	public List<Puntaje> listarTodosPuntaje() {
		return puntajeRepositorio.findAll();
	}

	@Override
	public List<Puntaje> listarPuntajeActivo(String estado) {
		return puntajeRepositorio.findByEstadoOrderByCodigo(estado);
	}

	@Override
	public List<Puntaje> listarPuntajePorSubcategoria(Long codSubcategoria, Long codInstancia) {
		return puntajeRepositorio.listarPuntajePorSubcategoria(codSubcategoria, codInstancia);
	}

	@Override
	public Puntaje buscarPuntajePorCodigo(Long codigo) {
		return puntajeRepositorio.findByCodigo(codigo);
	}

	@Override
	public Puntaje registrar(Puntaje puntaje) {
		return puntajeRepositorio.save(puntaje);
	}

	@Override
	public Puntaje crearPuntaje(Puntaje puntaje) {
		return puntajeRepositorio.save(puntaje);
	}
	
}
