package Final_theWalkingDog;

<<<<<<< HEAD
=======
import Final_theWalkingDog.servicios.FotoServicios;
import Final_theWalkingDog.servicios.WalkerServicios;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> db88b54da94a0a1bcee48621cfd3e19c6fea385f
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProyectoFinalApplication {

<<<<<<< HEAD
	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalApplication.class, args);
	}
=======
   
    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(ProyectoFinalApplication.class, args);

//        WalkerServicios ws = new WalkerServicios();
      
      FotoServicios servicio1=context.getBean(FotoServicios.class);
//
        servicio1.crearFoto();

//                ws.crearWalker("40877744", "Jose", "Gomez", "afanfa@afas.com", "alkjfnlsa", "19818", "afksa asf as f", "afas saf", 10, 200);
    }
>>>>>>> db88b54da94a0a1bcee48621cfd3e19c6fea385f

}
