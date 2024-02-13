package ec.gob.educacion.servicio.impl.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import ec.gob.educacion.servicio.util.GestionarArchivoServicio;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Service
public class GestionarArchivoServicioImpl implements GestionarArchivoServicio {
	// Obtener valores desde application.properties
	@Value("${nombre.directorio}")
	private String nombreDirectorio;

	// private final Path root = Paths.get("D:\\upload\\");
	private Path pathLocation;
	
	public void iniciaPathLocation() {
		try {
			System.out.println("user.home = "+System.getProperty("user.home"));
			System.out.println("File.separator = "+File.separator);

			StringBuilder builder = new StringBuilder();
			builder.append(System.getProperty("user.home").replace("C:", "D:"));
			builder.append(File.separator);
			builder.append("desarrollo_java_1.8");
			builder.append(File.separator);
			builder.append("WorkSpaceAsedinfoGit");
			builder.append(File.separator);
			builder.append("ASEDINFO_FRONTEND_CODIGO");
			builder.append(File.separator);
			builder.append("src");
			builder.append(File.separator);
			builder.append("assets");
			builder.append(File.separator);
			builder.append("musica");
			builder.append(File.separator);
			//builder.append(file.getOriginalFilename());
			
			//Path path = Paths.get(builder.toString());

			pathLocation = Paths.get(nombreDirectorio);
			//pathLocation = Paths.get(builder.toString());
			System.out.println("pathLocation = "+pathLocation);

			// Verificar si el directorio ya existe
			File directorio = new File(nombreDirectorio);
			if (!directorio.exists()) {
				Files.createDirectory(pathLocation);
			}
		} catch (IOException e) {
			throw new RuntimeException("No se puede crear la carpeta " + nombreDirectorio);
		}
	}

	@Override
	public void cargarArchivo(MultipartFile file, String nombreArchivo) {
		System.out.println("nombreArchivo = "+nombreArchivo);
		
		this.iniciaPathLocation();
		try {
			// copy (que queremos copiar, a donde queremos copiar)
			Files.copy(file.getInputStream(), this.pathLocation.resolve(nombreArchivo+"_"+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Copy ok...");
		} catch (IOException e) {
			throw new RuntimeException("No se puede guardar el archivo. Error = " + e.getMessage());
		}
	}

	@Override
	public Resource load(String filename) {
		this.iniciaPathLocation();
		try {
			Path file = pathLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("No se puede leer el archivo ");
			}

		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

    public Resource descargarArchivo(String filename, String UPLOADED_FOLDER) {
		this.iniciaPathLocation();
        try {
            Path file = Paths.get(UPLOADED_FOLDER).resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

	@Override
	public void deleteAll() {
		this.iniciaPathLocation();
		FileSystemUtils.deleteRecursively(pathLocation.toFile());
	}

	@Override
	public Stream<Path> descargarArchivos() {
		// Files.walk recorre nuestras carpetas (uploads) buscando los archivos
		// el 1 es la profundidad o nivel que queremos recorrer
		// :: Referencias a metodos
		// Relativize sirve para crear una ruta relativa entre la ruta dada y esta ruta
		this.iniciaPathLocation();
		try {
			return Files.walk(this.pathLocation, 1).filter(path -> !path.equals(this.pathLocation))
					.map(this.pathLocation::relativize);
		} catch (RuntimeException | IOException e) {
			throw new RuntimeException("No se pueden cargar los archivos ");
		}
	}

	@SuppressWarnings("unused")
	@Override
	public String deleteFile(String filename) {
		this.iniciaPathLocation();
		try {
			Boolean delete = Files.deleteIfExists(this.pathLocation.resolve(filename));
			return "Archivo eliminado";
		} catch (IOException e) {
			e.printStackTrace();
			return "Error: Archivo NO eliminado";
		}
	}

}