/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Freddy
 */
@Entity
@Table(name = "factores_diagnostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactoresDiagnostico.findAll", query = "SELECT f FROM FactoresDiagnostico f"),
    @NamedQuery(name = "FactoresDiagnostico.findById", query = "SELECT f FROM FactoresDiagnostico f WHERE f.id = :id")})
public class FactoresDiagnostico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="my_seq_fac", allocationSize=2, sequenceName="my_seq_fac", initialValue=25)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="my_seq_fac")
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "id_factor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FactoresRelacionado idFactor;
    @JoinColumn(name = "id_diagnostico", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Diagnostico idDiagnostico;

    public FactoresDiagnostico() {
    }

    public FactoresDiagnostico(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FactoresRelacionado getIdFactor() {
        return idFactor;
    }

    public void setIdFactor(FactoresRelacionado idFactor) {
        this.idFactor = idFactor;
    }

    public Diagnostico getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Diagnostico idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
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
        if (!(object instanceof FactoresDiagnostico)) {
            return false;
        }
        FactoresDiagnostico other = (FactoresDiagnostico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.FactoresDiagnostico[ id=" + id + " ]";
    }
    
}
