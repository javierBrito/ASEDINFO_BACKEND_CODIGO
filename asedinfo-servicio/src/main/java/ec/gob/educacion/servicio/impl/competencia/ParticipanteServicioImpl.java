package ec.gob.educacion.servicio.impl.competencia;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.modelo.competencia.Participante;
import ec.gob.educacion.repositorio.competencia.ParticipanteRepositorio;
import ec.gob.educacion.servicio.competencia.ParticipanteServicio;

@Service
public class ParticipanteServicioImpl implements ParticipanteServicio {

	@Autowired
	private ParticipanteRepositorio participanteRepositorio;
	
	@Override
	public List<Participante> listarTodosParticipante() {
		return participanteRepositorio.findAll();
	}

	@Override
	public Participante buscarParticipantePorCodigo(Long codigo) {
		return participanteRepositorio.findByCodigo(codigo);
	}

	@Override
	public List<Participante> listarParticipantePorPersona(Long codPersona) {
		return participanteRepositorio.listarParticipantePorPersona(codPersona);
	}

	@Override
	public List<Participante> listarParticipantePorEstado(String estadoPedido) {
		return participanteRepositorio.listarParticipantePorEstado(estadoPedido);
	}

	@Override
	public Participante registrar(Participante participante) {
		System.out.println("participante.getCustomerId() Rep = "+participante.getCustomerId());
		return participanteRepositorio.save(participante);
	}
	
}
