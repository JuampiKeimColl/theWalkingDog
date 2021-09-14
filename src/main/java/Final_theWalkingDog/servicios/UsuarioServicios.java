package Final_theWalkingDog.servicios;

import Final_theWalkingDog.entidades.Usuario;
import Final_theWalkingDog.repositorio.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicios implements UserDetailsService{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public void crearUsuario(String nombre, String apellido, String id, 
            String correo, String contrasenia, String telefono, String direccion, 
            String barrio) throws Exception {

        if (id == null || id.isEmpty()) {
            throw new Exception("No se puede ingresar un DNI nulo");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new Exception("No se puede ingresar un nombre nulo");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new Exception("No se puede ingresar un apellido nulo");
        }
        if (correo == null || correo.isEmpty()) {
            throw new Exception("No se puede ingresar un correo nulo");
        }
        if (contrasenia == null || contrasenia.isEmpty() || contrasenia.length() < 6) {
            throw new Exception("No se puede ingresar un contraseña nula o menor a seis digitos");
        }
//        if (telefono == null || telefono.isEmpty()) {
//            throw new Exception("No se puede ingresar un teléfono nulo");
//        }
//        if (direccion == null || direccion.isEmpty()) {
//            throw new Exception("No se puede ingresar un dirección nulo");
//        }
//        if (barrio == null || barrio.isEmpty()) {
//            throw new Exception("No se puede ingresar un barrio nulo");
//        }

        Usuario usuario1 = new Usuario();
        usuario1.setNombreUsuario(nombre);
        usuario1.setApellidoUsuario(apellido);
        usuario1.setIdUsuario(id);
        usuario1.setCorreoUsuario(correo);
        usuario1.setContraseniaUsuario(contrasenia);
        usuario1.setTelefonoUsuario(telefono);
        usuario1.setDireccionUsuario(direccion);
        usuario1.setBarrioUsuario(barrio);
        usuario1.setFechaAltaUsuario(new Date());
        usuario1.setActivoUsuario(true);

        usuarioRepositorio.save(usuario1);

    }

    public void modificarUsuario(String id, String contrasenia, String direccion, String barrio, String telefono) throws Exception {

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
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {

            Usuario usuario1 = respuesta.get();
            usuario1.setContraseniaUsuario(contrasenia);
            usuario1.setBarrioUsuario(barrio);
            usuario1.setDireccionUsuario(direccion);
            usuario1.setTelefonoUsuario(telefono);

            usuarioRepositorio.save(usuario1);
        } else {
            throw new Exception("El usuario no fue encontrado");
        }

    }

    public void deshabilitarUsuario(String id, String contrasenia) throws Exception {

        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {

            Usuario usuario1 = respuesta.get();
            if (contrasenia.equals(usuario1.getContraseniaUsuario())) {
                usuario1.setActivoUsuario(false);
                usuario1.setFechaModUsuario(new Date());

                usuarioRepositorio.save(usuario1);
            }

        } else {
            throw new Exception("La editorial no fue encontrada");
        }
    }
    
      public void habilitarUsuario(String id, String contrasenia) throws Exception {

        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {

            Usuario usuario1 = respuesta.get();
            if (contrasenia.equals(usuario1.getContraseniaUsuario())) {
                usuario1.setActivoUsuario(true);
                usuario1.setFechaModUsuario(null);

                usuarioRepositorio.save(usuario1);
            }

        } else {
            throw new Exception("La editorial no fue encontrada");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Usuario usuario1 = usuarioRepositorio.buscarPorEmail(email);
		
		if (usuario1 != null) {
			List<GrantedAuthority> permissions = new ArrayList<>();
			GrantedAuthority p = new SimpleGrantedAuthority("ROLE_USUARIO_REGISTRADO");
			permissions.add(p);
//			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//			HttpSession session = attr.getRequest().getSession(true);
//			session.setAttribute("usuario", usuario1);
                        User user = new User (usuario1.getCorreoUsuario(), usuario1.getContraseniaUsuario(), permissions);
			return user;
		}else {
                    return null;
                }

         } }
