/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_theWalkingDog.controladores;

import Final_theWalkingDog.entidades.Usuario;
import Final_theWalkingDog.servicios.UsuarioServicios;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author JP
 */

@Controller
@RequestMapping("/login")
public class loginControlador {
   
   @Autowired
   private UsuarioServicios usuarioServicio;
   
   @GetMapping("/inicio")
   private String inicio() {
    return "inicio.html";
   }
   
   @GetMapping("/loginsuccess")
   private String ingreso(HttpSession session) {
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       
       if(auth == null) { 
           return "redirect:/iniciosesionusuario";
       }else {
           UserDetails usuario = usuarioServicio.loadUserByUsername(auth.getName());
           
            if(usuario == null) { 
                return "redirect:/iniciosesionusuario";
            }
            return "redirect: /inicio";
       }
       
               
   }
  
}
