/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Freddy
 */
@Entity
@Table(name = "interrelaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interrelaciones.findAll", query = "SELECT i FROM Interrelaciones i"),
    @NamedQuery(name = "Interrelaciones.findById", query = "SELECT i FROM Interrelaciones i WHERE i.id = :id"),
    @NamedQuery(name = "Interrelaciones.findByCodigoNanda", query = "SELECT distinct i FROM Interrelaciones i WHERE i.codigoNanda = :codigoNanda"),
    @NamedQuery(name = "Interrelaciones.findByCodigoNoc", query = "SELECT i FROM Interrelaciones i WHERE i.codigoNoc = :codigoNoc"),
    @NamedQuery(name = "Interrelaciones.findByCodigoNic", query = "SELECT i FROM Interrelaciones i WHERE i.codigoNic = :codigoNic"),
    @NamedQuery(name = "Interrelaciones.findByTipo", query = "SELECT i FROM Interrelaciones i WHERE i.tipo = :tipo"),
    @NamedQuery(name = "Interrelaciones.findByOrden", query = "SELECT i FROM Interrelaciones i WHERE i.orden = :orden")})
public class Interrelaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_nanda")
    private long codigoNanda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_noc")
    private long codigoNoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_nic")
    private long codigoNic;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orden")
    private long orden;

    public Interrelaciones() {
    }

    public Interrelaciones(BigDecimal id) {
        this.id = id;
    }

    public Interrelaciones(BigDecimal id, long codigoNanda, long codigoNoc, long codigoNic, String tipo, long orden) {
        this.id = id;
        this.codigoNanda = codigoNanda;
        this.codigoNoc = codigoNoc;
        this.codigoNic = codigoNic;
        this.tipo = tipo;
        this.orden = orden;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public long getCodigoNanda() {
        return codigoNanda;
    }

    public void setCodigoNanda(long codigoNanda) {
        this.codigoNanda = codigoNanda;
    }

    public long getCodigoNoc() {
        return codigoNoc;
    }

    public void setCodigoNoc(long codigoNoc) {
        this.codigoNoc = codigoNoc;
    }

    public long getCodigoNic() {
        return codigoNic;
    }

    public void setCodigoNic(long codigoNic) {
        this.codigoNic = codigoNic;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getOrden() {
        return orden;
    }

    public void setOrden(long orden) {
        this.orden = orden;
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
        if (!(object instanceof Interrelaciones)) {
            return false;
        }
        Interrelaciones other = (Interrelaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Interrelaciones[ id=" + id + " ]";
    }
    
}
