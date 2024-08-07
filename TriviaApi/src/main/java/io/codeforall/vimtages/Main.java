package io.codeforall.vimtages;

import io.codeforall.vimtages.model.Category;
import io.codeforall.vimtages.model.Facts;
import io.codeforall.vimtages.persistence.dao.JpaFactDao;
import io.codeforall.vimtages.services.FactServiceImplementation;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("triviaapi");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Category category = new Category();
        category.setName("random");
        Facts fact1 = new Facts();
        Facts fact2 = new Facts();
        Facts fact3 = new Facts();
        fact1.setFact("poopi 1");
        fact2.setFact("poopi 2");
        fact3.setFact("poopi 3");

        fact1.setCategory(category);
        fact2.setCategory(category);
        fact3.setCategory(category);

        em.persist(category);
        em.persist(fact1);
        em.persist(fact2);
        em.persist(fact3);
        em.getTransaction().commit();

         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("triviaapi");
        EntityManager em = emf.createEntityManager();
        FactServiceImplementation factService = new FactServiceImplementation();
        JpaFactDao jpaFactDao = new JpaFactDao();
        jpaFactDao.setEm(em);
        factService.setJpaFactDao(jpaFactDao);
        List<Facts> factsList = factService.listAll();

        factsList.forEach(facts -> System.out.println(facts.getFact()));
    }
}