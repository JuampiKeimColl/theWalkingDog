package Final_theWalkingDog;

import Final_theWalkingDog.servicios.FotoServicios;
import Final_theWalkingDog.servicios.WalkerServicios;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalApplication.class, args);
                
                WalkerServicios ws = new WalkerServicios();
                FotoServicios fs = new FotoServicios();
                
                fs.crearFoto();
                
//                ws.crearWalker("40877744", "Jose", "Gomez", "afanfa@afas.com", "alkjfnlsa", "19818", "afksa asf as f", "afas saf", 10, 200);
                
                
                
	}

}
