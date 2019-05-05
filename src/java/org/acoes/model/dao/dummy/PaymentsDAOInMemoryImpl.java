
package org.acoes.model.dao.dummy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.acoes.model.entity.Administrator;
import org.acoes.model.entity.RegisteredUser;
import org.acoes.model.dao.PaymentsDAO;
import org.acoes.model.entity.Gender;
import org.acoes.model.entity.Payment;
import org.acoes.model.entity.Sponsor;
import org.acoes.model.entity.SponsoredChild;

/**
 * This singleton class contains dummy data stored in memory about payments.
 * @author Manuel
 */
public class PaymentsDAOInMemoryImpl implements PaymentsDAO {
    //Singleton
    private static PaymentsDAOInMemoryImpl instance = null;
    
    // In-memory copy of data
    private List<Payment> payments;
    
    private final static int ANNUAL_QUOTA = 100, MONTHLY_QUOTA = 50;
    
    private String[] CONCEPTS = new String[]{ "Donation", "Sponsorship (Year quota)", "Sponsorship (Monthly quota)" };
    
    private PaymentsDAOInMemoryImpl(){
        init();
    }
    
    public static PaymentsDAOInMemoryImpl getInstance(){
        if(instance == null){
            instance = new PaymentsDAOInMemoryImpl();
        }
        return instance;
    }
    
    private void init(){
        payments = new LinkedList<>();
        List<RegisteredUser> users = UsersDAOInMemoryImpl.getInstance().getUsers();
        int type = 0;
        int quantity = 0;
        for(RegisteredUser u : users){
            type = new Random().nextInt(3);
            switch(type){
                case 0:
                    quantity = new Random().nextInt(100) + 1;
                    break;
                case 1:
                    quantity = ANNUAL_QUOTA;
                    break;
                case 2:
                    quantity = MONTHLY_QUOTA;
                    break;
            }
            payments.add(new Payment(u, quantity, CONCEPTS[type]));
        }
    }
    
    @Override
    public List<Payment> getAllPayments() {
        return payments;
    }

    @Override
    public List<Payment> getUserPayments(RegisteredUser benefactor) {
        return payments.stream()
                       .filter(payment -> payment.getBenefactor().equals(benefactor))
                       .collect(Collectors.toList());
    }
    
}
