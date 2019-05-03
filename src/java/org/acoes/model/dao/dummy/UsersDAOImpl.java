/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acoes.model.dao.dummy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.acoes.model.entity.Administrator;
import org.acoes.model.entity.User;
import org.acoes.model.dao.UsersDAO;
import org.acoes.model.entity.Gender;
import org.acoes.model.entity.Sponsor;
import org.acoes.model.entity.SponsoredChild;

/**
 * This singleton class contains dummy data about users.
 * @author Manuel
 */
public class UsersDAOImpl implements UsersDAO {
    //Singleton
    private static UsersDAOImpl instance = null;
    
    // In-memory copy of data
    private List<User> users;
    
    private UsersDAOImpl(){
        init();
    }
    
    public static UsersDAOImpl getInstance(){
        if(instance == null){
            instance = new UsersDAOImpl();
        }
        return instance;
    }
    
    private void init(){
        
        users = new LinkedList<>();
        
        Administrator admin1 = new Administrator("johndoe@acoes.org", "12345");
        admin1.setWorkplace("ACOES España");
        
        Administrator admin2 = new Administrator("janedoe@acoes.org", "12345");
        admin1.setWorkplace("ACOES Honduras");
        
        users.add(admin1);
        users.add(admin2);
        
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
        
        users.add(cris);
        users.add(manuel);
        users.add(new Sponsor("miguel@gmail.com", "12345"));
        users.add(new Sponsor("alex@gmail.com", "12345"));
        users.add(new Sponsor("diego@gmail.com", "12345"));
        users.add(new Sponsor("luis@gmail.com", "12345"));
    }
    
    
    @Override
    public User findUser(String email) {
        User result = null;
        for(User u : users){
            if(u.getEmail().equals(email)){
                result = u;
                break;
            }
        }
        return result;
    }

    @Override
    public void saveUser(User user) {
        String email = user.getEmail();
        int idx = 0;
        boolean found = false;
        User temp = null;
        while(!found && idx < users.size()){
            temp = users.get(idx);
            if(temp.getEmail().equals(email)){
                users.set(idx, user);
                found = true;
            }
        }
        if(!found)
            users.add(user);
    }
    
}
