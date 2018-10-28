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
@Table(name = "nic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nic.findAll", query = "SELECT n FROM Nic n"),
    @NamedQuery(name = "Nic.findById", query = "SELECT n FROM Nic n WHERE n.id = :id"),
    @NamedQuery(name = "Nic.findByCodigo", query = "SELECT n FROM Nic n WHERE n.codigo = :codigo"),
    @NamedQuery(name = "Nic.findByIntervencion", query = "SELECT n FROM Nic n WHERE n.intervencion = :intervencion"),
    @NamedQuery(name = "Nic.findByDefinicion", query = "SELECT n FROM Nic n WHERE n.definicion = :definicion")})
public class Nic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private long codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "intervencion")
    private String intervencion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "definicion")
    private String definicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNic")
    private Collection<NicDiagnostico> nicDiagnosticoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNic")
    private Collection<ActividadesDiagnostico> actividadesDiagnosticoCollection;

    public Nic() {
    }

    public Nic(Long id) {
        this.id = id;
    }

    public Nic(Long id, long codigo, String intervencion, String definicion) {
        this.id = id;
        this.codigo = codigo;
        this.intervencion = intervencion;
        this.definicion = definicion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getIntervencion() {
        return intervencion;
    }

    public void setIntervencion(String intervencion) {
        this.intervencion = intervencion;
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
        if (!(object instanceof Nic)) {
            return false;
        }
        Nic other = (Nic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Nic[ id=" + id + " ]";
    }
    
}
