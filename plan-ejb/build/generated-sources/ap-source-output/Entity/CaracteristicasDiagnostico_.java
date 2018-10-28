package Entity;

import Entity.CaracteristicasDefinitorias;
import Entity.Diagnostico;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-24T21:28:50")
@StaticMetamodel(CaracteristicasDiagnostico.class)
public class CaracteristicasDiagnostico_ { 

    public static volatile SingularAttribute<CaracteristicasDiagnostico, Long> id;
    public static volatile SingularAttribute<CaracteristicasDiagnostico, CaracteristicasDefinitorias> idCaracteristica;
    public static volatile SingularAttribute<CaracteristicasDiagnostico, Diagnostico> idDiagnostico;

}