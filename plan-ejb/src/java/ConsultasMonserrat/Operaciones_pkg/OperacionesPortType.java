/**
 * OperacionesPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Operaciones_pkg;

public interface OperacionesPortType extends java.rmi.Remote {
    public Operaciones_pkg.Registro[] consultas(Operaciones_pkg.Indicador indicador) throws java.rmi.RemoteException;
    public java.lang.String consultas_depuracion(Operaciones_pkg.Indicador indicador) throws java.rmi.RemoteException;
    public Operaciones_pkg.Indicador[] ver_indicadores() throws java.rmi.RemoteException;
}
