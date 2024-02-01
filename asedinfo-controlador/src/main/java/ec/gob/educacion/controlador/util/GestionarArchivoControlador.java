package ec.gob.educacion.controlador.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import ec.gob.educacion.modelo.DTO.GestionarArchivoModelo;
import ec.gob.educacion.servicio.util.GestionarArchivoServicio;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/private/")
public class GestionarArchivoControlador {
	@Autowired
	GestionarArchivoServicio gestionarArchivoServicio;

	// Cargar archivo PDF a una carpeta
	@PostMapping("cargarArchivo/{nombreArchivo}")
	public ResponseEntity<String> cargarArchivo(@RequestParam("files") MultipartFile[] files,  @PathVariable String nombreArchivo) {
		String message = "";
		try {
			List<String> fileNames = new ArrayList<>();
			Arrays.asList(files).stream().forEach(file -> {
				gestionarArchivoServicio.cargarArchivo(file, nombreArchivo);
				fileNames.add(file.getOriginalFilename());
			});

			message = "Se subieron los archivos correctamente " + fileNames;
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "Fallo al subir los archivos";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}

	@GetMapping("descargarArchivos")
	public ResponseEntity<List<GestionarArchivoModelo>> descargarArchivos() {
		List<GestionarArchivoModelo> fileInfos = gestionarArchivoServicio.descargarArchivos().map(path -> {
			String fileName = path.getFileName().toString();
			String url = MvcUriComponentsBuilder
					.fromMethodName(GestionarArchivoControlador.class, "getFile", path.getFileName().toString()).build().toString();
			return new GestionarArchivoModelo(fileName, url);
		}).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	}

	@GetMapping("files/{filename:.+}")
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = gestionarArchivoServicio.load(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@GetMapping("delete/{filename:.+}")
	public ResponseEntity<String> deleteFile(@PathVariable String filename) {
		String message = "";
		try {
			message = gestionarArchivoServicio.deleteFile(filename);
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Error eliminar archivo...");
		}
	}

	@GetMapping(value = "descargarArchivo/{filename:.+}/{titCedula}")
	public ResponseEntity<Resource> descargarArchivo(@PathVariable String filename, @PathVariable String titCedula) {
		Resource file = gestionarArchivoServicio.descargarArchivo(filename, Constantes.nombreDirectorio + "//");
		Path path;
		try {
			path = file.getFile().toPath();
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(path))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
					.body(file);
		} catch (IOException e) {
			return null;
		}
	}

}