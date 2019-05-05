package org.acoes.business;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import org.acoes.model.dao.PaymentsDAO;
import org.acoes.model.entity.Payment;
import org.acoes.model.entity.RegisteredUser;

/**
 *
 * @author Manuel
 */
public interface PaymentsFacade {
    public List<Payment> getAllPayments();
    
    public Stats getStats();
    
    public class Stats{
        private List<Payment> payments;
        
        public Stats(PaymentsDAO src){
            payments = src.getAllPayments();
        }
        
        public int totalAmount(){
            int sum = 0;
            for(Payment p : payments)
                sum += p.getAmount();
            return sum;
        }
        
        public int numberOfBenefactors(){
            Set<RegisteredUser> benefactors = new HashSet<>();
            for(Payment p : payments)
                benefactors.add(p.getBenefactor());
            return benefactors.size();
        }
        
        public List<Payment> getPayments(){
            return payments;
        }
    }
}
