package io.codeforall.vimtages.services;

import io.codeforall.vimtages.model.Facts;

import java.util.List;

public interface FactService {
    /**
     *
     * @param id
     * @return fact by id
     */
    Facts getFactById(Integer id);

    /**
     * Lists All facts
     */
    List<Facts> listAll();
}
