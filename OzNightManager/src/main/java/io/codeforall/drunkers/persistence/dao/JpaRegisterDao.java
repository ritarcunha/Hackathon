package io.codeforall.drunkers.persistence.dao;

import io.codeforall.drunkers.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class JpaRegisterDao extends GenericJpaDao<User>  {

    public JpaRegisterDao() {
        super(User.class);
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
