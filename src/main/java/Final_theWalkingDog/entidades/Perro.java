package Final_theWalkingDog.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Perro implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idPerro;
    private String nombrePerro;
    @OneToOne
    private Foto fotoPerro;
    private String razaPerro;
    @Temporal(TemporalType.TIMESTAMP)
    private Date nacimientoPerro;
    private String tamanioPerro;
    private boolean bozalPerro;
    private String observacionPerro;
    private boolean ddjjPerro;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAltaPerro;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModPerro;
    private Paseo paseoPerro;
    @ManyToOne
    private Usuario usuarioPerro;
    private boolean activoPerro;
    @OneToOne
    private Comentarios comentarioPerro;
    private double puntuacionPerro;

    
    public String getIdPerro() {
        return idPerro;
    }

    public void setIdPerro(String idPerro) {
        this.idPerro = idPerro;
    }

    public String getNombrePerro() {
        return nombrePerro;
    }

    public void setNombrePerro(String nombrePerro) {
        this.nombrePerro = nombrePerro;
    }

    public Foto getFotoPerro() {
        return fotoPerro;
    }

    public void setFotoPerro(Foto fotoPerro) {
        this.fotoPerro = fotoPerro;
    }

    public String getRazaPerro() {
        return razaPerro;
    }

    public void setRazaPerro(String razaPerro) {
        this.razaPerro = razaPerro;
    }

    public Date getNacimientoPerro() {
        return nacimientoPerro;
    }

    public void setNacimientoPerro(Date nacimientoPerro) {
        this.nacimientoPerro = nacimientoPerro;
    }

    public String getTamanioPerro() {
        return tamanioPerro;
    }

    public void setTamanioPerro(String tamanioPerro) {
        this.tamanioPerro = tamanioPerro;
    }

    public boolean isBozalPerro() {
        return bozalPerro;
    }

    public void setBozalPerro(boolean bozalPerro) {
        this.bozalPerro = bozalPerro;
    }

    public String getObservacionPerro() {
        return observacionPerro;
    }

    public void setObservacionPerro(String observacionPerro) {
        this.observacionPerro = observacionPerro;
    }

    public boolean isDdjjPerro() {
        return ddjjPerro;
    }

    public void setDdjjPerro(boolean ddjjPerro) {
        this.ddjjPerro = ddjjPerro;
    }

    public Date getFechaAltaPerro() {
        return fechaAltaPerro;
    }

    public void setFechaAltaPerro(Date fechaAltaPerro) {
        this.fechaAltaPerro = fechaAltaPerro;
    }

    public Date getFechaModPerro() {
        return fechaModPerro;
    }

    public void setFechaModPerro(Date fechaModPerro) {
        this.fechaModPerro = fechaModPerro;
    }

    public Paseo getPaseoPerro() {
        return paseoPerro;
    }

    public void setPaseoPerro(Paseo paseoPerro) {
        this.paseoPerro = paseoPerro;
    }

    public Usuario getUsuarioPerro() {
        return usuarioPerro;
    }

    public void setUsuarioPerro(Usuario usuarioPerro) {
        this.usuarioPerro = usuarioPerro;
    }

    public boolean isActivoPerro() {
        return activoPerro;
    }

    public void setActivoPerro(boolean activoPerro) {
        this.activoPerro = activoPerro;
    }

    public Comentarios getComentarioPerro() {
        return comentarioPerro;
    }

    public void setComentarioPerro(Comentarios comentarioPerro) {
        this.comentarioPerro = comentarioPerro;
    }

    public double getPuntuacionPerro() {
        return puntuacionPerro;
    }

    public void setPuntuacionPerro(double puntuacionPerro) {
        this.puntuacionPerro = puntuacionPerro;
    }

    @Override
    public String toString() {
        return "Perro{" + "idPerro=" + idPerro + ", nombrePerro=" + nombrePerro + ", fotoPerro=" + fotoPerro + ", razaPerro=" + razaPerro + ", nacimientoPerro=" + nacimientoPerro + ", tamanioPerro=" + tamanioPerro + ", bozalPerro=" + bozalPerro + ", observacionPerro=" + observacionPerro + ", ddjjPerro=" + ddjjPerro + ", fechaAltaPerro=" + fechaAltaPerro + ", fechaModPerro=" + fechaModPerro + ", paseoPerro=" + paseoPerro + ", usuarioPerro=" + usuarioPerro + ", activoPerro=" + activoPerro + ", comentarioPerro=" + comentarioPerro + ", puntuacionPerro=" + puntuacionPerro + '}';
    }
    

}
