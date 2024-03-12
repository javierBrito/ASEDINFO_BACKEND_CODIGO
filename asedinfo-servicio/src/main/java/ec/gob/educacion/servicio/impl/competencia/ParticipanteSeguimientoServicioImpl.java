package ec.gob.educacion.servicio.impl.competencia;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.modelo.competencia.ParticipanteSeguimiento;
import ec.gob.educacion.repositorio.competencia.ParticipanteSeguimientoRepositorio;
import ec.gob.educacion.servicio.competencia.ParticipanteSeguimientoServicio;

@Service
public class ParticipanteSeguimientoServicioImpl implements ParticipanteSeguimientoServicio {

	@Autowired
	private ParticipanteSeguimientoRepositorio participanteSeguimientoRepositorio;

	@Override
	public List<ParticipanteSeguimiento> listarTodosParticipanteSeguimiento() {
		return participanteSeguimientoRepositorio.findAll();
	}

	@Override
	public List<ParticipanteSeguimiento> listarParticipanteSeguimientoActivo(String estado) {
		return participanteSeguimientoRepositorio.findByEstadoOrderByCodigo(estado);
	}

	@Override
	public ParticipanteSeguimiento buscarParticipanteSeguimientoPorCodigo(Long codigo) {
		return participanteSeguimientoRepositorio.findByCodigo(codigo);
	}

	@Override
	public List<ParticipanteSeguimiento> listarParticipanteSeguimientoPorParticipante(Long codParticipante) {
		return participanteSeguimientoRepositorio.listarParticipanteSeguimientoPorParticipante(codParticipante);
	}

	@Override
	public ParticipanteSeguimiento registrar(ParticipanteSeguimiento participanteSeguimiento) {
		/*
		if (participanteSeguimiento.getCodModeloPuntaje() != 0) {
			ModeloPuntaje modeloPuntaje = modeloPuntajeServicio.buscarModeloPuntajePorCodigo(participanteSeguimiento.getCodModeloPuntaje());
			participanteSeguimiento.setModeloPuntaje(modeloPuntaje);
		}
		if (participanteSeguimiento.getCodParticipante() != 0) {
			Participante usuario = usuarioServicio.buscarParticipantePorCodigo(participanteSeguimiento.getCodParticipante());
			participanteSeguimiento.setParticipante(usuario);
		}
		*/
		return participanteSeguimientoRepositorio.save(participanteSeguimiento);
	}

	@Override
	public ParticipanteSeguimiento crearParticipanteSeguimiento(ParticipanteSeguimiento participanteSeguimiento) {
		/*
		if (participanteSeguimiento.getCodModeloPuntaje() != 0) {
			ModeloPuntaje modeloPuntaje = modeloPuntajeServicio.buscarModeloPuntajePorCodigo(participanteSeguimiento.getCodModeloPuntaje());
			participanteSeguimiento.setModeloPuntaje(modeloPuntaje);
		}
		if (participanteSeguimiento.getCodParticipante() != 0) {
			Participante usuario = usuarioServicio.buscarParticipantePorCodigo(participanteSeguimiento.getCodParticipante());
			participanteSeguimiento.setParticipante(usuario);
		}
		*/
		return participanteSeguimientoRepositorio.save(participanteSeguimiento);
	}
	
}
