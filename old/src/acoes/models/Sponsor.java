package acoes.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.*;
import javax.persistence.OneToMany;

/**
 *
 * @author Manuel
 */
@Entity
public class Sponsor extends User {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // dni
    
    private String address;
    private String city;
    private String country;
    private int zipcode;
    
    private String phoneNumber;
    
    private Gender gender;
    
    private String firstName;
    private String lastName;
    
    @OneToMany
    private List<SponsoredChild> sponsoredChildren;
    
    @OneToMany
    private List<Payment> payments;
    
    public Long getDNI() {
        return id;
    }
    
    public void setDNI(Long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender g) {
        this.gender = g;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public void setPhoneNumber(String number) {
        this.phoneNumber = number;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
    
    public List<SponsoredChild> getSponsoredChildren() {
        return sponsoredChildren;
    }

    public void setSponsoredChildren(List<SponsoredChild> sponsoredChildren) {
        this.sponsoredChildren = sponsoredChildren;
    }
    
    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sponsor)) {
            return false;
        }
        Sponsor other = (Sponsor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoes.models.Sponsor[ id=" + id + " ]";
    }
    
}
