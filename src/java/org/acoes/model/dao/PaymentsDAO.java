package org.acoes.model.dao;

import java.util.List;
import org.acoes.model.entity.Payment;
import org.acoes.model.entity.RegisteredUser;

/**
 *
 * @author Manuel
 */
public interface PaymentsDAO {
    List<Payment> getAllPayments();
    List<Payment> getUserPayments(RegisteredUser benefactor);
}
