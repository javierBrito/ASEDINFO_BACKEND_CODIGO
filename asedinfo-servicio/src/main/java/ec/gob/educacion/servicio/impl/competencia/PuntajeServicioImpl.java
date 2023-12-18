package ec.gob.educacion.servicio.impl.competencia;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.modelo.catalogo.Instancia;
import ec.gob.educacion.modelo.catalogo.ModeloPuntaje;
import ec.gob.educacion.modelo.catalogo.Subcategoria;
import ec.gob.educacion.modelo.competencia.Participante;
import ec.gob.educacion.modelo.competencia.Puntaje;
import ec.gob.educacion.repositorio.competencia.PuntajeRepositorio;
import ec.gob.educacion.servicio.catalogo.InstanciaServicio;
import ec.gob.educacion.servicio.catalogo.ModeloPuntajeServicio;
import ec.gob.educacion.servicio.catalogo.SubcategoriaServicio;
import ec.gob.educacion.servicio.competencia.ParticipanteServicio;
import ec.gob.educacion.servicio.competencia.PuntajeServicio;

@Service
public class PuntajeServicioImpl implements PuntajeServicio {

	@Autowired
	private PuntajeRepositorio puntajeRepositorio;
	@Autowired
	private ModeloPuntajeServicio modeloPuntajeServicio;
	@Autowired
	private InstanciaServicio instanciaServicio;
	@Autowired
	private ParticipanteServicio participanteServicio;
	@Autowired
	private SubcategoriaServicio subcategoriaServicio;

	@Override
	public List<Puntaje> listarTodosPuntaje() {
		return puntajeRepositorio.findAll();
	}

	@Override
	public List<Puntaje> listarPuntajeActivo(String estado) {
		return puntajeRepositorio.findByEstadoOrderByCodigo(estado);
	}

	@Override
	public List<Puntaje> listarPuntajePorSubcategoria(Long codSubcategoria, Long codInstancia) {
		return puntajeRepositorio.listarPuntajePorSubcategoria(codSubcategoria, codInstancia);
	}

	@Override
	public List<Puntaje> listarPuntajePorSubcategoriaRegTotal(Long codSubcategoria, Long codInstancia, Long codUsuarioJuez) {
		return puntajeRepositorio.listarPuntajePorSubcategoriaRegTotal(codSubcategoria, codInstancia, codUsuarioJuez);
	}
	
	@Override
	public List<Puntaje> listarPuntajePorParticipanteSubcategoriaInstancia(Long codParticipante, Long codSubcategoria, Long codInstancia, Long codUsuarioJuez) {
		return puntajeRepositorio.listarPuntajePorParticipanteSubcategoriaInstancia(codParticipante, codSubcategoria, codInstancia, codUsuarioJuez);
	}
	@Override
	public List<Puntaje> listarPuntajePorParticipanteRegTotal(Long codParticipante, Long codInstancia, Long codUsuarioJuez, Long codModeloPuntaje) {
		return puntajeRepositorio.listarPuntajePorParticipanteRegTotal(codParticipante, codInstancia, codUsuarioJuez, codModeloPuntaje);
	}
	@Override
	public List<Puntaje> listarPuntajePorSubcategoriaInstanciaRegAVG(Long codSubcategoria, Long codInstancia) {
		return puntajeRepositorio.listarPuntajePorSubcategoriaInstanciaRegAVG(codSubcategoria, codInstancia);
	}
	@Override
	public Puntaje buscarPuntajePorCodigo(Long codigo) {
		return puntajeRepositorio.findByCodigo(codigo);
	}

	@Override
	public Puntaje registrar(Puntaje puntaje) {
		if (puntaje.getCodModeloPuntaje() != 0) {
			ModeloPuntaje modeloPuntaje = modeloPuntajeServicio.buscarModeloPuntajePorCodigo(puntaje.getCodModeloPuntaje());
			puntaje.setModeloPuntaje(modeloPuntaje);
		}
		if (puntaje.getCodInstancia() != 0) {
			Instancia instancia = instanciaServicio.buscarInstanciaPorCodigo(puntaje.getCodInstancia());
			puntaje.setInstancia(instancia);
		}
		if (puntaje.getCodParticipante() != 0) {
			Participante participante = participanteServicio.buscarParticipantePorCodigo(puntaje.getCodParticipante());
			puntaje.setParticipante(participante);
		} 
		if (puntaje.getCodSubcategoria() != 0) {
			Subcategoria subcategoria = subcategoriaServicio.buscarSubcategoriaPorCodigo(puntaje.getCodSubcategoria());
			puntaje.setSubcategoria(subcategoria);
		}
		System.out.println("puntaje.getCodUsuarioJuez() = "+puntaje.getCodUsuarioJuez());
		/*
		if (puntaje.getCodUsuarioJuez() != 0) {
			Usuario usuario = usuarioServicio.buscarUsuarioPorCodigo(puntaje.getCodUsuarioJuez());
			System.out.println("usuario = "+usuario);
			System.out.println("usuario.getCodigo() = "+usuario.getCodigo());
			puntaje.setUsuarioJuez(usuario);
		}
		*/
		return puntajeRepositorio.save(puntaje);
	}

	@Override
	public Puntaje crearPuntaje(Puntaje puntaje) {
		return puntajeRepositorio.save(puntaje);
	}
	
}
