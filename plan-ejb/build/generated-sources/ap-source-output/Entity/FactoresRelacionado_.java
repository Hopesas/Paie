package Entity;

import Entity.FactoresDiagnostico;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-24T21:28:50")
@StaticMetamodel(FactoresRelacionado.class)
public class FactoresRelacionado_ { 

    public static volatile SingularAttribute<FactoresRelacionado, Long> id;
    public static volatile CollectionAttribute<FactoresRelacionado, FactoresDiagnostico> factoresDiagnosticoCollection;
    public static volatile SingularAttribute<FactoresRelacionado, Long> codigoNanda;
    public static volatile SingularAttribute<FactoresRelacionado, String> factorRelacionado;

}