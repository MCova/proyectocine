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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "peliculas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peliculas.findAll", query = "SELECT p FROM Peliculas p"),
    @NamedQuery(name = "Peliculas.findByCodPelicula", query = "SELECT p FROM Peliculas p WHERE p.codPelicula = :codPelicula"),
    @NamedQuery(name = "Peliculas.findByNombrePelicula", query = "SELECT p FROM Peliculas p WHERE p.nombrePelicula = :nombrePelicula"),
    @NamedQuery(name = "Peliculas.findByDirector", query = "SELECT p FROM Peliculas p WHERE p.director = :director")})
public class Peliculas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CodPelicula")
    private String codPelicula;
    @Size(max = 255)
    @Column(name = "NombrePelicula")
    private String nombrePelicula;
    @Size(max = 200)
    @Column(name = "Director")
    private String director;
    @JoinColumn(name = "CodEntrada", referencedColumnName = "CodEntrada")
    @ManyToOne
    private Entradas codEntrada;

    public Peliculas() {
    }

    public Peliculas(String codPelicula) {
        this.codPelicula = codPelicula;
    }

    public String getCodPelicula() {
        return codPelicula;
    }

    public void setCodPelicula(String codPelicula) {
        this.codPelicula = codPelicula;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Entradas getCodEntrada() {
        return codEntrada;
    }

    public void setCodEntrada(Entradas codEntrada) {
        this.codEntrada = codEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPelicula != null ? codPelicula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peliculas)) {
            return false;
        }
        Peliculas other = (Peliculas) object;
        if ((this.codPelicula == null && other.codPelicula != null) || (this.codPelicula != null && !this.codPelicula.equals(other.codPelicula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "serviciowebcine.Peliculas[ codPelicula=" + codPelicula + " ]";
    }
    
}
