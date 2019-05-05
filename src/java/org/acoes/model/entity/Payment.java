package org.acoes.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Manuel
 */
@Entity
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;
    
    private int amount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentTimestamp;
    private String paymentMethod;
    private String concept;
    @OneToOne
    private RegisteredUser benefactor;

    public Payment(){}
    
    public Payment(RegisteredUser benefactor, int amount, String concept){
        this.benefactor = benefactor;
        this.amount = amount;
        this.concept = concept;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public RegisteredUser getBenefactor() {
        return benefactor;
    }

    public void setBenefactor(RegisteredUser benefactor) {
        this.benefactor = benefactor;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return paymentTimestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.paymentTimestamp = timestamp;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "acoes.models.Payment[ id=" + id + " ]";
    }
    
}
