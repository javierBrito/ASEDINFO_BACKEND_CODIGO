package ec.gob.educacion.repositorio.venta;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.educacion.modelo.venta.*;

@Repository
public interface CuentaClaveRepositorio extends JpaRepository<CuentaClave, Long> {

	List<CuentaClave> findByEstadoOrderByCodigo(String estado);

	@Query(nativeQuery = false, value = "select i from CuentaClave i where i.transaccion.codigo = :codTransaccion and i.estado = 'A'")
	List<CuentaClave> listarCuentaClavePorTransaccion(@Param("codTransaccion") Long codTransaccion);

	@Query(nativeQuery = false, value = "select i from CuentaClave i where i.cuenta = :cuenta and i.transaccion.codigo = :codTransaccion and i.estado = 'A'")
	CuentaClave buscarCuentaClavePorCuenta(@Param("cuenta") String cuenta, @Param("codTransaccion") Long codTransaccion);

	@Query(nativeQuery = true, value = "delete from wp_cuenta_clave where cod_transaccion = :codTransaccion")
	Integer eliminarCuentaClavePorCodTransaccion(@Param("codTransaccion") Long codTransaccion);

	CuentaClave findByCodigo(Long codigo);
}
