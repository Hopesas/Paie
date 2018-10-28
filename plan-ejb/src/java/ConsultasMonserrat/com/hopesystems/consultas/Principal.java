package com.hopesystems.consultas;


import Operaciones_pkg.Campo;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import Operaciones_pkg.Indicador;
import Operaciones_pkg.OperacionesBindingStub;
import Operaciones_pkg.OperacionesLocator;
import Operaciones_pkg.Registro;
import Operaciones_pkg.Variable;

public class Principal {

	public void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hola");
		QName q = new javax.xml.namespace.QName("Operaciones", "Operaciones");
		OperacionesLocator oper = new OperacionesLocator("http://190.147.23.15/WebServices/consultaws.php?wsdl", q);
		
		Indicador i = new Indicador();
		i.setIndicador("acceso_sistema");
		Variable[] variables = new Variable[2];
		Variable v = new Variable();
		v.setVariable("Usuario");
		v.setValor("natalia.ar");
		v.setTipo("Variable");
		v.setObservaciones("");
		Variable v2 = new Variable();
		v2.setVariable("Clave");
		v2.setValor("534f190acdaddf0b7b720f6492cc73ac");
		v2.setTipo("Variable");
		v2.setObservaciones("");
		variables[0] = v;
		variables[1] = v2;
		i.setVariables(variables);
		Registro[] r = oper.getOperacionesPort().consultas(i);
		Registro rr = r[0];
		System.out.println("Hola2: " + ((Campo) rr.getCampos()[0]).getValor());
	}

}
