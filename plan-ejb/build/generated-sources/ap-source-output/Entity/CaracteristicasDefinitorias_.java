package Entity;

import Entity.CaracteristicasDiagnostico;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-24T21:28:50")
@StaticMetamodel(CaracteristicasDefinitorias.class)
public class CaracteristicasDefinitorias_ { 

    public static volatile SingularAttribute<CaracteristicasDefinitorias, Long> id;
    public static volatile SingularAttribute<CaracteristicasDefinitorias, Long> codigoNanda;
    public static volatile SingularAttribute<CaracteristicasDefinitorias, String> definicion;
    public static volatile CollectionAttribute<CaracteristicasDefinitorias, CaracteristicasDiagnostico> caracteristicasDiagnosticoCollection;

}