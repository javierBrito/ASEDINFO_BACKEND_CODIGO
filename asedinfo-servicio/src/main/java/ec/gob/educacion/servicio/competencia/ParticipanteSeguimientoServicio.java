package ec.gob.educacion.servicio.competencia;

import java.util.List;
import ec.gob.educacion.modelo.competencia.ParticipanteSeguimiento;

public interface ParticipanteSeguimientoServicio {
	/**
	 * Permite listar ParticipanteSeguimiento
	 * 
	 * @param null
	 * @return lista ParticipanteSeguimiento
	 */
	List<ParticipanteSeguimiento> listarTodosParticipanteSeguimiento();

	/**
	 * Permite listar ParticipanteSeguimiento Activo
	 * 
	 * @param estado
	 * @return lista ParticipanteSeguimiento
	 */
	List<ParticipanteSeguimiento> listarParticipanteSeguimientoActivo(String estado);

	/**
	 * Permite obtener ParticipanteSeguimiento
	 * 
	 * @param codigo
	 * @return ParticipanteSeguimiento
	 */
	ParticipanteSeguimiento buscarParticipanteSeguimientoPorCodigo(Long codigo);

	/**
	 * Permite obtener ParticipanteSeguimiento
	 * 
	 * @param codParticipante
	 * @return ParticipanteSeguimiento
	 */
	List<ParticipanteSeguimiento> listarParticipanteSeguimientoPorParticipante(Long codParticipante);

	/**
	 * Permite registrar ParticipanteSeguimiento
	 * 
	 * @param ParticipanteSeguimiento
	 * @return ParticipanteSeguimiento
	 */
	ParticipanteSeguimiento registrar(ParticipanteSeguimiento participanteSeguimiento);
	ParticipanteSeguimiento crearParticipanteSeguimiento(ParticipanteSeguimiento participanteSeguimiento);
	
}
