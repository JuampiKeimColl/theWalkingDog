package Final_theWalkingDog.servicios;

import Final_theWalkingDog.entidades.Foto;
import Final_theWalkingDog.entidades.Walker;
import Final_theWalkingDog.repositorio.WalkerRepositorio;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class WalkerServicios {

    @Autowired
    private WalkerRepositorio walkerRepositorio;

    @Autowired
    private FotoServicios fotoServicios;

    public void crearWalker(String IdWalkerDNI, String nombreWalker, String apellidoWalker, String correoWalker,
            String contraseniaWalker, String telefonoWalker, String direccionWalker, String barrioWalker,
            int manadaWalker, int precioPaseo) throws Exception {

        if (IdWalkerDNI == null || IdWalkerDNI.isEmpty()) {
            throw new Exception("No se puede ingresar un DNI nulo");
        }
        if (nombreWalker == null || nombreWalker.isEmpty()) {
            throw new Exception("No se puede ingresar un nombre nulo");
        }
        if (apellidoWalker == null || apellidoWalker.isEmpty()) {
            throw new Exception("No se puede ingresar un apellido nulo");
        }
        if (correoWalker == null || correoWalker.isEmpty()) {
            throw new Exception("No se puede ingresar un correo nulo");
        }
        if (contraseniaWalker == null || contraseniaWalker.isEmpty() || contraseniaWalker.length() < 6) {
            throw new Exception("No se puede ingresar un contraseña nula o menor a seis digitos");
        }
//        if (telefonoWalker == null || telefonoWalker.isEmpty()) {
//            throw new Exception("No se puede ingresar un teléfono nulo");
//        }
//        if (direccionWalker == null || direccionWalker.isEmpty()) {
//            throw new Exception("No se puede ingresar un dirección nulo");
//        }
//        if (barrioWalker == null || barrioWalker.isEmpty()) {
//            throw new Exception("No se puede ingresar un barrio nulo");
//        }

        Walker walker = new Walker();

        walker.setIdWalkerDNI(IdWalkerDNI);
        walker.setNombreWalker(nombreWalker);
        walker.setApellidoWalker(apellidoWalker);
        walker.setCorreoWalker(correoWalker);
        walker.setContraseniaWalker(contraseniaWalker);
        walker.setTelefonoWalker(telefonoWalker);
        walker.setDireccionWalker(direccionWalker);
        walker.setBarrioWalker(barrioWalker);
        walker.setManadaWalker(manadaWalker);
        Date hoy = new Date();
        walker.setFechaAltaWalker(hoy);
        walker.setFechaModWalker(hoy);
        walker.setPenalizacionWalker(10);
        walker.setPrecioPaseo(precioPaseo);
        walker.setActivoWalker(true);

//        Foto foto = fotoServicios.crearFoto(archivo1);
//        walker.setFotoDNIWalker(foto);
//        Foto foto1 = fotoServicios.crearFoto(archivo2);
//        walker.setFotoWalker(foto1);

        walkerRepositorio.save(walker);

    }

    public void modificarWalker(MultipartFile archivo, String id, String contrasenia, String direccion, String barrio,
            String telefono, int manadaWalker, double precioPaseo) throws Exception {

        if (id == null || id.isEmpty()) {
            throw new Exception("No se puede ingresar un DNI nulo");
        }
        if (contrasenia == null || contrasenia.isEmpty() || contrasenia.length() < 6) {
            throw new Exception("No se puede ingresar un contraseña nula o menor a seis digitos");
        }
        if (telefono == null || telefono.isEmpty()) {
            throw new Exception("No se puede ingresar un teléfono nulo");
        }
        if (direccion == null || direccion.isEmpty()) {
            throw new Exception("No se puede ingresar un dirección nulo");
        }
        if (barrio == null || barrio.isEmpty()) {
            throw new Exception("No se puede ingresar un barrio nulo");
        }
        if (manadaWalker == 0) {
            throw new Exception("No puede ingresar 0 ");
        }
        if (precioPaseo == 0) {
            throw new Exception("No se puede ingresar precio 0 ");
        }

        Optional<Walker> respuesta = walkerRepositorio.findById(id);
        if (respuesta.isPresent()) {

            Walker walker = respuesta.get();
            walker.setContraseniaWalker(contrasenia);
            walker.setBarrioWalker(barrio);
            walker.setDireccionWalker(direccion);
            walker.setTelefonoWalker(telefono);
            walker.setManadaWalker(manadaWalker);
            walker.setPrecioPaseo(precioPaseo);

            String idFoto = null;

            if (walker.getFotoWalker() != null) {
                idFoto = walker.getFotoWalker().getIdFoto();
            }
                Foto foto = fotoServicios.modificarFoto(idFoto, archivo);
                walker.setFotoWalker(foto);
            
            

            walkerRepositorio.save(walker);
        } else {
            throw new Exception("El Walker no fue encontrado");
        }

    }

    public void deshabilitarWalker(String id, String contrasenia) throws Exception {

        Optional<Walker> respuesta = walkerRepositorio.findById(id);
        if (respuesta.isPresent()) {

            Walker walker = respuesta.get();
            if (contrasenia.equals(walker.getContraseniaWalker())) {
                walker.setActivoWalker(false);
                walker.setFechaModWalker(new Date());

                walkerRepositorio.save(walker);
            }

        } else {
            throw new Exception("El Walker no fue encontrado");
        }

    }

    public void habilitarWalker(String id, String contrasenia) throws Exception {

        Optional<Walker> respuesta = walkerRepositorio.findById(id);
        if (respuesta.isPresent()) {

            Walker walker = respuesta.get();
            if (contrasenia.equals(walker.getContraseniaWalker())) {
                walker.setActivoWalker(true);
                walker.setFechaModWalker(null);

                walkerRepositorio.save(walker);
            }

        } else {
            throw new Exception("El Walker no fue encontrado");
        }
    }
}
