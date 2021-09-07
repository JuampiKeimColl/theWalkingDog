package Final_theWalkingDog.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalControlador {

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

    @PostMapping("/registroUsuario")
    public String registroUsuario(@RequestParam String email,
            @RequestParam String nombre, @RequestParam String apellido,
            @RequestParam String dni, @RequestParam String contrasenia1,
            @RequestParam String contrasenia2) {
        System.out.println("Email: " + email);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Dni: " + dni);
        System.out.println("Clave1: " + contrasenia1);
        System.out.println("Clave2: " + contrasenia2);
        return "perfilusuario.html";
    }

}
