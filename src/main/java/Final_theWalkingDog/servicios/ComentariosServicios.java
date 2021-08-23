/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_theWalkingDog.servicios;

import Final_theWalkingDog.entidades.Comentarios;
import Final_theWalkingDog.repositorio.ComentariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;




@service
public class ComentariosServicios {
    
    @Autowired
    private ComentariosRepositorio comentariosRepositorio;
    
    public void Comentar (String idUsuario, String Perro, String idWalker, String comentario, int puntuacion){
       
        Comentarios comentarios = new Comentarios();
        
        
        
        
    }
    
    
}
