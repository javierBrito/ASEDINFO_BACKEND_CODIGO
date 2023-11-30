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

	/**
	 * Permite obtener lista Participante
	 * 
	 * @param codPersona
	 * @return listaParticipante
	 */
	List<Participante> listarParticipantePorEstado(String estadoPedido);

	/**
	 * Permite registrar Participante
	 * 
	 * @param ClienteWP
	 * @return Participante
	 */
	Participante registrar(Participante participante);

}
