/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

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
 * @author Freddy
 */
@Entity
@Table(name = "escalas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escalas.findAll", query = "SELECT e FROM Escalas e"),
    @NamedQuery(name = "Escalas.findById", query = "SELECT e FROM Escalas e WHERE e.id = :id"),
    @NamedQuery(name = "Escalas.findByTipo", query = "SELECT e FROM Escalas e WHERE e.tipo = :tipo"),
    @NamedQuery(name = "Escalas.findByValor", query = "SELECT e FROM Escalas e WHERE e.valor = :valor"),
    @NamedQuery(name = "Escalas.findByDescripcion", query = "SELECT e FROM Escalas e WHERE e.descripcion = :descripcion")})
public class Escalas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private long valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;

    public Escalas() {
    }

    public Escalas(Long id) {
        this.id = id;
    }

    public Escalas(Long id, String tipo, long valor, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof Escalas)) {
            return false;
        }
        Escalas other = (Escalas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Escalas[ id=" + id + " ]";
    }
    
}
