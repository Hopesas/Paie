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
@Table(name = "caracteristicas_definitorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CaracteristicasDefinitorias.findAll", query = "SELECT c FROM CaracteristicasDefinitorias c"),
    @NamedQuery(name = "CaracteristicasDefinitorias.findById", query = "SELECT c FROM CaracteristicasDefinitorias c WHERE c.id = :id"),
    @NamedQuery(name = "CaracteristicasDefinitorias.findByCodigoNanda", query = "SELECT c FROM CaracteristicasDefinitorias c WHERE c.codigoNanda = :codigoNanda"),
    @NamedQuery(name = "CaracteristicasDefinitorias.findByDefinicion", query = "SELECT c FROM CaracteristicasDefinitorias c WHERE c.definicion = :definicion")})
public class CaracteristicasDefinitorias implements Serializable {
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
    @Column(name = "definicion")
    private String definicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCaracteristica")
    private Collection<CaracteristicasDiagnostico> caracteristicasDiagnosticoCollection;

    public CaracteristicasDefinitorias() {
    }

    public CaracteristicasDefinitorias(Long id) {
        this.id = id;
    }

    public CaracteristicasDefinitorias(Long id, long codigoNanda, String definicion) {
        this.id = id;
        this.codigoNanda = codigoNanda;
        this.definicion = definicion;
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

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    @XmlTransient
    public Collection<CaracteristicasDiagnostico> getCaracteristicasDiagnosticoCollection() {
        return caracteristicasDiagnosticoCollection;
    }

    public void setCaracteristicasDiagnosticoCollection(Collection<CaracteristicasDiagnostico> caracteristicasDiagnosticoCollection) {
        this.caracteristicasDiagnosticoCollection = caracteristicasDiagnosticoCollection;
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
        if (!(object instanceof CaracteristicasDefinitorias)) {
            return false;
        }
        CaracteristicasDefinitorias other = (CaracteristicasDefinitorias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CaracteristicasDefinitorias[ id=" + id + " ]";
    }
    
}
