package io.codeforall.drunkers.persistence;



import io.codeforall.drunkers.model.Model;

import java.util.List;

public interface Dao<T extends Model> {
    /**
     * Gets list of model type
     * @return model list
     */
    List<T> findAll();

    /**
     * Gets model by id
     * @param id
     * @return the model
     */
    T findById(Integer id);

    T saveOrUpdate(T modelObject);

    void delete(T obj);
}
