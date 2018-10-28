package Entity;

import Entity.IndicadoresDiagnostico;
import Entity.Noc;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-24T21:28:50")
@StaticMetamodel(Indicadores.class)
public class Indicadores_ { 

    public static volatile SingularAttribute<Indicadores, Long> id;
    public static volatile SingularAttribute<Indicadores, Long> codigo;
    public static volatile SingularAttribute<Indicadores, String> indicador;
    public static volatile SingularAttribute<Indicadores, String> escala;
    public static volatile CollectionAttribute<Indicadores, IndicadoresDiagnostico> indicadoresDiagnosticoCollection;
    public static volatile SingularAttribute<Indicadores, Noc> codigoNoc;

}