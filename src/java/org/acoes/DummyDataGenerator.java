package org.acoes;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.acoes.model.entity.Administrator;
import org.acoes.model.entity.Gender;
import org.acoes.model.entity.Sponsor;
import org.acoes.model.entity.SponsoredChild;

/**
 *
 * @author Manuel
 */
public class DummyDataGenerator {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ACOESPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        Administrator admin1 = new Administrator("johndoe@acoes.org", "12345");
        admin1.setWorkplace("ACOES España");
        admin1.setAdminGroup("");
        
        Administrator admin2 = new Administrator("janedoe@acoes.org", "12345");
        admin2.setWorkplace("ACOES Honduras");
        admin2.setAdminGroup("");
        
        em.persist(admin1);
        em.persist(admin2);
        
        Sponsor cris = new Sponsor("cris@gmail.com", "12345");
        List<SponsoredChild> cris_children = new LinkedList<>();
        cris_children.add(new SponsoredChild("Juan", "López", Gender.MALE, "C/ Olancho 12", "Talanga", "Honduras"));
        cris_children.add(new SponsoredChild("Ana", "Acosta", Gender.FEMALE, "C/ Trujillo 7", "La Ceiba", "Honduras"));
        cris.setSponsoredChildren(cris_children);
        cris.setDNI("12345A");
        cris.setFirstName("Cristian");
        cris.setLastName("Cardas");
        cris.setGender(Gender.MALE);
        cris.setCity("Málaga");
        cris.setCountry("España");
        cris.setZipcode(12345);
        cris.setPhoneNumber("650123456");
        
        Sponsor manuel = new Sponsor("manuel@gmail.com", "12345");
        List<SponsoredChild> manuel_children = new LinkedList<>();
        manuel_children.add(new SponsoredChild("Luis", "Lagos", Gender.MALE, "C/ Olancho 20", "Talanga", "Honduras"));
        manuel_children.add(new SponsoredChild("Rosa", "Matute", Gender.FEMALE, "C/ Trujillo 2", "La Ceiba", "Honduras"));
        manuel.setSponsoredChildren(manuel_children);
        manuel.setDNI("54321C");
        manuel.setFirstName("Manuel");
        manuel.setLastName("López");
        manuel.setGender(Gender.MALE);
        manuel.setCity("Málaga");
        manuel.setCountry("España");
        manuel.setZipcode(12345);
        manuel.setPhoneNumber("659876543");
        
        em.persist(cris);
        em.persist(manuel);
        em.persist(new Sponsor("miguel@gmail.com", "12345"));
        em.persist(new Sponsor("alex@gmail.com", "12345"));
        em.persist(new Sponsor("diego@gmail.com", "12345"));
        em.persist(new Sponsor("luis@gmail.com", "12345"));
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
