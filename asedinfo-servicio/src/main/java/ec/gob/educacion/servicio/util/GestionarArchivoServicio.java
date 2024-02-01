package ec.gob.educacion.servicio.util;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface GestionarArchivoServicio {
	//public void init();

	/*
	 * Metodo para guardar
	 */
	public void cargarArchivo(MultipartFile file, String nombreArchivo);

	/*
	 * Metodo para cargar un archivo
	 */
	public Resource load(String filename);

	/*
	 * Metodo para borrar todos los archivos
	 */
	public void deleteAll();

	/*
	 * Metodo para Cargar todos los archivos
	 */
	public Stream<Path> descargarArchivos();

	/*
	 * Metodo para Borrar un archivo
	 */
	public String deleteFile(String filename) throws IOException;

	/*
	 * Metodo para Descargar un archivo
	 */
    public Resource descargarArchivo(String filename, String UPLOADED_FOLDER);

}