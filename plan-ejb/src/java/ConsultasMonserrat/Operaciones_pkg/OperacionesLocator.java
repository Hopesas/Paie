/**
 * OperacionesLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Operaciones_pkg;

public class OperacionesLocator extends org.apache.axis.client.Service implements Operaciones_pkg.Operaciones {

    public OperacionesLocator() {
    }


    public OperacionesLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public OperacionesLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
        OperacionesPort_address = wsdlLoc;
    }

    // Use to get a proxy class for OperacionesPort
    private java.lang.String OperacionesPort_address = "http://190.147.23.15/WebServices/consultaws.php";

    public java.lang.String getOperacionesPortAddress() {
        return OperacionesPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String OperacionesPortWSDDServiceName = "OperacionesPort";

    public java.lang.String getOperacionesPortWSDDServiceName() {
        return OperacionesPortWSDDServiceName;
    }

    public void setOperacionesPortWSDDServiceName(java.lang.String name) {
        OperacionesPortWSDDServiceName = name;
    }

    public Operaciones_pkg.OperacionesPortType getOperacionesPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(OperacionesPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getOperacionesPort(endpoint);
    }

    public Operaciones_pkg.OperacionesPortType getOperacionesPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            Operaciones_pkg.OperacionesBindingStub _stub = new Operaciones_pkg.OperacionesBindingStub(portAddress, this);
            _stub.setPortName(getOperacionesPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setOperacionesPortEndpointAddress(java.lang.String address) {
        OperacionesPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (Operaciones_pkg.OperacionesPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                Operaciones_pkg.OperacionesBindingStub _stub = new Operaciones_pkg.OperacionesBindingStub(new java.net.URL(OperacionesPort_address), this);
                _stub.setPortName(getOperacionesPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("OperacionesPort".equals(inputPortName)) {
            return getOperacionesPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("Operaciones", "Operaciones");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("Operaciones", "OperacionesPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("OperacionesPort".equals(portName)) {
            setOperacionesPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
