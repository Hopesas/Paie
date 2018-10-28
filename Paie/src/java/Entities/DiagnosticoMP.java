/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Freddy
 */
public class DiagnosticoMP {
    private Long id;
    private BigInteger documentoPaciente;
    private String Nombre;
    private String fecha;

    public DiagnosticoMP(Long id, BigInteger documentoPaciente, String Nombre, String fecha) {
        this.id = id;
        this.documentoPaciente = documentoPaciente;
        this.Nombre = Nombre;
        this.fecha = fecha;
    }

    public DiagnosticoMP() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getDocumentoPaciente() {
        return documentoPaciente;
    }

    public void setDocumentoPaciente(BigInteger documentoPaciente) {
        this.documentoPaciente = documentoPaciente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
