package ec.gob.educacion.servicio.impl.competencia;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.modelo.competencia.UsuarioModeloPuntaje;
import ec.gob.educacion.repositorio.competencia.UsuarioModeloPuntajeRepositorio;
import ec.gob.educacion.servicio.competencia.UsuarioModeloPuntajeServicio;

@Service
public class UsuarioModeloPuntajeServicioImpl implements UsuarioModeloPuntajeServicio {

	@Autowired
	private UsuarioModeloPuntajeRepositorio usuarioModeloPuntajeRepositorio;

	@Override
	public List<UsuarioModeloPuntaje> listarTodosUsuarioModeloPuntaje() {
		return usuarioModeloPuntajeRepositorio.findAll();
	}

	@Override
	public List<UsuarioModeloPuntaje> listarUsuarioModeloPuntajeActivo(String estado) {
		return usuarioModeloPuntajeRepositorio.findByEstadoOrderByCodigo(estado);
	}

	@Override
	public UsuarioModeloPuntaje buscarUsuarioModeloPuntajePorCodigo(Long codigo) {
		return usuarioModeloPuntajeRepositorio.findByCodigo(codigo);
	}

	@Override
	public List<UsuarioModeloPuntaje> listarUsuarioModeloPuntajePorUsuario(Long codUsuario) {
		return usuarioModeloPuntajeRepositorio.listarUsuarioModeloPuntajePorUsuario(codUsuario);
	}

	@Override
	public UsuarioModeloPuntaje registrar(UsuarioModeloPuntaje usuarioModeloPuntaje) {
		/*
		if (usuarioModeloPuntaje.getCodModeloPuntaje() != 0) {
			ModeloPuntaje modeloPuntaje = modeloPuntajeServicio.buscarModeloPuntajePorCodigo(usuarioModeloPuntaje.getCodModeloPuntaje());
			usuarioModeloPuntaje.setModeloPuntaje(modeloPuntaje);
		}
		if (usuarioModeloPuntaje.getCodUsuario() != 0) {
			Usuario usuario = usuarioServicio.buscarUsuarioPorCodigo(usuarioModeloPuntaje.getCodUsuario());
			usuarioModeloPuntaje.setUsuario(usuario);
		}
		*/
		return usuarioModeloPuntajeRepositorio.save(usuarioModeloPuntaje);
	}

	@Override
	public UsuarioModeloPuntaje crearUsuarioModeloPuntaje(UsuarioModeloPuntaje usuarioModeloPuntaje) {
		/*
		if (usuarioModeloPuntaje.getCodModeloPuntaje() != 0) {
			ModeloPuntaje modeloPuntaje = modeloPuntajeServicio.buscarModeloPuntajePorCodigo(usuarioModeloPuntaje.getCodModeloPuntaje());
			usuarioModeloPuntaje.setModeloPuntaje(modeloPuntaje);
		}
		if (usuarioModeloPuntaje.getCodUsuario() != 0) {
			Usuario usuario = usuarioServicio.buscarUsuarioPorCodigo(usuarioModeloPuntaje.getCodUsuario());
			usuarioModeloPuntaje.setUsuario(usuario);
		}
		*/
		return usuarioModeloPuntajeRepositorio.save(usuarioModeloPuntaje);
	}
	
}
