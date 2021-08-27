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
public class Walker implements Serializable {

    @Id
    private String idWalkerDNI;
    private String nombreWalker;
    private String apellidoWalker;
    private String correoWalker;
    private String contraseniaWalker;
    private String telefonoWalker;
    private String direccionWalker;
    private String barrioWalker;
    private int manadaWalker;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAltaWalker;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModWalker;
    private int totalPaseosWalker;
    private double puntuacionWalker;
    @OneToOne
    private Comentarios comentraioWalker;
    private int penalizacionWalker;
    private Paseo turnoPaseo;
    private double precioPaseo;
    @OneToOne
    private Foto fotoWalker;
    @OneToOne
    private Foto fotoDNIWalker;
    private boolean activoWalker;

    
    public double getPrecioPaseo() {
        return precioPaseo;
    }

    public void setPrecioPaseo(double precioPaseo) {
        this.precioPaseo = precioPaseo;
    }

    public String getIdWalkerDNI() {
        return idWalkerDNI;
    }

    public void setIdWalkerDNI(String idWalkerDNI) {
        this.idWalkerDNI = idWalkerDNI;
    }

    public String getNombreWalker() {
        return nombreWalker;
    }

    public void setNombreWalker(String nombreWalker) {
        this.nombreWalker = nombreWalker;
    }

    public String getApellidoWalker() {
        return apellidoWalker;
    }

    public void setApellidoWalker(String apellidoWalker) {
        this.apellidoWalker = apellidoWalker;
    }

    public String getCorreoWalker() {
        return correoWalker;
    }

    public void setCorreoWalker(String correoWalker) {
        this.correoWalker = correoWalker;
    }

    public String getContraseniaWalker() {
        return contraseniaWalker;
    }

    public void setContraseniaWalker(String contraseniaWalker) {
        this.contraseniaWalker = contraseniaWalker;
    }

    public String getTelefonoWalker() {
        return telefonoWalker;
    }

    public void setTelefonoWalker(String telefonoWalker) {
        this.telefonoWalker = telefonoWalker;
    }

    public String getDireccionWalker() {
        return direccionWalker;
    }

    public void setDireccionWalker(String direccionWalker) {
        this.direccionWalker = direccionWalker;
    }

    public String getBarrioWalker() {
        return barrioWalker;
    }

    public void setBarrioWalker(String barrioWalker) {
        this.barrioWalker = barrioWalker;
    }

    public int getManadaWalker() {
        return manadaWalker;
    }

    public void setManadaWalker(int manadaWalker) {
        this.manadaWalker = manadaWalker;
    }

    public Date getFechaAltaWalker() {
        return fechaAltaWalker;
    }

    public void setFechaAltaWalker(Date fechaAltaWalker) {
        this.fechaAltaWalker = fechaAltaWalker;
    }

    public Date getFechaModWalker() {
        return fechaModWalker;
    }

    public void setFechaModWalker(Date fechaModWalker) {
        this.fechaModWalker = fechaModWalker;
    }

    public int getTotalPaseosWalker() {
        return totalPaseosWalker;
    }

    public void setTotalPaseosWalker(int totalPaseosWalker) {
        this.totalPaseosWalker = totalPaseosWalker;
    }

    public double getPuntuacionWalker() {
        return puntuacionWalker;
    }

    public void setPuntuacionWalker(double puntuacionWalker) {
        this.puntuacionWalker = puntuacionWalker;
    }

    public Comentarios getComentraioWalker() {
        return comentraioWalker;
    }

    public void setComentraioWalker(Comentarios comentraioWalker) {
        this.comentraioWalker = comentraioWalker;
    }

    public int getPenalizacionWalker() {
        return penalizacionWalker;
    }

    public void setPenalizacionWalker(int penalizacionWalker) {
        this.penalizacionWalker = penalizacionWalker;
    }

    public Paseo getTurnoPaseo() {
        return turnoPaseo;
    }

    public void setTurnoPaseo(Paseo turnoPaseo) {
        this.turnoPaseo = turnoPaseo;
    }

    public Foto getFotoWalker() {
        return fotoWalker;
    }

    public void setFotoWalker(Foto fotoWalker) {
        this.fotoWalker = fotoWalker;
    }

    public Foto getFotoDNIWalker() {
        return fotoDNIWalker;
    }

    public void setFotoDNIWalker(Foto fotoDNIWalker) {
        this.fotoDNIWalker = fotoDNIWalker;
    }

    public boolean isActivoWalker() {
        return activoWalker;
    }

    public void setActivoWalker(boolean activoWalker) {
        this.activoWalker = activoWalker;
    }
 

    @Override
    public String toString() {
        return "Walker{" + "idWalkerDNI=" + idWalkerDNI + ", nombreWalker=" + nombreWalker + ", apellidoWalker=" + apellidoWalker + ", correoWalker=" + correoWalker + ", contraseniaWalker=" + contraseniaWalker + ", telefonoWalker=" + telefonoWalker + ", direccionWalker=" + direccionWalker + ", barrioWalker=" + barrioWalker + ", manadaWalker=" + manadaWalker + ", fechaAltaWalker=" + fechaAltaWalker + ", fechaModWalker=" + fechaModWalker + ", totalPaseosWalker=" + totalPaseosWalker + ", puntuacionWalker=" + puntuacionWalker + ", comentraioWalker=" + comentraioWalker + ", penalizacionWalker=" + penalizacionWalker + ", turnoPaseo=" + turnoPaseo + ", fotoWalker=" + fotoWalker + ", fotoDNIWalker=" + fotoDNIWalker + ", activoWalker=" + activoWalker + '}';
    }

}
