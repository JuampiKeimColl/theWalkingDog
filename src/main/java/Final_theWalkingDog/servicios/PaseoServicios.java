package Final_theWalkingDog.servicios;

import Final_theWalkingDog.entidades.Paseo;
import Final_theWalkingDog.entidades.Perro;
import Final_theWalkingDog.entidades.Walker;
import Final_theWalkingDog.repositorio.PaseoRepositorio;
import Final_theWalkingDog.repositorio.PerroRepositorio;
import Final_theWalkingDog.repositorio.WalkerRepositorio;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//VIDEO 3 CAPA SERVICIO https://www.youtube.com/watch?v=YE1nvIWbTUs&list=PLgwlfcqa5h3x8HAea7s3DXv5CvjEfR4uG&index=6
public class PaseoServicios {

    @Autowired
    private WalkerRepositorio walkerRepositorio;
    @Autowired
    private PaseoRepositorio paseoRepositorio;
    @Autowired
    private PerroRepositorio perroRepositorio;

    public void pasear(String idUsuario, String idPerro, String idWalker) throws Exception {
        Paseo paseo = new Paseo();

        paseo.setHoraInicioPaseo(new Date());

        Optional<Perro> respuesta = perroRepositorio.findById(idPerro);
        if (respuesta.isPresent()) {
            Perro perro = respuesta.get();
            if (perro.getUsuarioPerro().getIdUsuario().equals(idUsuario)) {
                paseo.setPerro(perro);
            } else {
                throw new Exception("No tiene permiso para usar este perro.");
            }

        } else {
            throw new Exception("No se encontró el Perro.");
        }

        Optional<Walker> respuesta1 = walkerRepositorio.findById(idWalker);
        if (respuesta1.isPresent()) {
            Walker walker = respuesta1.get();
            paseo.setWalker(walker);
        } else {
            throw new Exception("No se encontró el Walker.");
        }
            paseoRepositorio.save(paseo);
    }

    public void confirmarPaseo(String idPaseo) throws Exception {
        Optional<Paseo> respuesta= paseoRepositorio.findById(idPaseo);
        
        if (respuesta.isPresent()) {
            Paseo paseo=respuesta.get();
            paseo.setConformidadPaseo(true);

            paseoRepositorio.save(paseo);
        }else{
            throw new Exception("No se encontró paseo.");
        }
    }
}
