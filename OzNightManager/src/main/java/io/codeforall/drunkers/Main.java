package io.codeforall.drunkers;


import io.codeforall.drunkers.persistence.dao.JpaGroupDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {



        EntityManagerFactory emf = Persistence.createEntityManagerFactory("oznightmanager");
        EntityManager em = emf.createEntityManager();

        JpaGroupDao jpaGroupDao = new JpaGroupDao();
        jpaGroupDao.setEm(em);

        System.out.println(jpaGroupDao.findAll());



    }
}