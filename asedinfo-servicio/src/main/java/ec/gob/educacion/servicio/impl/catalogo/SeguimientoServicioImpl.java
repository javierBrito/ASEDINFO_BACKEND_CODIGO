package ec.gob.educacion.servicio.impl.catalogo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.modelo.catalogo.Seguimiento;
import ec.gob.educacion.repositorio.catalogo.SeguimientoRepositorio;
import ec.gob.educacion.servicio.catalogo.SeguimientoServicio;

@Service
public class SeguimientoServicioImpl implements SeguimientoServicio {

	@Autowired
	private SeguimientoRepositorio seguimientoRepositorio;

	@Override
	public List<Seguimiento> listarTodosSeguimiento() {
		return seguimientoRepositorio.findAll();
	}

	@Override
	public List<Seguimiento> listarSeguimientoActivo(String estado) {
		return seguimientoRepositorio.findByEstadoOrderByCodigo(estado);
	}

	@Override
	public Seguimiento buscarSeguimientoPorCodigo(Long codigo) {
		return seguimientoRepositorio.findByCodigo(codigo);
	}

	@Override
	public Seguimiento registrar(Seguimiento seguimiento) {
		return seguimientoRepositorio.save(seguimiento);
	}

	@Override
	public Seguimiento crearSeguimiento(Seguimiento seguimiento) {
		return seguimientoRepositorio.save(seguimiento);
	}
	
}
