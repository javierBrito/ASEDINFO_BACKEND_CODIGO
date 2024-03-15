package ec.gob.educacion.controlador.competencia;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.gob.educacion.controlador.util.Constantes;
import ec.gob.educacion.modelo.response.ResponseGenerico;
import ec.gob.educacion.modelo.competencia.CuentaClave;
import ec.gob.educacion.venta.resources.EstadoEnum;
import ec.gob.educacion.servicio.competencia.CuentaClaveServicio;

@RestController
@RequestMapping("competencia/")
public class CuentaClaveControlador {

	@Autowired
	private CuentaClaveServicio cuentaClaveServicio;

	@GetMapping(value = "listarTodosCuentaClave")
	public ResponseGenerico<CuentaClave> listarTodosCuentaClave() {
		List<CuentaClave> listaCuentaClave = cuentaClaveServicio.listarTodosCuentaClave();
		// Respuesta
		ResponseGenerico<CuentaClave> response = new ResponseGenerico<>();
		response.setListado(listaCuentaClave);
		response.setTotalRegistros((long) listaCuentaClave.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarCuentaClaveActivo")
	public ResponseGenerico<CuentaClave> listarCuentaClaveActivo() {
		List<CuentaClave> listaCuentaClave = cuentaClaveServicio.listarCuentaClaveActivo(EstadoEnum.ACTIVO.getDescripcion());
		// Respuesta
		ResponseGenerico<CuentaClave> response = new ResponseGenerico<>();
		response.setListado(listaCuentaClave);
		response.setTotalRegistros((long) listaCuentaClave.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarCuentaClavePorTransaccion/{codTransaccion}")
	public ResponseGenerico<CuentaClave> listarCuentaClavePorTransaccion(@PathVariable("codTransaccion") Long codTransaccion) {
		List<CuentaClave> listaCuentaClave = cuentaClaveServicio.listarCuentaClavePorTransaccion(codTransaccion);
		// Respuesta
		ResponseGenerico<CuentaClave> response = new ResponseGenerico<>();
		response.setListado(listaCuentaClave);
		response.setTotalRegistros((long) listaCuentaClave.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener CuentaClave
	 * 
	 * @return CuentaClave
	 */
	@GetMapping(value = "buscarCuentaClavePorCodigo/{codigo}")
	public ResponseGenerico<CuentaClave> buscarCuentaClavePorCodigo(@PathVariable("codigo") Long codigo) {
		CuentaClave CuentaClave = cuentaClaveServicio.buscarCuentaClavePorCodigo(codigo);
		// Respuesta
		ResponseGenerico<CuentaClave> response = new ResponseGenerico<>();
		response.setObjeto(CuentaClave);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener Transaccion
	 * 
	 * @return Transaccion
	 */
	@GetMapping(value = "buscarCuentaClavePorCuenta/{cuenta}/{codTransaccion}")
	public ResponseGenerico<CuentaClave> buscarTransaccionPorCuenta(@PathVariable("cuenta") String cuenta, @PathVariable("codTransaccion") Long codTransaccion) {
		CuentaClave cuentaClave = cuentaClaveServicio.buscarCuentaClavePorCuenta(cuenta, codTransaccion);
		// Respuesta
		ResponseGenerico<CuentaClave> response = new ResponseGenerico<>();
		response.setObjeto(cuentaClave);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar CuentaClave
	 * 
	 * @return guardar
	 */
	@SuppressWarnings("unused")
	@PostMapping(value = "guardarListaCuentaClave")
	public ResponseGenerico<CuentaClave> guardarListaCuentaClave(@RequestBody List<CuentaClave> listaCuentaClave) {
		CuentaClave cuentaClave = new CuentaClave();
		if (listaCuentaClave.size() > 0) {
			Integer respuesta = cuentaClaveServicio.eliminarCuentaClavePorCodTransaccion(listaCuentaClave.get(0).getCodTransaccion());
			for (CuentaClave cuentaClaveAux : listaCuentaClave) {
				cuentaClave = cuentaClaveServicio.registrar(cuentaClaveAux);
			}
		}
		// Respuesta
		ResponseGenerico<CuentaClave> response = new ResponseGenerico<>();
		response.setObjeto(cuentaClave);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * REST para guardar o actualizar CuentaClave
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarCuentaClave")
	public ResponseGenerico<CuentaClave> guardarCuentaClave(@RequestBody CuentaClave cuentaClave) {
		cuentaClave = cuentaClaveServicio.registrar(cuentaClave);
		// Respuesta
		ResponseGenerico<CuentaClave> response = new ResponseGenerico<>();
		response.setObjeto(cuentaClave);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarCuentaClavePorId/{codigo}")
	public ResponseGenerico<CuentaClave> eliminarCuentaClavePorId(@PathVariable("codigo") Long codigo) {
		CuentaClave cuentaClave = cuentaClaveServicio.buscarCuentaClavePorCodigo(codigo);
		cuentaClave.setEstado(EstadoEnum.INACTIVO.getDescripcion());
		cuentaClaveServicio.registrar(cuentaClave);
		// Respuesta
		ResponseGenerico<CuentaClave> response = new ResponseGenerico<>();
		response.setObjeto(cuentaClave);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
