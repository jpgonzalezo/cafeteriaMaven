/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan Pablo
 */
@Entity
@Table(name = "food_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoodItem.findAll", query = "SELECT f FROM FoodItem f")
    , @NamedQuery(name = "FoodItem.findByIdfoodItem", query = "SELECT f FROM FoodItem f WHERE f.idfoodItem = :idfoodItem")
    , @NamedQuery(name = "FoodItem.findByName", query = "SELECT f FROM FoodItem f WHERE f.name = :name")
    , @NamedQuery(name = "FoodItem.findByPrice", query = "SELECT f FROM FoodItem f WHERE f.price = :price")
    , @NamedQuery(name = "FoodItem.findByStock", query = "SELECT f FROM FoodItem f WHERE f.stock = :stock")
    , @NamedQuery(name = "FoodItem.findByIsEspecial", query = "SELECT f FROM FoodItem f WHERE f.isEspecial = :isEspecial")})
public class FoodItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfood_item")
    private Integer idfoodItem;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Float price;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "is_especial")
    private Short isEspecial;
    @JoinTable(name = "menu_has_food_item", joinColumns = {
        @JoinColumn(name = "food_item_idfood_item", referencedColumnName = "idfood_item")}, inverseJoinColumns = {
        @JoinColumn(name = "menu_idmenu", referencedColumnName = "idmenu")})
    @ManyToMany
    private Collection<Menu> menuCollection;
    @JoinTable(name = "orden_has_food_item", joinColumns = {
        @JoinColumn(name = "food_item_idfood_item", referencedColumnName = "idfood_item")}, inverseJoinColumns = {
        @JoinColumn(name = "orden_idorden", referencedColumnName = "idorden")})
    @ManyToMany
    private Collection<Orden> ordenCollection;

    public FoodItem() {
    }

    public FoodItem(Integer idfoodItem) {
        this.idfoodItem = idfoodItem;
    }

    public Integer getIdfoodItem() {
        return idfoodItem;
    }

    public void setIdfoodItem(Integer idfoodItem) {
        this.idfoodItem = idfoodItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Short getIsEspecial() {
        return isEspecial;
    }

    public void setIsEspecial(Short isEspecial) {
        this.isEspecial = isEspecial;
    }

    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
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
        hash += (idfoodItem != null ? idfoodItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoodItem)) {
            return false;
        }
        FoodItem other = (FoodItem) object;
        if ((this.idfoodItem == null && other.idfoodItem != null) || (this.idfoodItem != null && !this.idfoodItem.equals(other.idfoodItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FoodItem[ idfoodItem=" + idfoodItem + " ]";
    }
    
}
