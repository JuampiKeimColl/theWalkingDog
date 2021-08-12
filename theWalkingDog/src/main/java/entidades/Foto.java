/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

@Entity
public class Foto {
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

}
