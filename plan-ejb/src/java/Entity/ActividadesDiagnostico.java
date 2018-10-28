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
@Table(name = "actividades_diagnostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadesDiagnostico.findAll", query = "SELECT a FROM ActividadesDiagnostico a"),
    @NamedQuery(name = "ActividadesDiagnostico.findById", query = "SELECT a FROM ActividadesDiagnostico a WHERE a.id = :id")})
public class ActividadesDiagnostico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="my_seq_act", allocationSize=2, sequenceName="my_seq_act", initialValue=25)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="my_seq_act")
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "id_nic", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Nic idNic;
    @JoinColumn(name = "id_diagnostico", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Diagnostico idDiagnostico;
    @JoinColumn(name = "id_actividad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Actividades idActividad;

    public ActividadesDiagnostico() {
    }

    public ActividadesDiagnostico(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Nic getIdNic() {
        return idNic;
    }

    public void setIdNic(Nic idNic) {
        this.idNic = idNic;
    }

    public Diagnostico getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Diagnostico idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public Actividades getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Actividades idActividad) {
        this.idActividad = idActividad;
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
        if (!(object instanceof ActividadesDiagnostico)) {
            return false;
        }
        ActividadesDiagnostico other = (ActividadesDiagnostico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ActividadesDiagnostico[ id=" + id + " ]";
    }
    
}
