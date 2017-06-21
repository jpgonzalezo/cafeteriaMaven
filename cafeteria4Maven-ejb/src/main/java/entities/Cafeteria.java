/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "cafeteria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cafeteria.findAll", query = "SELECT c FROM Cafeteria c")
    , @NamedQuery(name = "Cafeteria.findByIdcafeteria", query = "SELECT c FROM Cafeteria c WHERE c.idcafeteria = :idcafeteria")
    , @NamedQuery(name = "Cafeteria.findByName", query = "SELECT c FROM Cafeteria c WHERE c.name = :name")
    , @NamedQuery(name = "Cafeteria.findByEmail", query = "SELECT c FROM Cafeteria c WHERE c.email = :email")})
public class Cafeteria implements Serializable {
    int num;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcafeteria")
    private Integer idcafeteria;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cafeteriaIdcafeteria")
    private Collection<Orden> ordenCollection;

    public Cafeteria() {
    }

    public Cafeteria(Integer idcafeteria) {
        this.idcafeteria = idcafeteria;
    }

    public Integer getIdcafeteria() {
        return idcafeteria;
    }

    public void setIdcafeteria(Integer idcafeteria) {
        this.idcafeteria = idcafeteria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        hash += (idcafeteria != null ? idcafeteria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cafeteria)) {
            return false;
        }
        Cafeteria other = (Cafeteria) object;
        if ((this.idcafeteria == null && other.idcafeteria != null) || (this.idcafeteria != null && !this.idcafeteria.equals(other.idcafeteria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cafeteria[ idcafeteria=" + idcafeteria + " ]";
    }
    
}
