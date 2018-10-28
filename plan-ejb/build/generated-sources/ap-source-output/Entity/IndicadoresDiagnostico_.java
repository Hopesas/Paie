package Entity;

import Entity.Diagnostico;
import Entity.Indicadores;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-24T21:28:50")
@StaticMetamodel(IndicadoresDiagnostico.class)
public class IndicadoresDiagnostico_ { 

    public static volatile SingularAttribute<IndicadoresDiagnostico, Long> id;
    public static volatile SingularAttribute<IndicadoresDiagnostico, BigInteger> valor;
    public static volatile SingularAttribute<IndicadoresDiagnostico, Indicadores> idIndicador;
    public static volatile SingularAttribute<IndicadoresDiagnostico, Diagnostico> idDiagnostico;

}