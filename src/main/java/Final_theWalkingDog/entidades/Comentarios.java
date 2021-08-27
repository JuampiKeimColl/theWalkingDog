
package Final_theWalkingDog.entidades;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class Comentarios implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idComentario;
    private String comentario;
    private int puntuacion;
    private boolean activoComentario;

    
    public String getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(String idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public boolean isActivoComentario() {
        return activoComentario;
    }

    public void setActivoComentario(boolean activoComentario) {
        this.activoComentario = activoComentario;
    }

    @Override
    public String toString() {
        return "Comentarios{" + "idComentario=" + idComentario + ", comentario=" + comentario + ", puntuacion=" + puntuacion + ", activoComentario=" + activoComentario + '}';
    }
    
    
   
    

}
