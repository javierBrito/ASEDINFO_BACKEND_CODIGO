package ec.gob.educacion.servicio.impl.venta;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.modelo.catalogo.Transaccion;
import ec.gob.educacion.modelo.venta.CuentaClave;
import ec.gob.educacion.repositorio.venta.CuentaClaveRepositorio;
import ec.gob.educacion.servicio.catalogo.TransaccionServicio;
import ec.gob.educacion.servicio.venta.CuentaClaveServicio;

@Service
public class CuentaClaveServicioImpl implements CuentaClaveServicio {

	@Autowired
	private CuentaClaveRepositorio cuentaClaveRepositorio;
	@Autowired
	private TransaccionServicio transaccionServicio;

	@Override
	public List<CuentaClave> listarTodosCuentaClave() {
		return cuentaClaveRepositorio.findAll();
	}

	@Override
	public List<CuentaClave> listarCuentaClavePorTransaccion(Long codTransaccion) {
		return cuentaClaveRepositorio.listarCuentaClavePorTransaccion(codTransaccion);
	}
	
	@Override
	public Integer eliminarCuentaClavePorCodTransaccion(Long codTransaccion) {
		return cuentaClaveRepositorio.eliminarCuentaClavePorCodTransaccion(codTransaccion);
	}

	@Override
	public List<CuentaClave> listarCuentaClaveActivo(String estado) {
		return cuentaClaveRepositorio.findByEstadoOrderByCodigo(estado);
	}

	@Override
	public CuentaClave buscarCuentaClavePorCodigo(Long codigo) {
		return cuentaClaveRepositorio.findByCodigo(codigo);
	}

	@Override
	public CuentaClave buscarCuentaClavePorCuenta(String cuenta, Long codTransaccion) {
		return cuentaClaveRepositorio.buscarCuentaClavePorCuenta(cuenta, codTransaccion);
	}

	@Override
	public CuentaClave registrar(CuentaClave cuentaClave) {
		if (cuentaClave.getCodTransaccion() != 0) {
			Transaccion transaccion = transaccionServicio.buscarTransaccionPorCodigo(cuentaClave.getCodTransaccion());
			cuentaClave.setTransaccion(transaccion);
		}
		return cuentaClaveRepositorio.save(cuentaClave);
	}

	@Override
	public CuentaClave crearCuentaClave(CuentaClave cuentaClave) {
		if (cuentaClave.getCodTransaccion() != 0) {
			Transaccion transaccion = transaccionServicio.buscarTransaccionPorCodigo(cuentaClave.getCodTransaccion());
			cuentaClave.setTransaccion(transaccion);
		}
		return cuentaClaveRepositorio.save(cuentaClave);
	}
	
}
