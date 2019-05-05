package org.acoes.business;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        private final List<Payment> payments;
        
        public Stats(PaymentsDAO src){
            payments = src.getAllPayments();
        }
        
        public int totalAmount(){
            int sum = 0;
            sum = payments.stream().map((p) -> p.getAmount()).reduce(sum, Integer::sum);
            return sum;
        }
        
        public int numberOfBenefactors(){
            Set<RegisteredUser> benefactors = new HashSet<>();
            payments.forEach((p) -> {
                benefactors.add(p.getBenefactor());
            });
            return benefactors.size();
        }
        
        public List<Payment> getPayments(){
            return payments;
        }
    }
}
