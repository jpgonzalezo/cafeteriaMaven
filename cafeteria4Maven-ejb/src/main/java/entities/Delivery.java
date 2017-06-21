/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan Pablo
 */
@Entity
@Table(name = "delivery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Delivery.findAll", query = "SELECT d FROM Delivery d")
    , @NamedQuery(name = "Delivery.findByIddelivery", query = "SELECT d FROM Delivery d WHERE d.iddelivery = :iddelivery")
    , @NamedQuery(name = "Delivery.findByTimeBlock", query = "SELECT d FROM Delivery d WHERE d.timeBlock = :timeBlock")
    , @NamedQuery(name = "Delivery.findByDate", query = "SELECT d FROM Delivery d WHERE d.date = :date")
    , @NamedQuery(name = "Delivery.findByAvailability", query = "SELECT d FROM Delivery d WHERE d.availability = :availability")})
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddelivery")
    private Integer iddelivery;
    @Column(name = "time_block")
    private Integer timeBlock;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "availability")
    private Integer availability;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryIddelivery")
    private Collection<Orden> ordenCollection;

    public Delivery() {
    }

    public Delivery(Integer iddelivery) {
        this.iddelivery = iddelivery;
    }

    public Integer getIddelivery() {
        return iddelivery;
    }

    public void setIddelivery(Integer iddelivery) {
        this.iddelivery = iddelivery;
    }

    public Integer getTimeBlock() {
        return timeBlock;
    }

    public void setTimeBlock(Integer timeBlock) {
        this.timeBlock = timeBlock;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    @XmlTransient
    public Collection<Orden> getOrdenCollection() {
        return ordenCollection;
    }

    public void setOrdenCollection(Collection<Orden> ordenCollection) {
        this.ordenCollection = ordenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddelivery != null ? iddelivery.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delivery)) {
            return false;
        }
        Delivery other = (Delivery) object;
        if ((this.iddelivery == null && other.iddelivery != null) || (this.iddelivery != null && !this.iddelivery.equals(other.iddelivery))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Delivery[ iddelivery=" + iddelivery + " ]";
    }
    
}
