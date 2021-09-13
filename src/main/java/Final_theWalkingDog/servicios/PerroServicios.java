package Final_theWalkingDog.servicios;

import Final_theWalkingDog.entidades.Perro;
import Final_theWalkingDog.entidades.Usuario;
import Final_theWalkingDog.repositorio.PerroRepositorio;
import Final_theWalkingDog.repositorio.UsuarioRepositorio;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerroServicios {

    @Autowired
    private PerroRepositorio perroRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public void crearPerro(String idUsuario, String nombrePerro, String razaPerro,
            String tamanioPerro,
            String observacionPerro) throws Exception {

        Usuario usuario = usuarioRepositorio.findById(idUsuario).get();

        validar(nombrePerro, razaPerro, tamanioPerro);
        if (observacionPerro == null || observacionPerro.isEmpty()) {
            throw new Exception("Ingrese una mínima descripción de su mascota para facilitar la selección del Walker");
        }
        Perro perro1 = new Perro();

//        if (nacimientoPerro == null || nacimientoPerro.isEmpty()) {//la condición del Date?
//            throw new Exception("No se puede ingresar un nacimiento nulo");
//        }
//        if (bozalPerro == null || bozalPerro.isEmpty()) {//como era la condición booleana?
//            throw new Exception("No se puede seguir sin indicar el uso de bozal");
//        }
//        if (ddjjPerro == null || ddjjPerro.isEmpty()) {//lo mismo, cómo era el boolean?
//            throw new Exception("No se puede ingresar una ddjj nula");
//        }
        perro1.setNombrePerro(nombrePerro);
        perro1.setRazaPerro(razaPerro);
        perro1.setTamanioPerro(tamanioPerro);
        perro1.setObservacionPerro(observacionPerro);
        perro1.setFechaAltaPerro(new Date());
        perro1.setActivoPerro(true);
        perro1.setPuntuacionPerro(0);

        perroRepositorio.save(perro1);

    }

    public void validar(String nombrePerro, String razaPerro,
            String tamanioPerro) throws Exception {
        if (nombrePerro == null || nombrePerro.isEmpty()) {
            throw new Exception("No se puede ingresar un nombre nulo");
        }
        if (razaPerro == null || razaPerro.isEmpty()) {
            throw new Exception("No se puede ingresar una raza nula");
        }
        if (tamanioPerro == null || tamanioPerro.isEmpty()) {
            throw new Exception("No se puede ingresar un tamaño nulo");
        }
    }

    public void modificarPerro(String idUsuario, String idPerro,
            String nombrePerro, String razaPerro, String observacionPerro) throws Exception {
        validar(nombrePerro, razaPerro, observacionPerro);

        if (observacionPerro == null || observacionPerro.isEmpty()) {
            throw new Exception("Ingrese una mínima descripción de su mascota para facilitar la selección del Walker");
        }

        Optional<Perro> respuesta = perroRepositorio.findById(idPerro);
        if (respuesta.isPresent()) {

            Perro perro1 = respuesta.get();
            if (perro1.getUsuarioPerro().getIdUsuario().equals(idUsuario)) {

                perro1.setNombrePerro(nombrePerro);
                perro1.setRazaPerro(razaPerro);
                perro1.setObservacionPerro(observacionPerro);

                perroRepositorio.save(perro1);
            } else {
                throw new Exception("No tiene permisos suficientes para realizar la modificación.");
            }

        } else {
            throw new Exception("No existe un perro con el modificador solicitado");
        }
    }
//Acá tendría q traer el id del perro q busco para hacer la modificación tanto para deshab y hab

    public void deshabilitarPerro(String idUsuario, String idPerro) throws Exception {

        Optional<Perro> respuesta = perroRepositorio.findById(idPerro);
        if (respuesta.isPresent()) {
            Perro perro1 = respuesta.get();
            if (perro1.getUsuarioPerro().getIdUsuario().equals(idUsuario)) {

                perro1.setActivoPerro(false);
                perro1.setFechaModPerro(new Date());

                perroRepositorio.save(perro1);
            } else {
                throw new Exception("No tiene permisos suficientes para realizar la modificación.");
            }

        } else {
            throw new Exception("No existe un perro con el modificador solicitado");
        }
    }

    public void habilitarPerro(String idUsuario,String idPerro) throws Exception {
       Optional<Perro> respuesta = perroRepositorio.findById(idPerro);
        if (respuesta.isPresent()) {
            Perro perro1 = respuesta.get();
            if (perro1.getUsuarioPerro().getIdUsuario().equals(idUsuario)) {

                perro1.setActivoPerro(true);
                perro1.setFechaAltaPerro(new Date());

                perroRepositorio.save(perro1);
            } else {
                throw new Exception("No tiene permisos suficientes para realizar la modificación.");
            }

        } else {
            throw new Exception("No existe un perro con el modificador solicitado");
        }
    }
}
