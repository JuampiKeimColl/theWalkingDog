/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoFinal_theWalkingDog.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyectoFinal_theWalkingDog.entidades.Comentarios;

/**
 *
 * @author JP
 */
@Repository
public interface ComentariosRepositorio extends JpaRepository<Comentarios, String>{
    
}
