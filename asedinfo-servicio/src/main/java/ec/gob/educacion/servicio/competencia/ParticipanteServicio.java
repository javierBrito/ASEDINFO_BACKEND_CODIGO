package ec.gob.educacion.servicio.competencia;

import java.util.List;
import ec.gob.educacion.modelo.competencia.Participante;

public interface ParticipanteServicio {
	/**
	 * Permite listar Participante
	 * 
	 * @param null
	 * @return lista Participante
	 */
	List<Participante> listarTodosParticipante();

	/**
	 * Permite obtener Participante
	 * 
	 * @param codigo
	 * @return Participante
	 */
	Participante buscarParticipantePorCodigo(Long codigo);

	Integer obtenerMaxNumParticipante();

	/**
	 * Permite obtener lista Socio
	 * 
	 * @param codPersona
	 * @return listaParticipante
	 */
	List<Participante> listarParticipantePorPersona(Long codPersona);

	/**
	 * Permite listar Participante Activo
	 * 
	 * @param estado
	 * @return lista Participante
	 */
	List<Participante> listarParticipantePorSubcategoria(Long codSubcategoria);

	List<Participante> listarParticipanteUsuario();

	/**
	 * Permite listar Participante Activo
	 * 
	 * @param estado
	 * @return lista Participante
	 */
	List<Participante> listarParticipantePorSubcategoriaInstancia(Long codSubcategoria, Long codInstancia, Long codEstadoComptetencia);

	List<Participante> listarParticipantePorEstadoCompetencia(Long codEstadoComptetencia);

	/**
	 * Permite obtener lista Participante
	 * 
	 * @param codPersona
	 * @return listaParticipante
	 */
	List<Participante> listarParticipantePorEstado(String estadoPedido);

	/**
	 * Permite obtener lista Participante
	 * 
	 * @param email
	 * @return listaParticipante
	 */
	List<Participante> listarParticipantePorEmail(String email);

	/**
	 * Permite registrar Participante
	 * 
	 * @param ParticipanteWP
	 * @return Participante
	 */
	Participante registrar(Participante participante);

}
