/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoFinal_theWalkingDog.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Foto implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idFoto;
    private String uri;
    private String fileName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAltaFoto;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModFoto;
    private boolean activoFoto;

    public Foto() {
    }

    public Foto(String idFoto, String uri, String fileName, Date fechaAltaFoto, Date fechaModFoto, boolean activoFoto) {
        this.idFoto = idFoto;
        this.uri = uri;
        this.fileName = fileName;
        this.fechaAltaFoto = fechaAltaFoto;
        this.fechaModFoto = fechaModFoto;
        this.activoFoto = activoFoto;
    }

    public String getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(String idFoto) {
        this.idFoto = idFoto;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getFechaAltaFoto() {
        return fechaAltaFoto;
    }

    public void setFechaAltaFoto(Date fechaAltaFoto) {
        this.fechaAltaFoto = fechaAltaFoto;
    }

    public Date getFechaModFoto() {
        return fechaModFoto;
    }

    public void setFechaModFoto(Date fechaModFoto) {
        this.fechaModFoto = fechaModFoto;
    }

    public boolean isActivoFoto() {
        return activoFoto;
    }

    public void setActivoFoto(boolean activoFoto) {
        this.activoFoto = activoFoto;
    }

    @Override
    public String toString() {
        return "Foto{" + "idFoto=" + idFoto + ", uri=" + uri + ", fileName=" + fileName + ", fechaAltaFoto=" + fechaAltaFoto + ", fechaModFoto=" + fechaModFoto + ", activoFoto=" + activoFoto + '}';
    }

}
