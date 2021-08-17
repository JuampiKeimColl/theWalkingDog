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
import proyectoFinal_theWalkingDog.controladores.exceptions.PreexistingEntityException;
import proyectoFinal_theWalkingDog.entidades.Walker;

/**
 *
 * @author JP
 */
public class WalkerJpaController implements Serializable {

    public WalkerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Walker walker) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(walker);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findWalker(walker.getIdWalkerDNI()) != null) {
                throw new PreexistingEntityException("Walker " + walker + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Walker walker) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            walker = em.merge(walker);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = walker.getIdWalkerDNI();
                if (findWalker(id) == null) {
                    throw new NonexistentEntityException("The walker with id " + id + " no longer exists.");
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
            Walker walker;
            try {
                walker = em.getReference(Walker.class, id);
                walker.getIdWalkerDNI();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The walker with id " + id + " no longer exists.", enfe);
            }
            em.remove(walker);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Walker> findWalkerEntities() {
        return findWalkerEntities(true, -1, -1);
    }

    public List<Walker> findWalkerEntities(int maxResults, int firstResult) {
        return findWalkerEntities(false, maxResults, firstResult);
    }

    private List<Walker> findWalkerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Walker.class));
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

    public Walker findWalker(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Walker.class, id);
        } finally {
            em.close();
        }
    }

    public int getWalkerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Walker> rt = cq.from(Walker.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
