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
@Table(name = "caracteristicas_diagnostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CaracteristicasDiagnostico.findAll", query = "SELECT c FROM CaracteristicasDiagnostico c"),
    @NamedQuery(name = "CaracteristicasDiagnostico.findById", query = "SELECT c FROM CaracteristicasDiagnostico c WHERE c.id = :id")})
public class CaracteristicasDiagnostico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="my_seq_car", allocationSize=2, sequenceName="my_seq_car", initialValue=25)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="my_seq_car")
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "id_diagnostico", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Diagnostico idDiagnostico;
    @JoinColumn(name = "id_caracteristica", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CaracteristicasDefinitorias idCaracteristica;

    public CaracteristicasDiagnostico() {
    }

    public CaracteristicasDiagnostico(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Diagnostico getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Diagnostico idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public CaracteristicasDefinitorias getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(CaracteristicasDefinitorias idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
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
        if (!(object instanceof CaracteristicasDiagnostico)) {
            return false;
        }
        CaracteristicasDiagnostico other = (CaracteristicasDiagnostico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CaracteristicasDiagnostico[ id=" + id + " ]";
    }
    
}
