package Final_theWalkingDog.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Paseo implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idPaseo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicioPaseo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFinPaseo;

    private boolean conformidadPaseo;
    @ManyToOne
    private Perro perro;
    @ManyToOne
    private Walker walker;

    
    public String getIdPaseo() {
        return idPaseo;
    }

    public void setIdPaseo(String idPaseo) {
        this.idPaseo = idPaseo;
    }

    public Date getHoraInicioPaseo() {
        return horaInicioPaseo;
    }

    public void setHoraInicioPaseo(Date horaInicioPaseo) {
        this.horaInicioPaseo = horaInicioPaseo;
    }

    public Date getHoraFinPaseo() {
        return horaFinPaseo;
    }

    public void setHoraFinPaseo(Date horaFinPaseo) {
        this.horaFinPaseo = horaFinPaseo;
    }


    public boolean isConformidadPaseo() {
        return conformidadPaseo;
    }

    public void setConformidadPaseo(boolean conformidadPaseo) {
        this.conformidadPaseo = conformidadPaseo;
    }

    public Perro getPerro() {
        return perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }

    public Walker getWalker() {
        return walker;
    }

    public void setWalker(Walker walker) {
        this.walker = walker;
    }

    @Override
    public String toString() {
         return "Paseo{" + "idPaseo=" + idPaseo + ", horaInicioPaseo=" + horaInicioPaseo + ", horaFinPaseo=" + horaFinPaseo + ", conformidadPaseo=" + conformidadPaseo + ", perro=" + perro + ", walker=" + walker + '}';
         }

}
