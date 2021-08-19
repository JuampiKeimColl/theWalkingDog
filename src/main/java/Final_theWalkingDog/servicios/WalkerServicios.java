
package Final_theWalkingDog.servicios;

import Final_theWalkingDog.entidades.Walker;
import Final_theWalkingDog.repositorio.WalkerRepositorio;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalkerServicios {
    
    @Autowired
    private WalkerRepositorio walkerrepositorio;
    
    public void crearWalker(String IdWalkerDNI, String nombreWalker, String apellidoWalker, String correoWalker,String contraseniaWalker, String telefonoWalker, String direccionWalker, String barrioWalker, int manadaWalker, int precioPaseo){
        
        Walker walker = new Walker();
        
        walker.setIdWalkerDNI(IdWalkerDNI);
        walker.setNombreWalker(nombreWalker);
        walker.setApellidoWalker(apellidoWalker);
        walker.setCorreoWalker(correoWalker);
        walker.setContraseniaWalker(contraseniaWalker);
        walker.setTelefonoWalker(telefonoWalker);
        walker.setDireccionWalker(direccionWalker);
        walker.setBarrioWalker(barrioWalker);
        walker.setManadaWalker(manadaWalker);
        Date hoy = new Date();
        walker.setFechaAltaWalker(hoy);
        walker.setFechaModWalker(hoy);
//        walker.setTotalPaseosWalker(15);
//        walker.setPuntuacionWalker(15);
//        walker.setComentarioWalker("afnasf");
        walker.setPenalizacionWalker(10);
//        walker.setTurnoPaseo(turnoPaseo);
        walker.setPrecioPaseo(precioPaseo);
//        walker.setFotoWalker(fotoWalker);
//        walker.setFotoDNIWalker(FotoDNIWalker);
        walker.setActivoWalker(true);
        
        walkerrepositorio.save(walker);        
    
        
        
    }
}
