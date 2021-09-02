
package Final_theWalkingDog.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PortalControlador {
    
    @GetMapping("/")
    public String index(){
        return "index.html";
    }
     @GetMapping("/")
    public String contacto(){
        return "contacto.html";
    }
    @GetMapping("/")
    public String iniciosesionusuario(){
        return "iniciosesionusuario.html";
    }
     @GetMapping("/")
    public String inisiosesionwalker(){
        return "inisiosesionwalker.html";
    }
    @GetMapping("/")
    public String otros(){
        return "otros.html";
    }
     @GetMapping("/")
    public String perfilusuario(){
        return "perfilusuario.html";
    }
    @GetMapping("/")
    public String perfilwalker(){
        return "perfilwalker.html";
    }
    @GetMapping("/")
    public String rutaspaseo(){
        return "perfilwalker.html";
    }
     @GetMapping("/")
    public String usuario(){
        return "usuario.html";
    }
     @GetMapping("/")
    public String videosinteres(){
        return "videosinteres.html";
    }
     @GetMapping("/")
    public String walker(){
        return "walker.html";
    }
}
