package io.codeforall.vimtages.persistence.dao;

import io.codeforall.vimtages.model.Facts;
import io.codeforall.vimtages.persistence.FactDao;
import org.springframework.stereotype.Repository;

@Repository
public class JpaFactDao extends GenericJpaDao<Facts> implements FactDao {
    public JpaFactDao() {
        super(Facts.class);
    }

}
