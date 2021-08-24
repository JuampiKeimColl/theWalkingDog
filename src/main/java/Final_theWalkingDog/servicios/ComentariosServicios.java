
package Final_theWalkingDog.servicios;


import Final_theWalkingDog.entidades.Comentarios;

import Final_theWalkingDog.repositorio.ComentariosRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentariosServicios {
    
   @Autowired
    private ComentariosRepositorio comentarioRepositario;
    
    public void comentar (String comentario, int puntuacion) throws Exception{
                
        Comentarios comentarios = new Comentarios();
        
        validar(comentario , puntuacion);
        comentarios.setComentario(comentario);
        comentarios.setPuntuacion(puntuacion);
        comentarios.setActivoComentario(true);

       comentarioRepositario.save(comentarios); 
        
        
    }
    
    public void modificar(String idComentario, String comentario, int puntuacion) throws Exception {

        Optional<Comentarios> respuesta = comentarioRepositario.findById(idComentario);
        if (respuesta.isPresent()) {
            Comentarios comentarios = respuesta.get();
            validar(comentario, puntuacion);

            comentarios.setComentario(comentario);
            comentarios.setPuntuacion(puntuacion);

            comentarioRepositario.save(comentarios);

        }

    }
        
       public void deshabilitar (String idComentario ){
                
       Optional<Comentarios> respuesta = comentarioRepositario.findById(idComentario);
        if (respuesta.isPresent()) {
            Comentarios comentarios = respuesta.get();
           

           comentarios.setActivoComentario(false);

            comentarioRepositario.save(comentarios);

        }
        
        
    }
       
             public void habilitar (String idComentario ){
                
       Optional<Comentarios> respuesta = comentarioRepositario.findById(idComentario);
        if (respuesta.isPresent()) {
            Comentarios comentarios = respuesta.get();
           

           comentarios.setActivoComentario(true);

            comentarioRepositario.save(comentarios);

        }
        
        
    }
    public void validar (String comentario , int puntuacion) throws Exception{
        
        if (comentario == null || comentario.isEmpty()) {
            throw new Exception("Debe indicar un comentario");
        }
        if ( puntuacion > 5 || puntuacion < 1  ) {
            throw new Exception("La puntuacion es de caracter obligatorio y debe estar entre 1 y 5");
        }
        
    }
    
    
    
}
