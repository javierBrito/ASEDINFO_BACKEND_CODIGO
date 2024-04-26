package ec.gob.educacion.controlador.competencia;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ec.gob.educacion.controlador.util.Constantes;
import ec.gob.educacion.modelo.response.ResponseGenerico;
import ec.gob.educacion.modelo.competencia.Participante;
import ec.gob.educacion.servicio.competencia.ParticipanteServicio;
import java.io.ByteArrayOutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping("competencia/")
public class ParticipanteControlador {

	@Autowired
	private ParticipanteServicio participanteServicio;

	@GetMapping(value = "listarTodosParticipante")
	public ResponseGenerico<Participante> listarTodosParticipante() {
		List<Participante> listaParticipante = participanteServicio.listarTodosParticipante();
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setListado(listaParticipante);
		response.setTotalRegistros((long) listaParticipante.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarParticipantePorEstado/{estadoPedido}")
	public ResponseGenerico<Participante> listarParticipantePorEstado(@PathVariable("estadoPedido") String estadoPedido) {
		List<Participante> listaParticipante = participanteServicio.listarParticipantePorEstado(estadoPedido);
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setListado(listaParticipante);
		response.setTotalRegistros((long) listaParticipante.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarParticipanteUsuario")
	public ResponseGenerico<Participante> listarParticipanteUsuario() {
		List<Participante> listaParticipante = participanteServicio.listarParticipanteUsuario();
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setListado(listaParticipante);
		response.setTotalRegistros((long) listaParticipante.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarParticipantePorPersona/{codPersona}")
	public ResponseGenerico<Participante> listarParticipantePorPersona(@PathVariable("codPersona") Long codPersona) {
		List<Participante> listaParticipante = participanteServicio.listarParticipantePorPersona(codPersona);
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setListado(listaParticipante);
		response.setTotalRegistros((long) listaParticipante.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarParticipantePorSubcategoria/{codSubcategoria}")
	public ResponseGenerico<Participante> listarParticipantePorSubcategoria(@PathVariable("codSubcategoria") Long codSubcategoria) {
		List<Participante> listaParticipante = participanteServicio.listarParticipantePorSubcategoria(codSubcategoria);
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setListado(listaParticipante);
		response.setTotalRegistros((long) listaParticipante.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarParticipantePorEmail/{email}")
	public ResponseGenerico<Participante> listarParticipantePorEmail(@PathVariable("email") String email) {
		List<Participante> listaParticipante = participanteServicio.listarParticipantePorEmail(email);
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setListado(listaParticipante);
		response.setTotalRegistros((long) listaParticipante.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarParticipantePorSubcategoriaInstancia/{codSubcategoria}/{codInstancia}/{codEstadoComptetencia}")
	public ResponseGenerico<Participante> listarParticipantePorSubcategoriaInstancia(@PathVariable("codSubcategoria") Long codSubcategoria, @PathVariable("codInstancia") Long codInstancia, @PathVariable("codEstadoComptetencia") Long codEstadoComptetencia) {
		List<Participante> listaParticipante = participanteServicio.listarParticipantePorSubcategoriaInstancia(codSubcategoria, codInstancia, codEstadoComptetencia);
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setListado(listaParticipante);
		response.setTotalRegistros((long) listaParticipante.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarParticipantePorEstadoCompetencia/{codEstadoComptetencia}")
	public ResponseGenerico<Participante> listarParticipantePorEstadoCompetencia(@PathVariable("codEstadoComptetencia") Long codEstadoComptetencia) {
		List<Participante> listaParticipante = participanteServicio.listarParticipantePorEstadoCompetencia(codEstadoComptetencia);
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setListado(listaParticipante);
		response.setTotalRegistros((long) listaParticipante.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarParticipanteEnEscenario")
	public ResponseGenerico<Participante> listarParticipanteEnEscenario() {
		List<Participante> listaParticipante = participanteServicio.listarParticipanteEnEscenario();
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setListado(listaParticipante);
		response.setTotalRegistros((long) listaParticipante.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener Participante
	 * 
	 * @return Participante
	 */
	@GetMapping(value = "buscarParticipantePorCodigo/{codigo}")
	public ResponseGenerico<Participante> buscarParticipantePorCodigo(@PathVariable("codigo") Long codigo) {
		Participante Participante = participanteServicio.buscarParticipantePorCodigo(codigo);
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setObjeto(Participante);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar Participante
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarParticipante")
	public ResponseGenerico<Participante> guardarParticipante(@RequestBody Participante participante) {
		participante = participanteServicio.registrar(participante);
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setObjeto(participante);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarParticipantePorId/{codigo}")
	public ResponseGenerico<Participante> eliminarParticipante(@PathVariable("codigo") Long codigo) {
		Participante participante = participanteServicio.buscarParticipantePorCodigo(codigo);
		participante.setEstado("I");
		participanteServicio.registrar(participante);
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setObjeto(participante);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}

	/**
	 * REST para actualizar el numero de participante en Participante 
	 * 
	 * @return actualizar
	 */
	@PostMapping(value = "actualizarListaParticipante")
	public ResponseGenerico<Participante> actualizarListaParticipante(@RequestBody List<Participante> listaParticipante) {
		int numParticipante = 0;
		if (listaParticipante.size() > 0) {
			// Obtener el max de Participante
			numParticipante = participanteServicio.obtenerMaxNumParticipante();
			for (Participante participanteAux : listaParticipante) {
				// Cuando trae ya el número de Participante num_participante <> 0
				if (participanteAux.getNumParticipante() == 0) {
					numParticipante += 1;
					participanteAux.setNumParticipante(numParticipante);
					participanteServicio.registrar(participanteAux);
				} else {
					participanteServicio.registrar(participanteAux);
				}
			}
		}
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setListado(listaParticipante);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}
	
	
	// Trabajar con Blob eb la base
	@PostMapping("/upload")
	public ResponseGenerico<Participante> uplaodImage(@RequestParam("imageFile") MultipartFile file) {
		Participante participante = new Participante();
		try {
			System.out.println("Original Image Byte Size - " + file.getBytes().length);
			//Participante participante = new Participante(compressBytes(file.getBytes());
			participante = participanteServicio.buscarParticipantePorCodigo(8L);
			participante.setCancion(compressBytes(file.getBytes()));
			participante = participanteServicio.registrar(participante);
		} catch (IOException e) {
			System.out.println("Error al traer el archivo e.getMessage() = " + e.getMessage());
		}
		// Respuesta
		ResponseGenerico<Participante> response = new ResponseGenerico<>();
		response.setObjeto(participante);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}
	
	@GetMapping(path = { "/get/{imageName}" })
	public Object getImage(@PathVariable("imageName") String imageName) {
		//final Optional<Participante> retrievedImage = imageRepository.findByName(imageName);
		//Participante img = new Participante(retrievedImage.get().getName(), retrievedImage.get().getType(),
		//		decompressBytes(retrievedImage.get().getPicByte()));

		@SuppressWarnings("unused")
		Participante participante = new Participante();
		//try {
			participante = participanteServicio.buscarParticipantePorCodigo(8L);
			//List<Object> listaObjetos = decompressBytes(participante.getCancion());
		//} catch (IOException e) {
		//	System.out.println("Error al traer el archivo e.getMessage() = " + e.getMessage());
		//}
		
		//return participante.setCancion(decompressBytes(participante.getCancion()));
		return null;
	}
	
	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}
	
	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
}
