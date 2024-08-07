package io.codeforall.vimtages.persistence.dao;

import io.codeforall.vimtages.model.Group;
import io.codeforall.vimtages.persistence.GroupDao;

public class JpaGroupDao extends GenericJpaDao <Group> implements GroupDao {

    public JpaGroupDao(Class<Group> modelType) {
        super(modelType);
    }
}
