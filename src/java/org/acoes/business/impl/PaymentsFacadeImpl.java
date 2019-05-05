
package org.acoes.business.impl;

import java.util.List;
import org.acoes.business.PaymentsFacade;
import org.acoes.model.dao.PaymentsDAO;
import org.acoes.model.entity.Payment;

/**
 *
 * @author Manuel
 */
public class PaymentsFacadeImpl implements PaymentsFacade {

    //Singleton
    private static PaymentsFacadeImpl instance = null;
    
    private PaymentsDAO paymentsDAO;
    
    private PaymentsFacadeImpl(){}
    
    public static PaymentsFacadeImpl getInstance(){
        if(instance == null){
            instance = new PaymentsFacadeImpl();
        }
        return instance;
    }
    
    public void setPaymentsDAO(PaymentsDAO dao){
        paymentsDAO = dao;
    }
    
    public PaymentsDAO getPaymentsDAO(){
        return paymentsDAO;
    }
    
    @Override
    public List<Payment> getAllPayments() {
        return paymentsDAO.getAllPayments();
    }

    @Override
    public Stats getStats() {
        return new Stats(paymentsDAO);
    }
    
}
