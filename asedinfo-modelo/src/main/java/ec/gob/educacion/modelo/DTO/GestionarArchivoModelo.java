package ec.gob.educacion.modelo.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GestionarArchivoModelo {

    private String nombre;
    private String url;

    public GestionarArchivoModelo() {
    }

    public GestionarArchivoModelo(String nombre, String url) {
        this.nombre = nombre;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}