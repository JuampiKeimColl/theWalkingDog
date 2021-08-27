/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_theWalkingDog.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario implements Serializable {

    @Id
    private String idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String correoUsuario;
    private String contraseniaUsuario;
    private String telefonoUsuario;
    private String direccionUsuario;
    private String barrioUsuario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAltaUsuario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModUsuario;

    private boolean activoUsuario;
    
    private Perro perro;
    
    @OneToOne
    private Foto fotoUsuario;

    
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public String getBarrioUsuario() {
        return barrioUsuario;
    }

    public void setBarrioUsuario(String barrioUsuario) {
        this.barrioUsuario = barrioUsuario;
    }

    public Date getFechaAltaUsuario() {
        return fechaAltaUsuario;
    }

    public void setFechaAltaUsuario(Date fechaAltaUsuario) {
        this.fechaAltaUsuario = fechaAltaUsuario;
    }

    public Date getFechaModUsuario() {
        return fechaModUsuario;
    }

    public void setFechaModUsuario(Date fechaModUsuario) {
        this.fechaModUsuario = fechaModUsuario;
    }

    public boolean isActivoUsuario() {
        return activoUsuario;
    }

    public void setActivoUsuario(boolean activoUsuario) {
        this.activoUsuario = activoUsuario;
    }

    public Perro getPerro() {
        return perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }

    public Foto getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(Foto fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", apellidoUsuario=" + apellidoUsuario + ", correoUsuario=" + correoUsuario + ", contraseniaUsuario=" + contraseniaUsuario + ", telefonoUsuario=" + telefonoUsuario + ", direccionUsuario=" + direccionUsuario + ", barrioUsuario=" + barrioUsuario + ", fechaAltaUsuario=" + fechaAltaUsuario + ", fechaModUsuario=" + fechaModUsuario + ", activoUsuario=" + activoUsuario + ", perro=" + perro + ", fotoUsuario=" + fotoUsuario + '}';
    }

}
