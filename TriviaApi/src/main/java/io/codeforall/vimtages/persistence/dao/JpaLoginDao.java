package io.codeforall.vimtages.persistence.dao;

import io.codeforall.vimtages.model.User;
import io.codeforall.vimtages.persistence.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JpaLoginDao extends GenericJpaDao<User> implements UserDao {

    private EntityManager entityManager;

    public JpaLoginDao(Class<User> modelType) {
        super(modelType);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User getUserByNameAndPassword(String name, String password) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);
        criteriaQuery.select(user).where(cb.equal(user.get("name"), name));
        criteriaQuery.select(user).where(cb.equal(user.get("password"), password));
        return em.createQuery(criteriaQuery).getSingleResult();
    }

    public User getUserByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);
        criteriaQuery.select(user).where(cb.equal(user.get("name"), name));
        return em.createQuery(criteriaQuery).getSingleResult();
    }



}
