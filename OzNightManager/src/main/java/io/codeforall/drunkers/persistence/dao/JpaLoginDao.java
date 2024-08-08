package io.codeforall.drunkers.persistence.dao;

import io.codeforall.drunkers.model.User;
import io.codeforall.drunkers.persistence.UserDao;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class JpaLoginDao extends GenericJpaDao<User> implements UserDao {

    public JpaLoginDao() {
        super(User.class);
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
