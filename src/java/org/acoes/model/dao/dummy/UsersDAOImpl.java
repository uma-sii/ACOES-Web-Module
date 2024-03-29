package org.acoes.model.dao.dummy;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.acoes.model.dao.UsersDAO;
import org.acoes.model.entity.Administrator;
import org.acoes.model.entity.Sponsor;
import org.acoes.model.entity.RegisteredUser;

/**
 * This singleton class contains dummy data stored in the database about users.
 * @author Manuel
 */
@Stateless
public class UsersDAOImpl implements UsersDAO {
    //Singleton
    private static UsersDAOImpl instance = null;

    @PersistenceContext(unitName = "ACOESPU")
    private EntityManager em;
    
    public UsersDAOImpl(){ }
    
    public static UsersDAOImpl getInstance(){
        if(instance == null){
            instance = new UsersDAOImpl();
        }
        return instance;
    }
    
    @Override
    public RegisteredUser findUser(String email) {
        RegisteredUser result = em.find(Administrator.class, email);
        System.out.println("Looking for user: " + result + " [admin]");
        if(result == null){
            result = em.find(Sponsor.class, email);
            System.out.println("Looking for user: " + result + " [sponsor]");
        }
        return result;
    }

    @Override
    public void saveUser(RegisteredUser user) {
        RegisteredUser result = findUser(user.getEmail());
        if(result == null){
            em.persist(user);
        } else{
            em.merge(user);
        }
    }

    @Override
    public List<RegisteredUser> getUsers() {
        return em.createQuery("SELECT u FROM RegisteredUser u").getResultList();
    }
    
}
