/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciowebcine;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario0301
 */
@Entity
@Table(name = "precios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Precios.findAll", query = "SELECT p FROM Precios p"),
    @NamedQuery(name = "Precios.findByCodPrecio", query = "SELECT p FROM Precios p WHERE p.codPrecio = :codPrecio"),
    @NamedQuery(name = "Precios.findByPrecio", query = "SELECT p FROM Precios p WHERE p.precio = :precio")})
public class Precios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CodPrecio")
    private String codPrecio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Float precio;

    public Precios() {
    }

    public Precios(String codPrecio) {
        this.codPrecio = codPrecio;
    }

    public String getCodPrecio() {
        return codPrecio;
    }

    public void setCodPrecio(String codPrecio) {
        this.codPrecio = codPrecio;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPrecio != null ? codPrecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Precios)) {
            return false;
        }
        Precios other = (Precios) object;
        if ((this.codPrecio == null && other.codPrecio != null) || (this.codPrecio != null && !this.codPrecio.equals(other.codPrecio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "serviciowebcine.Precios[ codPrecio=" + codPrecio + " ]";
    }
    
}
