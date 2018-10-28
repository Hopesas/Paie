/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Freddy
 */
@Entity
@Table(name = "nanda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nanda.findAll", query = "SELECT n FROM Nanda n"),
    @NamedQuery(name = "Nanda.findById", query = "SELECT n FROM Nanda n WHERE n.id = :id"),
    @NamedQuery(name = "Nanda.findByDiagnostico", query = "SELECT n FROM Nanda n WHERE n.diagnostico = :diagnostico"),
    @NamedQuery(name = "Nanda.findByRiesgo", query = "SELECT n FROM Nanda n WHERE n.riesgo = :riesgo"),
    @NamedQuery(name = "Nanda.findByClases", query = "SELECT n FROM Nanda n WHERE n.clases = :clases"),
    @NamedQuery(name = "Nanda.findByDominio", query = "SELECT n FROM Nanda n WHERE n.dominio = :dominio"),
    @NamedQuery(name = "Nanda.findByCodigo", query = "SELECT n FROM Nanda n WHERE n.codigo = :codigo"),
    @NamedQuery(name = "Nanda.findByPatron", query = "SELECT n FROM Nanda n WHERE n.patron = :patron"),
    @NamedQuery(name = "Nanda.findByDescripcion", query = "SELECT n FROM Nanda n WHERE n.descripcion = :descripcion")})
public class Nanda implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "diagnostico")
    private String diagnostico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "riesgo")
    private short riesgo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "clases")
    private String clases;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dominio")
    private String dominio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private long codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "patron")
    private long patron;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;

    public Nanda() {
    }

    public Nanda(BigDecimal id) {
        this.id = id;
    }

    public Nanda(BigDecimal id, String diagnostico, short riesgo, String clases, String dominio, long codigo, long patron, String descripcion) {
        this.id = id;
        this.diagnostico = diagnostico;
        this.riesgo = riesgo;
        this.clases = clases;
        this.dominio = dominio;
        this.codigo = codigo;
        this.patron = patron;
        this.descripcion = descripcion;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public short getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(short riesgo) {
        this.riesgo = riesgo;
    }

    public String getClases() {
        return clases;
    }

    public void setClases(String clases) {
        this.clases = clases;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getPatron() {
        return patron;
    }

    public void setPatron(long patron) {
        this.patron = patron;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof Nanda)) {
            return false;
        }
        Nanda other = (Nanda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Nanda[ id=" + id + " ]";
    }
    
}
