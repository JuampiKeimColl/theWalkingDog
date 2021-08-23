/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_theWalkingDog.entidades;
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
    private String idUsuario;
    private String idWalker;
    private String idPerro;

    public Comentarios() {
    }

    public Comentarios(String idComentario, String comentario, int puntuacion, boolean activoComentario) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.activoComentario = activoComentario;
    }

    public Comentarios(String idComentario, String comentario, int puntuacion, boolean activoComentario, String idUsuario, String idWalker, String idPerro) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.activoComentario = activoComentario;
        this.idUsuario = idUsuario;
        this.idWalker = idWalker;
        this.idPerro = idPerro;
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

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdWalker() {
        return idWalker;
    }

    public void setIdWalker(String idWalker) {
        this.idWalker = idWalker;
    }

    public String getIdPerro() {
        return idPerro;
    }

    public void setIdPerro(String idPerro) {
        this.idPerro = idPerro;
    }

    @Override
    public String toString() {
        return "Comentarios{" + "idComentario=" + idComentario + ", comentario=" + comentario + ", puntuacion=" + puntuacion + ", activoComentario=" + activoComentario + ", idUsuario=" + idUsuario + ", idWalker=" + idWalker + ", idPerro=" + idPerro + '}';
    }

    
    
   
    

}
