
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
public class DummyDataGenerator {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ACOESPU");
        EntityManager em = emf.createEntityManager();
        
        // Dummy data
        User[] users = new User[]{
            new User("cris@gmail.com", "jeje"),
            new User("malorev@gmail.com", "123"),
            new User("admin@acoes.com", "admin")
        };
       
        em.getTransaction().begin();
        for(User u : users)
            em.persist(u);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
