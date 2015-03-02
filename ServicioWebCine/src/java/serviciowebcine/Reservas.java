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
@Table(name = "reservas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservas.findAll", query = "SELECT r FROM Reservas r"),
    @NamedQuery(name = "Reservas.findByCodReserva", query = "SELECT r FROM Reservas r WHERE r.codReserva = :codReserva"),
    @NamedQuery(name = "Reservas.findByFechaReserva", query = "SELECT r FROM Reservas r WHERE r.fechaReserva = :fechaReserva"),
    @NamedQuery(name = "Reservas.findByLugarRecogida", query = "SELECT r FROM Reservas r WHERE r.lugarRecogida = :lugarRecogida"),
    @NamedQuery(name = "Reservas.findByCantidadEntradas", query = "SELECT r FROM Reservas r WHERE r.cantidadEntradas = :cantidadEntradas"),
    @NamedQuery(name = "Reservas.findByMedioPago", query = "SELECT r FROM Reservas r WHERE r.medioPago = :medioPago")})
public class Reservas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CodReserva")
    private String codReserva;
    @Column(name = "FechaReserva")
    @Temporal(TemporalType.DATE)
    private Date fechaReserva;
    @Size(max = 200)
    @Column(name = "LugarRecogida")
    private String lugarRecogida;
    @Column(name = "CantidadEntradas")
    private Integer cantidadEntradas;
    @Size(max = 100)
    @Column(name = "MedioPago")
    private String medioPago;
    @OneToMany(mappedBy = "codReserva")
    private Collection<Entradas> entradasCollection;
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    @ManyToOne
    private Clientes dni;

    public Reservas() {
    }

    public Reservas(String codReserva) {
        this.codReserva = codReserva;
    }

    public String getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(String codReserva) {
        this.codReserva = codReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getLugarRecogida() {
        return lugarRecogida;
    }

    public void setLugarRecogida(String lugarRecogida) {
        this.lugarRecogida = lugarRecogida;
    }

    public Integer getCantidadEntradas() {
        return cantidadEntradas;
    }

    public void setCantidadEntradas(Integer cantidadEntradas) {
        this.cantidadEntradas = cantidadEntradas;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    @XmlTransient
    public Collection<Entradas> getEntradasCollection() {
        return entradasCollection;
    }

    public void setEntradasCollection(Collection<Entradas> entradasCollection) {
        this.entradasCollection = entradasCollection;
    }

    public Clientes getDni() {
        return dni;
    }

    public void setDni(Clientes dni) {
        this.dni = dni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codReserva != null ? codReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
        if ((this.codReserva == null && other.codReserva != null) || (this.codReserva != null && !this.codReserva.equals(other.codReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "serviciowebcine.Reservas[ codReserva=" + codReserva + " ]";
    }
    
}
