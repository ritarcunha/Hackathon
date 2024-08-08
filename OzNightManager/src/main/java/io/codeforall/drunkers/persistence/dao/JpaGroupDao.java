package io.codeforall.drunkers.persistence.dao;

import io.codeforall.drunkers.model.Group;
import io.codeforall.drunkers.model.User;
import io.codeforall.drunkers.persistence.GroupDao;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class JpaGroupDao extends GenericJpaDao <Group> implements GroupDao {

    public JpaGroupDao() {
        super(Group.class);
    }

    public List<User> listGroupsByUserId(Integer id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);
        criteriaQuery.select(user).where(cb.equal(user.get("id"), id));
        return em.createQuery(criteriaQuery).getResultList();
    }
}
