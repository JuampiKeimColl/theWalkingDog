
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
    
    public void crearWalker(){
        
        Walker walker = new Walker();
        
        walker.setIdWalkerDNI("498489");
        walker.setNombreWalker("asfaf");
        walker.setApellidoWalker("asfaf");
        walker.setCorreoWalker("asfaf");
        walker.setContraseniaWalker("asfaf");
        walker.setTelefonoWalker("151515");
        walker.setDireccionWalker("asfaf");
        walker.setBarrioWalker("asfaf");
        walker.setManadaWalker(10);
        Date hoy = new Date();
        walker.setFechaAltaWalker(hoy);
        walker.setFechaModWalker(hoy);
        walker.setTotalPaseosWalker(15);
        walker.setPuntuacionWalker(15);
//        walker.setComentarioWalker("afnasf");
        walker.setPenalizacionWalker(10);
//        walker.setTurnoPaseo(turnoPaseo);
        walker.setPrecioPaseo(150);
//        walker.setFotoWalker(fotoWalker);
//        walker.setFotoDNIWalker(FotoDNIWalker);
        walker.setActivoWalker(true);
        
        walkerrepositorio.save(walker);        
    
        
        
    }
}
