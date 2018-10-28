/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "indicadores_diagnostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IndicadoresDiagnostico.findAll", query = "SELECT i FROM IndicadoresDiagnostico i"),
    @NamedQuery(name = "IndicadoresDiagnostico.findById", query = "SELECT i FROM IndicadoresDiagnostico i WHERE i.id = :id"),
    @NamedQuery(name = "IndicadoresDiagnostico.findByValor", query = "SELECT i FROM IndicadoresDiagnostico i WHERE i.valor = :valor")})
public class IndicadoresDiagnostico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="my_seq_ind", allocationSize=2, sequenceName="my_seq_ind", initialValue=25)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="my_seq_ind")
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigInteger valor;
    @JoinColumn(name = "id_indicador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Indicadores idIndicador;
    @JoinColumn(name = "id_diagnostico", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Diagnostico idDiagnostico;

    public IndicadoresDiagnostico() {
    }

    public IndicadoresDiagnostico(Long id) {
        this.id = id;
    }

    public IndicadoresDiagnostico(Long id, BigInteger valor) {
        this.id = id;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    public Indicadores getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Indicadores idIndicador) {
        this.idIndicador = idIndicador;
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
        if (!(object instanceof IndicadoresDiagnostico)) {
            return false;
        }
        IndicadoresDiagnostico other = (IndicadoresDiagnostico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.IndicadoresDiagnostico[ id=" + id + " ]";
    }
    
}
