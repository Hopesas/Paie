package Entity;

import Entity.ActividadesDiagnostico;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-24T21:28:50")
@StaticMetamodel(Actividades.class)
public class Actividades_ { 

    public static volatile SingularAttribute<Actividades, Long> id;
    public static volatile SingularAttribute<Actividades, Long> codigoNic;
    public static volatile SingularAttribute<Actividades, Long> codigo;
    public static volatile SingularAttribute<Actividades, String> actividad;
    public static volatile CollectionAttribute<Actividades, ActividadesDiagnostico> actividadesDiagnosticoCollection;

}