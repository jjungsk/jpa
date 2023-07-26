package jpabasic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.h2.mvstore.tx.Transaction;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello JPA!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Member member = new Member(1L, "정하나");
            em.persist(member);

            tx.commit();
        } catch (Exception exception) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
