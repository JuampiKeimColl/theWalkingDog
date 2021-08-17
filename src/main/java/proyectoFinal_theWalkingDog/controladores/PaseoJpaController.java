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
import proyectoFinal_theWalkingDog.entidades.Paseo;
import proyectoFinal_theWalkingDog.entidades.Perro;
import proyectoFinal_theWalkingDog.entidades.Walker;

/**
 *
 * @author JP
 */
public class PaseoJpaController implements Serializable {

    public PaseoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paseo paseo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Perro perro = paseo.getPerro();
            if (perro != null) {
                perro = em.getReference(perro.getClass(), perro.getIdPerro());
                paseo.setPerro(perro);
            }
            Walker walker = paseo.getWalker();
            if (walker != null) {
                walker = em.getReference(walker.getClass(), walker.getIdWalkerDNI());
                paseo.setWalker(walker);
            }
            em.persist(paseo);
            if (perro != null) {
                perro.getPaseoPerro().add(paseo);
                perro = em.merge(perro);
            }
            if (walker != null) {
                walker.getTurnoPaseo().add(paseo);
                walker = em.merge(walker);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paseo paseo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paseo persistentPaseo = em.find(Paseo.class, paseo.getIdPaseo());
            Perro perroOld = persistentPaseo.getPerro();
            Perro perroNew = paseo.getPerro();
            Walker walkerOld = persistentPaseo.getWalker();
            Walker walkerNew = paseo.getWalker();
            if (perroNew != null) {
                perroNew = em.getReference(perroNew.getClass(), perroNew.getIdPerro());
                paseo.setPerro(perroNew);
            }
            if (walkerNew != null) {
                walkerNew = em.getReference(walkerNew.getClass(), walkerNew.getIdWalkerDNI());
                paseo.setWalker(walkerNew);
            }
            paseo = em.merge(paseo);
            if (perroOld != null && !perroOld.equals(perroNew)) {
                perroOld.getPaseoPerro().remove(paseo);
                perroOld = em.merge(perroOld);
            }
            if (perroNew != null && !perroNew.equals(perroOld)) {
                perroNew.getPaseoPerro().add(paseo);
                perroNew = em.merge(perroNew);
            }
            if (walkerOld != null && !walkerOld.equals(walkerNew)) {
                walkerOld.getTurnoPaseo().remove(paseo);
                walkerOld = em.merge(walkerOld);
            }
            if (walkerNew != null && !walkerNew.equals(walkerOld)) {
                walkerNew.getTurnoPaseo().add(paseo);
                walkerNew = em.merge(walkerNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = paseo.getIdPaseo();
                if (findPaseo(id) == null) {
                    throw new NonexistentEntityException("The paseo with id " + id + " no longer exists.");
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
            Paseo paseo;
            try {
                paseo = em.getReference(Paseo.class, id);
                paseo.getIdPaseo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paseo with id " + id + " no longer exists.", enfe);
            }
            Perro perro = paseo.getPerro();
            if (perro != null) {
                perro.getPaseoPerro().remove(paseo);
                perro = em.merge(perro);
            }
            Walker walker = paseo.getWalker();
            if (walker != null) {
                walker.getTurnoPaseo().remove(paseo);
                walker = em.merge(walker);
            }
            em.remove(paseo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paseo> findPaseoEntities() {
        return findPaseoEntities(true, -1, -1);
    }

    public List<Paseo> findPaseoEntities(int maxResults, int firstResult) {
        return findPaseoEntities(false, maxResults, firstResult);
    }

    private List<Paseo> findPaseoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paseo.class));
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

    public Paseo findPaseo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paseo.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaseoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paseo> rt = cq.from(Paseo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
