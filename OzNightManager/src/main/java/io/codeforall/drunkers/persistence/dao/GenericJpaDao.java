package io.codeforall.drunkers.persistence.dao;

import io.codeforall.drunkers.model.Model;
import io.codeforall.drunkers.persistence.Dao;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericJpaDao<T extends Model> implements Dao<T> {
    protected Class<T> modelType;

    /*

    protected EntityManagerFactory emf= Persistence.createEntityManagerFactory("oznightmanager");

    @PersistenceContext
    protected EntityManager em = emf.createEntityManager();

    */

    @PersistenceContext
    protected EntityManager em;

    public GenericJpaDao(Class<T> modelType){
        this.modelType = modelType;
    }

    public  void setEm(EntityManager em){this.em = em;}

    @Override
    public List<T> findAll(){
        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
        Root<T> root = criteriaQuery.from(modelType);
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public T findById(Integer id){
        return em.find(modelType, id);
    }

    @Override
    public T saveOrUpdate(T modelObject) {
        return em.merge(modelObject);
    }

    @Override
    public void delete(T obj) {
        em.remove(obj);
    }

}
