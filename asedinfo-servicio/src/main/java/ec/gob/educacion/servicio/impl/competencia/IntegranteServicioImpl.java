package ec.gob.educacion.servicio.impl.competencia;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.modelo.competencia.Participante;
import ec.gob.educacion.modelo.competencia.Integrante;
import ec.gob.educacion.repositorio.competencia.IntegranteRepositorio;
import ec.gob.educacion.servicio.competencia.ParticipanteServicio;
import ec.gob.educacion.servicio.competencia.IntegranteServicio;

@Service
public class IntegranteServicioImpl implements IntegranteServicio {

	@Autowired
	private IntegranteRepositorio integranteRepositorio;
	@Autowired
	private ParticipanteServicio participanteServicio;

	@Override
	public List<Integrante> listarTodosIntegrante() {
		return integranteRepositorio.findAll();
	}

	@Override
	public List<Integrante> listarIntegrantePorParticipante(Long codParticipante) {
		return integranteRepositorio.listarIntegrantePorParticipante(codParticipante);
	}

	@Override
	public List<Integrante> listarIntegranteActivo(String estado) {
		return integranteRepositorio.findByEstadoOrderByCodigo(estado);
	}

	@Override
	public Integrante buscarIntegrantePorCodigo(Long codigo) {
		return integranteRepositorio.findByCodigo(codigo);
	}

	@Override
	public Integrante buscarIntegrantePorNombre(String nombre, Long codParticipante) {
		return integranteRepositorio.buscarIntegrantePorNombre(nombre, codParticipante);
	}

	@Override
	public Integrante registrar(Integrante integrante) {
		if (integrante.getCodParticipante() != 0) {
			Participante participante = participanteServicio.buscarParticipantePorCodigo(integrante.getCodParticipante());
			integrante.setParticipante(participante);
		}
		return integranteRepositorio.save(integrante);
	}

	@Override
	public Integrante crearIntegrante(Integrante integrante) {
		if (integrante.getCodParticipante() != 0) {
			Participante participante = participanteServicio.buscarParticipantePorCodigo(integrante.getCodParticipante());
			integrante.setParticipante(participante);
		}
		return integranteRepositorio.save(integrante);
	}
	
}
