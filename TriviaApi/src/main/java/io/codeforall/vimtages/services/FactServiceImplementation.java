package io.codeforall.vimtages.services;

import io.codeforall.vimtages.model.Facts;
import io.codeforall.vimtages.persistence.dao.JpaFactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FactServiceImplementation implements FactService {

    private JpaFactDao factDao;

    @Autowired
    public void setJpaFactDao(JpaFactDao factDao) {
        this.factDao = factDao;
    }

    @Override
    public Facts getFactById(Integer id) {
        return factDao.findById(id);
    }

    @Override
    public List<Facts> listAll() {
        return factDao.findAll();
    }
}
