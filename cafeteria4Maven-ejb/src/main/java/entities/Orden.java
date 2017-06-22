/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DarkAnimat
 */
@Entity
@Table(name = "orden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o")
    , @NamedQuery(name = "Orden.findByIdorden", query = "SELECT o FROM Orden o WHERE o.idorden = :idorden")
    , @NamedQuery(name = "Orden.findByAddress", query = "SELECT o FROM Orden o WHERE o.address = :address")
    , @NamedQuery(name = "Orden.findByPayment", query = "SELECT o FROM Orden o WHERE o.payment = :payment")
    , @NamedQuery(name = "Orden.findByPriceFood", query = "SELECT o FROM Orden o WHERE o.priceFood = :priceFood")
    , @NamedQuery(name = "Orden.findByTaxes", query = "SELECT o FROM Orden o WHERE o.taxes = :taxes")
    , @NamedQuery(name = "Orden.findByPriceDelivery", query = "SELECT o FROM Orden o WHERE o.priceDelivery = :priceDelivery")
    , @NamedQuery(name = "Orden.findByStatus", query = "SELECT o FROM Orden o WHERE o.status = :status")})
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idorden")
    private Integer idorden;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    @Size(max = 45)
    @Column(name = "payment")
    private String payment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price_food")
    private Float priceFood;
    @Column(name = "taxes")
    private Float taxes;
    @Column(name = "price_delivery")
    private Float priceDelivery;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    private List<FoodItem> foodItemList;
    @JoinColumn(name = "cafeteria_idcafeteria", referencedColumnName = "idcafeteria")
    @ManyToOne(optional = false)
    private Cafeteria cafeteriaIdcafeteria;
    @JoinColumn(name = "client_idclient", referencedColumnName = "idclient")
    @ManyToOne(optional = false)
    private Client clientIdclient;
    @JoinColumn(name = "delivery_iddelivery", referencedColumnName = "iddelivery")
    @ManyToOne(optional = false)
    private Delivery deliveryIddelivery;

    OrdenState pendiente;
    OrdenState completada;
    OrdenState ordenState;
    
    public Orden() {
        pendiente = new Pendiente(this);
        completada = new Completada(this);
        ordenState = pendiente;
    }
    
    public void setOrdenState(OrdenState newOrdenState){
        ordenState = newOrdenState;
    }
    
    public String verEstado(){
        return ordenState.verEstado();
    }
    
    public Orden(Integer idorden) {
        this.idorden = idorden;
    }

    public Integer getIdorden() {
        return idorden;
    }

    public void setIdorden(Integer idorden) {
        this.idorden = idorden;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Float getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(Float priceFood) {
        this.priceFood = priceFood;
    }

    public Float getTaxes() {
        return taxes;
    }

    public void setTaxes(Float taxes) {
        this.taxes = taxes;
    }

    public Float getPriceDelivery() {
        return priceDelivery;
    }

    public void setPriceDelivery(Float priceDelivery) {
        this.priceDelivery = priceDelivery;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<FoodItem> getFoodItemList() {
        return foodItemList;
    }

    public void setFoodItemList(List<FoodItem> foodItemList) {
        this.foodItemList = foodItemList;
    }

    public Cafeteria getCafeteriaIdcafeteria() {
        return cafeteriaIdcafeteria;
    }

    public void setCafeteriaIdcafeteria(Cafeteria cafeteriaIdcafeteria) {
        this.cafeteriaIdcafeteria = cafeteriaIdcafeteria;
    }

    public Client getClientIdclient() {
        return clientIdclient;
    }

    public void setClientIdclient(Client clientIdclient) {
        this.clientIdclient = clientIdclient;
    }

    public Delivery getDeliveryIddelivery() {
        return deliveryIddelivery;
    }

    public void setDeliveryIddelivery(Delivery deliveryIddelivery) {
        this.deliveryIddelivery = deliveryIddelivery;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idorden != null ? idorden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.idorden == null && other.idorden != null) || (this.idorden != null && !this.idorden.equals(other.idorden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Orden[ idorden=" + idorden + " ]";
    }
    
}
