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
@Table(name = "actividades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividades.findAll", query = "SELECT a FROM Actividades a"),
    @NamedQuery(name = "Actividades.findById", query = "SELECT a FROM Actividades a WHERE a.id = :id"),
    @NamedQuery(name = "Actividades.findByCodigoNic", query = "SELECT a FROM Actividades a WHERE a.codigoNic = :codigoNic"),
    @NamedQuery(name = "Actividades.findByCodigo", query = "SELECT a FROM Actividades a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Actividades.findByActividad", query = "SELECT a FROM Actividades a WHERE a.actividad = :actividad")})
public class Actividades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_nic")
    private long codigoNic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private long codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 511)
    @Column(name = "actividad")
    private String actividad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividad")
    private Collection<ActividadesDiagnostico> actividadesDiagnosticoCollection;

    public Actividades() {
    }

    public Actividades(Long id) {
        this.id = id;
    }

    public Actividades(Long id, long codigoNic, long codigo, String actividad) {
        this.id = id;
        this.codigoNic = codigoNic;
        this.codigo = codigo;
        this.actividad = actividad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCodigoNic() {
        return codigoNic;
    }

    public void setCodigoNic(long codigoNic) {
        this.codigoNic = codigoNic;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    @XmlTransient
    public Collection<ActividadesDiagnostico> getActividadesDiagnosticoCollection() {
        return actividadesDiagnosticoCollection;
    }

    public void setActividadesDiagnosticoCollection(Collection<ActividadesDiagnostico> actividadesDiagnosticoCollection) {
        this.actividadesDiagnosticoCollection = actividadesDiagnosticoCollection;
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
        if (!(object instanceof Actividades)) {
            return false;
        }
        Actividades other = (Actividades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Actividades[ id=" + id + " ]";
    }
    
}
