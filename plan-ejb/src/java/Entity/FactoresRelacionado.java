/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

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
 * @author Freddy
 */
@Entity
@Table(name = "factores_relacionado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactoresRelacionado.findAll", query = "SELECT f FROM FactoresRelacionado f"),
    @NamedQuery(name = "FactoresRelacionado.findById", query = "SELECT f FROM FactoresRelacionado f WHERE f.id = :id"),
    @NamedQuery(name = "FactoresRelacionado.findByCodigoNanda", query = "SELECT f FROM FactoresRelacionado f WHERE f.codigoNanda = :codigoNanda"),
    @NamedQuery(name = "FactoresRelacionado.findByFactorRelacionado", query = "SELECT f FROM FactoresRelacionado f WHERE f.factorRelacionado = :factorRelacionado")})
public class FactoresRelacionado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_nanda")
    private long codigoNanda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "factor_relacionado")
    private String factorRelacionado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactor")
    private Collection<FactoresDiagnostico> factoresDiagnosticoCollection;

    public FactoresRelacionado() {
    }

    public FactoresRelacionado(Long id) {
        this.id = id;
    }

    public FactoresRelacionado(Long id, long codigoNanda, String factorRelacionado) {
        this.id = id;
        this.codigoNanda = codigoNanda;
        this.factorRelacionado = factorRelacionado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCodigoNanda() {
        return codigoNanda;
    }

    public void setCodigoNanda(long codigoNanda) {
        this.codigoNanda = codigoNanda;
    }

    public String getFactorRelacionado() {
        return factorRelacionado;
    }

    public void setFactorRelacionado(String factorRelacionado) {
        this.factorRelacionado = factorRelacionado;
    }

    @XmlTransient
    public Collection<FactoresDiagnostico> getFactoresDiagnosticoCollection() {
        return factoresDiagnosticoCollection;
    }

    public void setFactoresDiagnosticoCollection(Collection<FactoresDiagnostico> factoresDiagnosticoCollection) {
        this.factoresDiagnosticoCollection = factoresDiagnosticoCollection;
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
        if (!(object instanceof FactoresRelacionado)) {
            return false;
        }
        FactoresRelacionado other = (FactoresRelacionado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.FactoresRelacionado[ id=" + id + " ]";
    }
    
}
