package Entity;

import Entity.ActividadesDiagnostico;
import Entity.NicDiagnostico;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-24T21:28:50")
@StaticMetamodel(Nic.class)
public class Nic_ { 

    public static volatile SingularAttribute<Nic, Long> id;
    public static volatile SingularAttribute<Nic, Long> codigo;
    public static volatile CollectionAttribute<Nic, NicDiagnostico> nicDiagnosticoCollection;
    public static volatile SingularAttribute<Nic, String> definicion;
    public static volatile CollectionAttribute<Nic, ActividadesDiagnostico> actividadesDiagnosticoCollection;
    public static volatile SingularAttribute<Nic, String> intervencion;

}