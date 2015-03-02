/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciowebcine;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario0301
 */
@Entity
@Table(name = "entradas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entradas.findAll", query = "SELECT e FROM Entradas e"),
    @NamedQuery(name = "Entradas.findByCodEntrada", query = "SELECT e FROM Entradas e WHERE e.codEntrada = :codEntrada"),
    @NamedQuery(name = "Entradas.findByFechaPase", query = "SELECT e FROM Entradas e WHERE e.fechaPase = :fechaPase"),
    @NamedQuery(name = "Entradas.findByCodButaca", query = "SELECT e FROM Entradas e WHERE e.codButaca = :codButaca")})
public class Entradas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CodEntrada")
    private String codEntrada;
    @Column(name = "FechaPase")
    @Temporal(TemporalType.DATE)
    private Date fechaPase;
    @Size(max = 20)
    @Column(name = "CodButaca")
    private String codButaca;
    @OneToMany(mappedBy = "codEntrada")
    private Collection<Peliculas> peliculasCollection;
    @JoinColumn(name = "CodReserva", referencedColumnName = "CodReserva")
    @ManyToOne
    private Reservas codReserva;

    public Entradas() {
    }

    public Entradas(String codEntrada) {
        this.codEntrada = codEntrada;
    }

    public String getCodEntrada() {
        return codEntrada;
    }

    public void setCodEntrada(String codEntrada) {
        this.codEntrada = codEntrada;
    }

    public Date getFechaPase() {
        return fechaPase;
    }

    public void setFechaPase(Date fechaPase) {
        this.fechaPase = fechaPase;
    }

    public String getCodButaca() {
        return codButaca;
    }

    public void setCodButaca(String codButaca) {
        this.codButaca = codButaca;
    }

    @XmlTransient
    public Collection<Peliculas> getPeliculasCollection() {
        return peliculasCollection;
    }

    public void setPeliculasCollection(Collection<Peliculas> peliculasCollection) {
        this.peliculasCollection = peliculasCollection;
    }

    public Reservas getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(Reservas codReserva) {
        this.codReserva = codReserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEntrada != null ? codEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entradas)) {
            return false;
        }
        Entradas other = (Entradas) object;
        if ((this.codEntrada == null && other.codEntrada != null) || (this.codEntrada != null && !this.codEntrada.equals(other.codEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "serviciowebcine.Entradas[ codEntrada=" + codEntrada + " ]";
    }
    
}
