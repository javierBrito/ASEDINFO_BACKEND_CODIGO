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
	private PuntajeRepositorio PuntajeRepositorio;

	@Override
	public List<Puntaje> listarTodosPuntaje() {
		return PuntajeRepositorio.findAll();
	}

	@Override
	public List<Puntaje> listarPuntajeActivo(String estado) {
		return PuntajeRepositorio.findByEstadoOrderByCodigo(estado);
	}

	@Override
	public Puntaje buscarPuntajePorCodigo(Long codigo) {
		return PuntajeRepositorio.findByCodigo(codigo);
	}

	@Override
	public Puntaje registrar(Puntaje puntaje) {
		return PuntajeRepositorio.save(puntaje);
	}

	@Override
	public Puntaje crearPuntaje(Puntaje puntaje) {
		return PuntajeRepositorio.save(puntaje);
	}
	
}
