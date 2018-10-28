package Entity;

import Entity.Diagnostico;
import Entity.FactoresRelacionado;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-24T21:28:50")
@StaticMetamodel(FactoresDiagnostico.class)
public class FactoresDiagnostico_ { 

    public static volatile SingularAttribute<FactoresDiagnostico, Long> id;
    public static volatile SingularAttribute<FactoresDiagnostico, FactoresRelacionado> idFactor;
    public static volatile SingularAttribute<FactoresDiagnostico, Diagnostico> idDiagnostico;

}