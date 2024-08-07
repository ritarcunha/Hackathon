package io.codeforall.vimtages.persistence.dao;

import io.codeforall.vimtages.model.Model;
import io.codeforall.vimtages.persistence.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericJpaDao<T extends Model> implements Dao<T> {
    protected Class<T> modelType;
    protected EntityManagerFactory emf= Persistence.createEntityManagerFactory("triviaapi");
    @PersistenceContext
    protected EntityManager em = emf.createEntityManager();

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


}
