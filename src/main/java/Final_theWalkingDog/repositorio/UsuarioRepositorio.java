/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_theWalkingDog.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Final_theWalkingDog.entidades.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author JP
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,String> {
    
    @Query("SELECT a from Usuario a WHERE a.email LIKE :email AND a.activo = true")
	public Usuario buscarPorEmail(@Param("email") String email);
    
    
}
