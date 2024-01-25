package ec.gob.educacion.servicio.impl.catalogo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.modelo.DTO.PrefijoTelefonicoDTO;
import ec.gob.educacion.modelo.catalogo.Persona;
import ec.gob.educacion.repositorio.catalogo.PersonaRepositorio;
import ec.gob.educacion.servicio.catalogo.PersonaServicio;
import ec.gob.educacion.venta.resources.Constantes;

@Service
public class PersonaServicioImpl implements PersonaServicio {

	@Autowired
	private PersonaRepositorio personaRepositorio;

	@Override
	public List<Persona> listarTodosPersona() {
		return personaRepositorio.findAll();
	}

	@Override
	public List<Persona> listarPersonaActivo(String estado) {
		return personaRepositorio.findByEstadoOrderByCodigo(estado);
	}

	@Override
	public Persona buscarPersonaPorCodigo(Long codigo) {
		return personaRepositorio.findByCodigo(codigo);
	}

	@Override
	public List<Persona> listarPersonaPorIdentificacion(String identificacion) {
		return personaRepositorio.findByIdentificacion(identificacion);
	}

	@Override
	public List<Persona> buscarPorIdentificacion(String identificacion) {
		return personaRepositorio.findByIdentificacionAndEstado(identificacion, Constantes.REGISTRO_ACTIVO);
	}

	@Override
	public Persona registrar(Persona persona) {
		return personaRepositorio.save(persona);
	}

	@Override
	public Persona crearPersona(Persona persona) {
		return personaRepositorio.save(persona);
	}
	

	@Override
	public List<PrefijoTelefonicoDTO> listarPrefijoTelefonico() {
		List<PrefijoTelefonicoDTO> listaPrefijoTelefonicoDTO = new ArrayList<>();
		personaRepositorio.listarPrefijoTelefonico().forEach(objects -> {
			PrefijoTelefonicoDTO prefijoTelefonicoDTO = new PrefijoTelefonicoDTO();

			if (objects[0] != null && objects[0] != "") {
				prefijoTelefonicoDTO.setNombrePais(String.valueOf(objects[0]));
			}
			if (objects[1] != null && objects[1] != "") {
				prefijoTelefonicoDTO.setCodigo(String.valueOf(objects[1]));
			}

			listaPrefijoTelefonicoDTO.add(prefijoTelefonicoDTO);
		});

		return listaPrefijoTelefonicoDTO;
	}
	
}
