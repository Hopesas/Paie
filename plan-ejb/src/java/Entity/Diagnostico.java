/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Freddy
 */
@Entity
@Table(name = "diagnostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostico.findAll", query = "SELECT d FROM Diagnostico d"),
    @NamedQuery(name = "Diagnostico.findById", query = "SELECT d FROM Diagnostico d WHERE d.id = :id"),
    @NamedQuery(name = "Diagnostico.findByIdPatron", query = "SELECT d FROM Diagnostico d WHERE d.idPatron = :idPatron"),
    @NamedQuery(name = "Diagnostico.findByIdPaciente", query = "SELECT d FROM Diagnostico d WHERE d.idPaciente = :idPaciente"),
    @NamedQuery(name = "Diagnostico.findByIdNanda", query = "SELECT d FROM Diagnostico d WHERE d.idNanda = :idNanda"),
    @NamedQuery(name = "Diagnostico.findByIdUseras", query = "SELECT d FROM Diagnostico d WHERE d.idUseras = :idUseras"),
    @NamedQuery(name = "Diagnostico.findByCaida", query = "SELECT d FROM Diagnostico d WHERE d.caida = :caida"),
    @NamedQuery(name = "Diagnostico.findByFecha", query = "SELECT d FROM Diagnostico d WHERE d.fecha = :fecha")})
public class Diagnostico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="my_seq_dia", allocationSize=2, sequenceName="my_seq_dia", initialValue=25)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="my_seq_dia")
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_patron")
    private long idPatron;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_paciente")
    private String idPaciente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nanda")
    private long idNanda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "useras")
    private String idUseras;
    @Column(name = "caida")
    private Long caida;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDiagnostico")
    private Collection<FactoresDiagnostico> factoresDiagnosticoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDiagnostico")
    private Collection<NocDiagnostico> nocDiagnosticoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDiagnostico")
    private Collection<IndicadoresDiagnostico> indicadoresDiagnosticoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDiagnostico")
    private Collection<CaracteristicasDiagnostico> caracteristicasDiagnosticoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDiagnostico")
    private Collection<NicDiagnostico> nicDiagnosticoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDiagnostico")
    private Collection<ActividadesDiagnostico> actividadesDiagnosticoCollection;

    public Diagnostico() {
    }

    public Diagnostico(Long id) {
        this.id = id;
    }

    public Diagnostico(Long id, long idPatron, String idPaciente, long idNanda, String idUseras) {
        this.id = id;
        this.idPatron = idPatron;
        this.idPaciente = idPaciente;
        this.idNanda = idNanda;
        this.idUseras = idUseras;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdPatron() {
        return idPatron;
    }

    public void setIdPatron(long idPatron) {
        this.idPatron = idPatron;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public long getIdNanda() {
        return idNanda;
    }

    public void setIdNanda(long idNanda) {
        this.idNanda = idNanda;
    }

    public String getIdUseras() {
        return idUseras;
    }

    public void setIdUseras(String idUseras) {
        this.idUseras = idUseras;
    }

    public Long getCaida() {
        return caida;
    }

    public void setCaida(Long caida) {
        this.caida = caida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<FactoresDiagnostico> getFactoresDiagnosticoCollection() {
        return factoresDiagnosticoCollection;
    }

    public void setFactoresDiagnosticoCollection(Collection<FactoresDiagnostico> factoresDiagnosticoCollection) {
        this.factoresDiagnosticoCollection = factoresDiagnosticoCollection;
    }

    @XmlTransient
    public Collection<NocDiagnostico> getNocDiagnosticoCollection() {
        return nocDiagnosticoCollection;
    }

    public void setNocDiagnosticoCollection(Collection<NocDiagnostico> nocDiagnosticoCollection) {
        this.nocDiagnosticoCollection = nocDiagnosticoCollection;
    }

    @XmlTransient
    public Collection<IndicadoresDiagnostico> getIndicadoresDiagnosticoCollection() {
        return indicadoresDiagnosticoCollection;
    }

    public void setIndicadoresDiagnosticoCollection(Collection<IndicadoresDiagnostico> indicadoresDiagnosticoCollection) {
        this.indicadoresDiagnosticoCollection = indicadoresDiagnosticoCollection;
    }

    @XmlTransient
    public Collection<CaracteristicasDiagnostico> getCaracteristicasDiagnosticoCollection() {
        return caracteristicasDiagnosticoCollection;
    }

    public void setCaracteristicasDiagnosticoCollection(Collection<CaracteristicasDiagnostico> caracteristicasDiagnosticoCollection) {
        this.caracteristicasDiagnosticoCollection = caracteristicasDiagnosticoCollection;
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
        if (!(object instanceof Diagnostico)) {
            return false;
        }
        Diagnostico other = (Diagnostico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Diagnostico[ id=" + id + " ]";
    }
    
}
