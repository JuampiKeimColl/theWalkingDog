package Final_theWalkingDog.controladores;

import Final_theWalkingDog.servicios.UsuarioServicios;
import Final_theWalkingDog.servicios.WalkerServicios;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private UsuarioServicios usuarioServicio;
    @Autowired
    private WalkerServicios walkerServicio;

    @GetMapping()
    public String index() {
        return "index.html";
    }

    @GetMapping("/contacto")
    public String contacto() {
        return "contacto.html";
    }

    @GetMapping("/inicosesionusuario")
    public String iniciosesionusuario() {
        return "iniciosesionusuario.html";
    }

    @GetMapping("/inisiosesionwalker")
    public String inisiosesionwalker() {
        return "inisiosesionwalker.html";
    }

    @GetMapping("/otros")
    public String otros() {
        return "otros.html";
    }

    @GetMapping("/perfilusuario")
    public String perfilusuario() {
        return "perfilusuario.html";
    }

    @GetMapping("/perfilwalker")
    public String perfilwalker() {
        return "perfilwalker.html";
    }

    @GetMapping("/rutaspaseo")
    public String rutaspaseo() {
        return "perfilwalker.html";
    }

    @GetMapping("/usuario")
    public String usuario() {
        return "usuario.html";
    }

    @GetMapping("/videosinteres")
    public String videosinteres() {
        return "videosinteres.html";
    }

    @GetMapping("/walker")
    public String walker() {
        return "walker.html";
    }

  @PostMapping("/registrarse")
    public String registroUsuario(ModelMap modelo, @RequestParam String email,
            @RequestParam String nombre, @RequestParam String apellido,
            @RequestParam String dni, @RequestParam String contrasenia1,
            @RequestParam String contrasenia2) {

        try {
            usuarioServicio.crearUsuario(nombre, apellido, dni, email, contrasenia1, null,null,null);
        } catch (Exception ex) {
            modelo.put("error",ex.getMessage());
            return "usuario.html";
        }

        return "index.html";
    }
    
 @PostMapping("/registrarseW")
    public String registroWalker(ModelMap modelo, @RequestParam String email,
            @RequestParam String nombre, @RequestParam String apellido,
            @RequestParam String dni, @RequestParam String contrasenia1,
            @RequestParam String contrasenia2) {

        try {
            walkerServicio.crearWalker(dni, nombre, apellido, email, contrasenia1, null, null, null, 0, 0);
         
        } catch (Exception ex) {
            modelo.put("error",ex.getMessage());
            return "usuario.html";
        }

        return "index.html";
    }
}
