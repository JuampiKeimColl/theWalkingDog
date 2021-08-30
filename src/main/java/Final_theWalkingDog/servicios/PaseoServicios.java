package Final_theWalkingDog.servicios;

import Final_theWalkingDog.entidades.Paseo;
import Final_theWalkingDog.entidades.Perro;
import Final_theWalkingDog.repositorio.PaseoRepositorio;
import Final_theWalkingDog.repositorio.PerroRepositorio;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaseoServicios {

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
            } else{
                throw new Exception("No tiene permiso para usar este perro.");
            }

        }
        
        Optional<Walker>
    }
}
