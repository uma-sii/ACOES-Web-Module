package org.acoes.business.impl;

import java.util.List;
import org.acoes.business.SponsorshipsFacade;
import org.acoes.model.dao.UsersDAO;
import org.acoes.model.entity.Sponsor;
import org.acoes.model.entity.SponsoredChild;
import org.acoes.model.entity.RegisteredUser;

/**
 * @author Manuel
 */
public class SponsorshipsFacadeImpl implements SponsorshipsFacade {
    //Singleton
    private static SponsorshipsFacadeImpl instance = null;
    
    private UsersDAO usersDAO;
    
    private SponsorshipsFacadeImpl(){}
    
    public static SponsorshipsFacadeImpl getInstance(){
        if(instance == null){
            instance = new SponsorshipsFacadeImpl();
        }
        return instance;
    }
    
    public void setUsersDAO(UsersDAO dao){
        usersDAO = dao;
    }
    
    public UsersDAO getUsersDAO(){
        return usersDAO;
    }
    
    @Override
    public List<SponsoredChild> getSponsoredChildren(RegisteredUser user) {
        Sponsor sponsor = (Sponsor)usersDAO.findUser(user.getEmail());
        return sponsor.getSponsoredChildren();
    }

    @Override
    public void applyForSponsorship(RegisteredUser user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
