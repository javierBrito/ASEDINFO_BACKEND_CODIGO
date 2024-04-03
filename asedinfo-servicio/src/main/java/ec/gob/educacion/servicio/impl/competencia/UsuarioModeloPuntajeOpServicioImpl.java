package ec.gob.educacion.servicio.impl.competencia;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.modelo.competencia.UsuarioModeloPuntajeOp;
import ec.gob.educacion.repositorio.competencia.UsuarioModeloPuntajeOpRepositorio;
import ec.gob.educacion.servicio.competencia.UsuarioModeloPuntajeOpServicio;

@Service
public class UsuarioModeloPuntajeOpServicioImpl implements UsuarioModeloPuntajeOpServicio {

	@Autowired
	private UsuarioModeloPuntajeOpRepositorio usuarioModeloPuntajeOpRepositorio;

	@Override
	public List<UsuarioModeloPuntajeOp> listarTodosUsuarioModeloPuntajeOp() {
		return usuarioModeloPuntajeOpRepositorio.findAll();
	}

	@Override
	public List<UsuarioModeloPuntajeOp> listarUsuarioModeloPuntajeOpActivo(String estado) {
		return usuarioModeloPuntajeOpRepositorio.findByEstadoOrderByCodigo(estado);
	}

	@Override
	public UsuarioModeloPuntajeOp buscarUsuarioModeloPuntajeOpPorCodigo(Long codigo) {
		return usuarioModeloPuntajeOpRepositorio.findByCodigo(codigo);
	}

	@Override
	public List<UsuarioModeloPuntajeOp> listarUsuarioModeloPuntajeOpPorUsuario(Long codUsuario) {
		return usuarioModeloPuntajeOpRepositorio.listarUsuarioModeloPuntajeOpPorUsuario(codUsuario);
	}

	@Override
	public UsuarioModeloPuntajeOp registrar(UsuarioModeloPuntajeOp usuarioModeloPuntajeOp) {
		/*
		if (usuarioModeloPuntajeOp.getCodModeloPuntajeOp() != 0) {
			ModeloPuntajeOp modeloPuntajeOp = modeloPuntajeOpServicio.buscarModeloPuntajeOpPorCodigo(usuarioModeloPuntajeOp.getCodModeloPuntajeOp());
			usuarioModeloPuntajeOp.setModeloPuntajeOp(modeloPuntajeOp);
		}
		if (usuarioModeloPuntajeOp.getCodUsuario() != 0) {
			Usuario usuario = usuarioServicio.buscarUsuarioPorCodigo(usuarioModeloPuntajeOp.getCodUsuario());
			usuarioModeloPuntajeOp.setUsuario(usuario);
		}
		*/
		return usuarioModeloPuntajeOpRepositorio.save(usuarioModeloPuntajeOp);
	}

	@Override
	public UsuarioModeloPuntajeOp crearUsuarioModeloPuntajeOp(UsuarioModeloPuntajeOp usuarioModeloPuntajeOp) {
		/*
		if (usuarioModeloPuntajeOp.getCodModeloPuntajeOp() != 0) {
			ModeloPuntajeOp modeloPuntajeOp = modeloPuntajeOpServicio.buscarModeloPuntajeOpPorCodigo(usuarioModeloPuntajeOp.getCodModeloPuntajeOp());
			usuarioModeloPuntajeOp.setModeloPuntajeOp(modeloPuntajeOp);
		}
		if (usuarioModeloPuntajeOp.getCodUsuario() != 0) {
			Usuario usuario = usuarioServicio.buscarUsuarioPorCodigo(usuarioModeloPuntajeOp.getCodUsuario());
			usuarioModeloPuntajeOp.setUsuario(usuario);
		}
		*/
		return usuarioModeloPuntajeOpRepositorio.save(usuarioModeloPuntajeOp);
	}
	
}
