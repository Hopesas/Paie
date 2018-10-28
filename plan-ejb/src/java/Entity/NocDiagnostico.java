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
@Table(name = "noc_diagnostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NocDiagnostico.findAll", query = "SELECT n FROM NocDiagnostico n"),
    @NamedQuery(name = "NocDiagnostico.findById", query = "SELECT n FROM NocDiagnostico n WHERE n.id = :id"),
    @NamedQuery(name = "NocDiagnostico.findByValorActual", query = "SELECT n FROM NocDiagnostico n WHERE n.valorActual = :valorActual"),
    @NamedQuery(name = "NocDiagnostico.findByValorDiana", query = "SELECT n FROM NocDiagnostico n WHERE n.valorDiana = :valorDiana")})
public class NocDiagnostico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="my_seq_noc", allocationSize=2, sequenceName="my_seq_noc", initialValue=25)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="my_seq_noc")
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_actual")
    private long valorActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_diana")
    private long valorDiana;
    @JoinColumn(name = "id_noc", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Noc idNoc;
    @JoinColumn(name = "id_diagnostico", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Diagnostico idDiagnostico;

    public NocDiagnostico() {
    }

    public NocDiagnostico(Long id) {
        this.id = id;
    }

    public NocDiagnostico(Long id, long valorActual, long valorDiana) {
        this.id = id;
        this.valorActual = valorActual;
        this.valorDiana = valorDiana;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getValorActual() {
        return valorActual;
    }

    public void setValorActual(long valorActual) {
        this.valorActual = valorActual;
    }

    public long getValorDiana() {
        return valorDiana;
    }

    public void setValorDiana(long valorDiana) {
        this.valorDiana = valorDiana;
    }

    public Noc getIdNoc() {
        return idNoc;
    }

    public void setIdNoc(Noc idNoc) {
        this.idNoc = idNoc;
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
        if (!(object instanceof NocDiagnostico)) {
            return false;
        }
        NocDiagnostico other = (NocDiagnostico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.NocDiagnostico[ id=" + id + " ]";
    }
    
}
