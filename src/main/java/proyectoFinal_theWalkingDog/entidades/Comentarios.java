/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoFinal_theWalkingDog.entidades;
// testing merge request (pull request

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author JP
 */
@Entity
public class Comentarios implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idComentario;
    private String comentario;
    private int puntuacion;
    private boolean activoComentario;

    public Comentarios() {
    }

    public Comentarios(String idComentario, String comentario, int puntuacion, boolean activoComentario) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.activoComentario = activoComentario;
    }

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