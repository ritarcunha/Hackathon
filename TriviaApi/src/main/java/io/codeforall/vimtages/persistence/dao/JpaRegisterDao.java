package io.codeforall.vimtages.persistence.dao;

import io.codeforall.vimtages.model.User;
import io.codeforall.vimtages.persistence.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JpaRegisterDao extends GenericJpaDao<User> implements UserDao {

    private EntityManager entityManager;

    public JpaRegisterDao(Class<User> modelType) {
        super(modelType);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean checkUserExists(User userInput) {
        String username = userInput.getUsername();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);
        criteriaQuery.select(user).where(cb.equal(user.get("name"), username));
        return em.createQuery(criteriaQuery).getSingleResult() != null;
    }

}
