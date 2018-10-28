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
@Table(name = "noc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Noc.findAll", query = "SELECT n FROM Noc n"),
    @NamedQuery(name = "Noc.findById", query = "SELECT n FROM Noc n WHERE n.id = :id"),
    @NamedQuery(name = "Noc.findByCodigo", query = "SELECT n FROM Noc n WHERE n.codigo = :codigo"),
    @NamedQuery(name = "Noc.findByResultado", query = "SELECT n FROM Noc n WHERE n.resultado = :resultado"),
    @NamedQuery(name = "Noc.findByDefinicion", query = "SELECT n FROM Noc n WHERE n.definicion = :definicion"),
    @NamedQuery(name = "Noc.findByDominio", query = "SELECT n FROM Noc n WHERE n.dominio = :dominio"),
    @NamedQuery(name = "Noc.findByClase", query = "SELECT n FROM Noc n WHERE n.clase = :clase"),
    @NamedQuery(name = "Noc.findByExtra", query = "SELECT n FROM Noc n WHERE n.extra = :extra")})
public class Noc implements Serializable {
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
    @Column(name = "resultado")
    private String resultado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "definicion")
    private String definicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dominio")
    private String dominio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "clase")
    private String clase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "extra")
    private long extra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNoc")
    private Collection<NocDiagnostico> nocDiagnosticoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNoc")
    private Collection<NicDiagnostico> nicDiagnosticoCollection;

    public Noc() {
    }

    public Noc(Long id) {
        this.id = id;
    }

    public Noc(Long id, long codigo, String resultado, String definicion, String dominio, String clase, long extra) {
        this.id = id;
        this.codigo = codigo;
        this.resultado = resultado;
        this.definicion = definicion;
        this.dominio = dominio;
        this.clase = clase;
        this.extra = extra;
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

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public long getExtra() {
        return extra;
    }

    public void setExtra(long extra) {
        this.extra = extra;
    }

    @XmlTransient
    public Collection<NocDiagnostico> getNocDiagnosticoCollection() {
        return nocDiagnosticoCollection;
    }

    public void setNocDiagnosticoCollection(Collection<NocDiagnostico> nocDiagnosticoCollection) {
        this.nocDiagnosticoCollection = nocDiagnosticoCollection;
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
        if (!(object instanceof Noc)) {
            return false;
        }
        Noc other = (Noc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Noc[ id=" + id + " ]";
    }
    
}
