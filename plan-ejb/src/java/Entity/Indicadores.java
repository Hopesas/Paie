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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "indicadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indicadores.findAll", query = "SELECT i FROM Indicadores i"),
    @NamedQuery(name = "Indicadores.findById", query = "SELECT i FROM Indicadores i WHERE i.id = :id"),
    @NamedQuery(name = "Indicadores.findByCodigoNoc", query = "SELECT i FROM Indicadores i WHERE i.codigoNoc.id = :codigoNoc"),
    @NamedQuery(name = "Indicadores.findByCodigo", query = "SELECT i FROM Indicadores i WHERE i.codigo = :codigo"),
    @NamedQuery(name = "Indicadores.findByEscala", query = "SELECT i FROM Indicadores i WHERE i.escala = :escala"),
    @NamedQuery(name = "Indicadores.findByIndicador", query = "SELECT i FROM Indicadores i WHERE i.indicador = :indicador")})
public class Indicadores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "codigo_noc")
    private Noc codigoNoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private long codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "escala")
    private String escala;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "indicador")
    private String indicador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIndicador")
    private Collection<IndicadoresDiagnostico> indicadoresDiagnosticoCollection;

    public Indicadores() {
    }

    public Indicadores(Long id) {
        this.id = id;
    }

    public Indicadores(Long id, Noc codigoNoc, long codigo, String escala, String indicador) {
        this.id = id;
        this.codigoNoc = codigoNoc;
        this.codigo = codigo;
        this.escala = escala;
        this.indicador = indicador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Noc getCodigoNoc() {
        return codigoNoc;
    }

    public void setCodigoNoc(Noc codigoNoc) {
        this.codigoNoc = codigoNoc;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    @XmlTransient
    public Collection<IndicadoresDiagnostico> getIndicadoresDiagnosticoCollection() {
        return indicadoresDiagnosticoCollection;
    }

    public void setIndicadoresDiagnosticoCollection(Collection<IndicadoresDiagnostico> indicadoresDiagnosticoCollection) {
        this.indicadoresDiagnosticoCollection = indicadoresDiagnosticoCollection;
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
        if (!(object instanceof Indicadores)) {
            return false;
        }
        Indicadores other = (Indicadores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Indicadores[ id=" + id + " ]";
    }
    
}
