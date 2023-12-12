package ec.gob.educacion.servicio.impl.competencia;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.modelo.catalogo.EstadoCompetencia;
import ec.gob.educacion.modelo.catalogo.Instancia;
import ec.gob.educacion.modelo.catalogo.Persona;
import ec.gob.educacion.modelo.catalogo.Subcategoria;
import ec.gob.educacion.modelo.competencia.Participante;
import ec.gob.educacion.repositorio.competencia.ParticipanteRepositorio;
import ec.gob.educacion.servicio.catalogo.EstadoCompetenciaServicio;
import ec.gob.educacion.servicio.catalogo.InstanciaServicio;
import ec.gob.educacion.servicio.catalogo.PersonaServicio;
import ec.gob.educacion.servicio.catalogo.SubcategoriaServicio;
import ec.gob.educacion.servicio.competencia.ParticipanteServicio;

@Service
public class ParticipanteServicioImpl implements ParticipanteServicio {

	@Autowired
	private ParticipanteRepositorio participanteRepositorio;
	@Autowired
	private SubcategoriaServicio subcategoriaServicio;
	@Autowired
	private InstanciaServicio instanciaServicio;
	@Autowired
	private EstadoCompetenciaServicio estadoCompetenciaServicio;
	@Autowired
	private PersonaServicio personaServicio;
	
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
	public List<Participante> listarParticipantePorSubcategoria(Long codSubcategoria) {
		return participanteRepositorio.listarParticipantePorSubcategoria(codSubcategoria);
	}

	@Override
	public List<Participante> listarParticipantePorSubcategoriaInstancia(Long codSubcategoria, Long codInstancia) {
		return participanteRepositorio.listarParticipantePorSubcategoriaInstancia(codSubcategoria, codInstancia);
	}

	@Override
	public List<Participante> listarParticipantePorEstado(String estadoPedido) {
		return participanteRepositorio.listarParticipantePorEstado(estadoPedido);
	}

	@Override
	public Participante registrar(Participante participante) {
		if (participante.getCodSubcategoria() != 0) {
			Subcategoria subcategoria = subcategoriaServicio.buscarSubcategoriaPorCodigo(participante.getCodSubcategoria());
			participante.setSubcategoria(subcategoria);
		} 
		if (participante.getCodInstancia() != 0) {
			Instancia instancia = instanciaServicio.buscarInstanciaPorCodigo(participante.getCodInstancia());
			participante.setInstancia(instancia);
		}
		if (participante.getCodEstadoCompetencia() != 0) {
			EstadoCompetencia estadoCompetencia = estadoCompetenciaServicio.buscarEstadoCompetenciaPorCodigo(participante.getCodEstadoCompetencia());
			participante.setEstadoCompetencia(estadoCompetencia);
		} 
		if (participante.getCodPersona() != 0) {
			Persona persona = personaServicio.buscarPersonaPorCodigo(participante.getCodPersona());
			participante.setPersona(persona);
		} 
		return participanteRepositorio.save(participante);
	}
	
}
