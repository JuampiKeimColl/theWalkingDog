
package Final_theWalkingDog.servicios;

import Final_theWalkingDog.entidades.Foto;
import Final_theWalkingDog.repositorio.FotoRepositorio;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoServicios {
    
    @Autowired
    private FotoRepositorio fotoRepositorio;
    
    public void crearFoto(){
       
        Foto foto = new Foto();
        
//        foto.setUri("aflknsal");
//        foto.setFileName("fksña");
//        foto.setFechaAltaFoto(new Date());
        foto.setActivoFoto(true);
    foto.setIdFoto("loquequieras");
        fotoRepositorio.save(foto);
    }
    
    
}
