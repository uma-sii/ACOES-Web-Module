package acoes;

import javax.persistence.*;

public class ACOES {
    public final static String PERSISTENCE_UNIT_NAME = "ACOES_PU";
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
    }
    
}
