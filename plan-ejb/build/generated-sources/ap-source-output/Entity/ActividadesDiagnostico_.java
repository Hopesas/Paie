package Entity;

import Entity.Actividades;
import Entity.Diagnostico;
import Entity.Nic;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-24T21:28:50")
@StaticMetamodel(ActividadesDiagnostico.class)
public class ActividadesDiagnostico_ { 

    public static volatile SingularAttribute<ActividadesDiagnostico, Long> id;
    public static volatile SingularAttribute<ActividadesDiagnostico, Nic> idNic;
    public static volatile SingularAttribute<ActividadesDiagnostico, Diagnostico> idDiagnostico;
    public static volatile SingularAttribute<ActividadesDiagnostico, Actividades> idActividad;

}