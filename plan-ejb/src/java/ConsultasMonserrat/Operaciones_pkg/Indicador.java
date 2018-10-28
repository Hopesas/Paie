/**
 * Indicador.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Operaciones_pkg;

public class Indicador  implements java.io.Serializable {
    private java.lang.String indicador;

    private Operaciones_pkg.Variable[] variables;

    public Indicador() {
    }

    public Indicador(
           java.lang.String indicador,
           Operaciones_pkg.Variable[] variables) {
           this.indicador = indicador;
           this.variables = variables;
    }


    /**
     * Gets the indicador value for this Indicador.
     * 
     * @return indicador
     */
    public java.lang.String getIndicador() {
        return indicador;
    }


    /**
     * Sets the indicador value for this Indicador.
     * 
     * @param indicador
     */
    public void setIndicador(java.lang.String indicador) {
        this.indicador = indicador;
    }


    /**
     * Gets the variables value for this Indicador.
     * 
     * @return variables
     */
    public Operaciones_pkg.Variable[] getVariables() {
        return variables;
    }


    /**
     * Sets the variables value for this Indicador.
     * 
     * @param variables
     */
    public void setVariables(Operaciones_pkg.Variable[] variables) {
        this.variables = variables;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Indicador)) return false;
        Indicador other = (Indicador) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.indicador==null && other.getIndicador()==null) || 
             (this.indicador!=null &&
              this.indicador.equals(other.getIndicador()))) &&
            ((this.variables==null && other.getVariables()==null) || 
             (this.variables!=null &&
              java.util.Arrays.equals(this.variables, other.getVariables())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getIndicador() != null) {
            _hashCode += getIndicador().hashCode();
        }
        if (getVariables() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVariables());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVariables(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Indicador.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("Operaciones", "Indicador"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Indicador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("variables");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Variables"));
        elemField.setXmlType(new javax.xml.namespace.QName("Operaciones", "Variable"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
