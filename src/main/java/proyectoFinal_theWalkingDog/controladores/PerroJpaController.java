/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoFinal_theWalkingDog.controladores;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import proyectoFinal_theWalkingDog.controladores.exceptions.NonexistentEntityException;
import proyectoFinal_theWalkingDog.entidades.Perro;
import proyectoFinal_theWalkingDog.entidades.Usuario;

/**
 *
 * @author JP
 */
public class PerroJpaController implements Serializable {

    public PerroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Perro perro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuarioPerro = perro.getUsuarioPerro();
            if (usuarioPerro != null) {
                usuarioPerro = em.getReference(usuarioPerro.getClass(), usuarioPerro.getIdUsuario());
                perro.setUsuarioPerro(usuarioPerro);
            }
            em.persist(perro);
            if (usuarioPerro != null) {
                usuarioPerro.getPerro().add(perro);
                usuarioPerro = em.merge(usuarioPerro);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Perro perro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Perro persistentPerro = em.find(Perro.class, perro.getIdPerro());
            Usuario usuarioPerroOld = persistentPerro.getUsuarioPerro();
            Usuario usuarioPerroNew = perro.getUsuarioPerro();
            if (usuarioPerroNew != null) {
                usuarioPerroNew = em.getReference(usuarioPerroNew.getClass(), usuarioPerroNew.getIdUsuario());
                perro.setUsuarioPerro(usuarioPerroNew);
            }
            perro = em.merge(perro);
            if (usuarioPerroOld != null && !usuarioPerroOld.equals(usuarioPerroNew)) {
                usuarioPerroOld.getPerro().remove(perro);
                usuarioPerroOld = em.merge(usuarioPerroOld);
            }
            if (usuarioPerroNew != null && !usuarioPerroNew.equals(usuarioPerroOld)) {
                usuarioPerroNew.getPerro().add(perro);
                usuarioPerroNew = em.merge(usuarioPerroNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = perro.getIdPerro();
                if (findPerro(id) == null) {
                    throw new NonexistentEntityException("The perro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Perro perro;
            try {
                perro = em.getReference(Perro.class, id);
                perro.getIdPerro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The perro with id " + id + " no longer exists.", enfe);
            }
            Usuario usuarioPerro = perro.getUsuarioPerro();
            if (usuarioPerro != null) {
                usuarioPerro.getPerro().remove(perro);
                usuarioPerro = em.merge(usuarioPerro);
            }
            em.remove(perro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Perro> findPerroEntities() {
        return findPerroEntities(true, -1, -1);
    }

    public List<Perro> findPerroEntities(int maxResults, int firstResult) {
        return findPerroEntities(false, maxResults, firstResult);
    }

    private List<Perro> findPerroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Perro.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Perro findPerro(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Perro.class, id);
        } finally {
            em.close();
        }
    }

    public int getPerroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Perro> rt = cq.from(Perro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
