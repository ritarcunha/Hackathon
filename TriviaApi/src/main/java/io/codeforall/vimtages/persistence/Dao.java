package io.codeforall.vimtages.persistence;

import io.codeforall.vimtages.model.Model;

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
}
