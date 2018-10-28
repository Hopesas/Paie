package Entity;

import Entity.NicDiagnostico;
import Entity.NocDiagnostico;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-24T21:28:50")
@StaticMetamodel(Noc.class)
public class Noc_ { 

    public static volatile SingularAttribute<Noc, Long> id;
    public static volatile SingularAttribute<Noc, Long> codigo;
    public static volatile CollectionAttribute<Noc, NocDiagnostico> nocDiagnosticoCollection;
    public static volatile CollectionAttribute<Noc, NicDiagnostico> nicDiagnosticoCollection;
    public static volatile SingularAttribute<Noc, Long> extra;
    public static volatile SingularAttribute<Noc, String> definicion;
    public static volatile SingularAttribute<Noc, String> resultado;
    public static volatile SingularAttribute<Noc, String> clase;
    public static volatile SingularAttribute<Noc, String> dominio;

}