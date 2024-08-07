package io.codeforall.vimtages;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("oznightmanager");
        EntityManager em = emf.createEntityManager();



    }
}