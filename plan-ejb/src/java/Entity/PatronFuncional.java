/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Freddy
 */
@Entity
@Table(name = "patron_funcional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatronFuncional.findAll", query = "SELECT p FROM PatronFuncional p"),
    @NamedQuery(name = "PatronFuncional.findById", query = "SELECT p FROM PatronFuncional p WHERE p.id = :id"),
    @NamedQuery(name = "PatronFuncional.findByDescripcion", query = "SELECT p FROM PatronFuncional p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PatronFuncional.findByDefinicion", query = "SELECT p FROM PatronFuncional p WHERE p.definicion = :definicion")})
public class PatronFuncional implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 1000)
    @Column(name = "definicion")
    private String definicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPatron")
    private Collection<NicDiagnostico> nicDiagnosticoCollection;

    public PatronFuncional() {
    }

    public PatronFuncional(BigDecimal id) {
        this.id = id;
    }

    public PatronFuncional(BigDecimal id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    @XmlTransient
    public Collection<NicDiagnostico> getNicDiagnosticoCollection() {
        return nicDiagnosticoCollection;
    }

    public void setNicDiagnosticoCollection(Collection<NicDiagnostico> nicDiagnosticoCollection) {
        this.nicDiagnosticoCollection = nicDiagnosticoCollection;
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
        if (!(object instanceof PatronFuncional)) {
            return false;
        }
        PatronFuncional other = (PatronFuncional) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PatronFuncional[ id=" + id + " ]";
    }
    
}
