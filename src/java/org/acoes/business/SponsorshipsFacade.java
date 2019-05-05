package org.acoes.business;

import java.util.List;
import org.acoes.model.entity.SponsoredChild;
import org.acoes.model.entity.RegisteredUser;

/**
 * Business tier operations related to sponsorships.
 * @author Manuel
 */
public interface SponsorshipsFacade {
    public List<SponsoredChild> getSponsoredChildren(RegisteredUser user);
    public void applyForSponsorship(RegisteredUser user);
}
