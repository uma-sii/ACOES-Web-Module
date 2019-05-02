/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acoes.business;

import java.util.List;
import org.acoes.model.entity.SponsoredChild;
import org.acoes.model.entity.User;

/**
 * Business tier operations related to sponsorships.
 * @author Manuel
 */
public interface SponsorshipsFacade {
    public List<SponsoredChild> getSponsoredChildren(User user);
    public void applyForSponsorship(User user);
}