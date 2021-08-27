package Final_theWalkingDog.servicios;

import Final_theWalkingDog.entidades.Foto;
import Final_theWalkingDog.repositorio.FotoRepositorio;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoServicios {

    @Autowired
    private FotoRepositorio fotoRepositorio;

    public Foto crearFoto(MultipartFile archivo) throws Exception {
        if (archivo != null) {
            try {

                Foto foto = new Foto();

                foto.setUri(archivo.getContentType());
                foto.setFileName(archivo.getName());
                foto.setContenido(archivo.getBytes());
                foto.setActivoFoto(true);

                return fotoRepositorio.save(foto);

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }
    
    public Foto modificarFoto(String idFoto, MultipartFile archivo) throws Exception {
      if (archivo != null) {
            try {

                Foto foto = new Foto();
                if (idFoto!=null) {
                    Optional<Foto> respuesta = fotoRepositorio.findById(idFoto);
                    if (respuesta.isPresent()) {
                        foto=respuesta.get();
                    }
                }

                foto.setUri(archivo.getContentType());
                foto.setFileName(archivo.getName());
                foto.setContenido(archivo.getBytes());
                foto.setActivoFoto(true);

                return fotoRepositorio.save(foto);

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

}
