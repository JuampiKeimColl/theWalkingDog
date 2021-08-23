package Final_theWalkingDog.servicios;

import Final_theWalkingDog.entidades.Perro;
import Final_theWalkingDog.repositorio.PerroRepositorio;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerroServicios {

    @Autowired
    private PerroRepositorio perroRepositorio;

    public void crearPerro(String nombrePerro, String razaPerro,
            Date nacimientoPerro, String tamanioPerro, boolean bozalPerro,
            String observacionPerro, boolean ddjjPerro) throws Exception {

        Perro perro1 = new Perro();

        if (nombrePerro == null || nombrePerro.isEmpty()) {
            throw new Exception("No se puede ingresar un nombre nulo");
        }
        if (razaPerro == null || razaPerro.isEmpty()) {
            throw new Exception("No se puede ingresar una raza nula");
        }
//        if (nacimientoPerro == null || nacimientoPerro.isEmpty()) {//la condición del Date?
//            throw new Exception("No se puede ingresar un nacimiento nulo");
//        }
        if (tamanioPerro == null || tamanioPerro.isEmpty()) {
            throw new Exception("No se puede ingresar un tamaño nulo");
        }
//        if (bozalPerro == null || bozalPerro.isEmpty()) {//como era la condición booleana?
//            throw new Exception("No se puede seguir sin indicar el uso de bozal");
//        }
        if (observacionPerro == null || observacionPerro.isEmpty()) {
            throw new Exception("Ingrese una mínima descripción de su mascota para facilitar la selección del Walker");
        }
//        if (ddjjPerro == null || ddjjPerro.isEmpty()) {//lo mismo, cómo era el boolean?
//            throw new Exception("No se puede ingresar una ddjj nula");
//        }

        perro1.setNombrePerro(nombrePerro);
        perro1.setRazaPerro(razaPerro);
        perro1.setNacimientoPerro(nacimientoPerro);
        perro1.setTamanioPerro(tamanioPerro);
        perro1.setBozalPerro(bozalPerro);
        perro1.setObservacionPerro(observacionPerro);
        perro1.setDdjjPerro(ddjjPerro);
        perro1.setFechaAltaPerro(new Date());
        perro1.setActivoPerro(true);
        perro1.setPuntuacionPerro(0);
        perroRepositorio.save(perro1);

    }

    public void modificarPerro(String nombrePerro, String razaPerro, String observacionPerro) throws Exception {

        if (nombrePerro == null || nombrePerro.isEmpty()) {
            throw new Exception("No se puede ingresar un nombre nulo");
        }
        if (razaPerro == null || razaPerro.isEmpty()) {
            throw new Exception("No se puede ingresar una raza nula");
        }
        if (observacionPerro == null || observacionPerro.isEmpty()) {
            throw new Exception("Ingrese una mínima descripción de su mascota para facilitar la selección del Walker");
        }

        Optional<Perro> respuesta = perroRepositorio.findById(nombrePerro);
        if (respuesta.isPresent()) {

            Perro perro1 = new Perro();
            perro1.setNombrePerro(nombrePerro);
            perro1.setRazaPerro(razaPerro);
            perro1.setObservacionPerro(observacionPerro);

            perroRepositorio.save(perro1);
        }
    }
//Acá tendría q traer el id del perro q busco para hacer la modificación tanto para deshab y hab

    public void deshabilitarPerro(String nombrePerro) throws Exception {
        Optional<Perro> respuesta = perroRepositorio.findById(nombrePerro);
        if (respuesta.isPresent()) {

            Perro perro1 = new Perro();
            perro1.setActivoPerro(false);
            perro1.setFechaModPerro(new Date());

            perroRepositorio.save(perro1);
        }
    }

    public void habilitarPerro(String nombrePerro) throws Exception {
        Optional<Perro> respuesta = perroRepositorio.findById(nombrePerro);
        if(respuesta.isPresent()){
            Perro perro1 =new Perro();
            perro1.setActivoPerro(true);
            perro1.setFechaModPerro(null);
            
            perroRepositorio.save(perro1);
        }
    }
}
