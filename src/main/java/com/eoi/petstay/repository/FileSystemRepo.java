package com.eoi.petstay.repository;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Repository
public class FileSystemRepo {
    // Obtenemos la ruta de la carpeta "Resources" de la aplicación
    String RESOUCES_DIR = FileSystemRepo.class.getResource("/").getPath();
    // Añadimos el nombre de la carpeta que guarda las imágenes subidas por los usuarios
    String IMGS_DIR = RESOUCES_DIR.concat("/imagenes");

    // Para grabar el archivo
    public String grabar(byte[] imagen, String nombre) throws IOException {
        // Asignamos el nombre del archivo con la fecha y la hora (hasta miliseg.) y el nombre de la imagen
        // En el código final podría ser util incluir el nombre del usuario o algún dato similar
        // Es muy importante que cada imagen TENGA UN NOMBRE ÚNICO, ya que si se repite, se podrían sobreescribir
        Path rutaNuevaImg = Paths.get(IMGS_DIR + new Date().getTime() + "-" + nombre);
        Files.createDirectory(rutaNuevaImg.getParent());    // creamos el directorio si no existe
        // Guardamos el archivo
        Files.write(rutaNuevaImg, imagen);
        // devolvemos la ruta del nuevo archivo grabado
        return rutaNuevaImg.toAbsolutePath().toString();
    }

    // Para leer el archivo
    public FileSystemResource buscar(String uri) {
        /*
            Recuperamos el archivo por su ubicación.

            Devolvemos un elemento de tipo recurso del sistema de archivos (FileSystemResource), que es una
            implementación de la interfaz Resource de Spring.

            Si se produce cualquier error, lanzamos una excepción. Podría ser interesante lanzar excepciones con
            distintos estados HTTP según el tipo de error.

            Este enfoque es adecuado com solución general para enviar flujos de archivos al cliente. Si utilizáramos
            almacenamiento en la nube en lugar del local (filesystem), se podría sustituir FileSystemResource por otra
            implementación como InputStreamResource o ByteArrayResource.
         */
        try {
            return new FileSystemResource(Paths.get(uri));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
