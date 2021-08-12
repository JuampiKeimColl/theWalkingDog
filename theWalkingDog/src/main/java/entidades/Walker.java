/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javax.persistence.Entity;

@Entity
public class Walker {
    
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
    private Comentarios comentraioWalker;
    private int penalizacionWalker;
    private Paseo turnoPaseo;
    @OneToOne
    private Foto fotoWalker;
    @OneToOne
    private Foto fotoDNIWalker;
    private boolean activoWalker;
    
    
}
