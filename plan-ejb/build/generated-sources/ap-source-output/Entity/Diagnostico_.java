package Entity;

import Entity.ActividadesDiagnostico;
import Entity.CaracteristicasDiagnostico;
import Entity.FactoresDiagnostico;
import Entity.IndicadoresDiagnostico;
import Entity.NicDiagnostico;
import Entity.NocDiagnostico;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-24T21:28:50")
@StaticMetamodel(Diagnostico.class)
public class Diagnostico_ { 

    public static volatile SingularAttribute<Diagnostico, String> idPaciente;
    public static volatile CollectionAttribute<Diagnostico, NocDiagnostico> nocDiagnosticoCollection;
    public static volatile CollectionAttribute<Diagnostico, NicDiagnostico> nicDiagnosticoCollection;
    public static volatile SingularAttribute<Diagnostico, Long> idNanda;
    public static volatile SingularAttribute<Diagnostico, Date> fecha;
    public static volatile CollectionAttribute<Diagnostico, ActividadesDiagnostico> actividadesDiagnosticoCollection;
    public static volatile SingularAttribute<Diagnostico, String> idUseras;
    public static volatile SingularAttribute<Diagnostico, Long> id;
    public static volatile CollectionAttribute<Diagnostico, FactoresDiagnostico> factoresDiagnosticoCollection;
    public static volatile CollectionAttribute<Diagnostico, IndicadoresDiagnostico> indicadoresDiagnosticoCollection;
    public static volatile SingularAttribute<Diagnostico, Long> caida;
    public static volatile CollectionAttribute<Diagnostico, CaracteristicasDiagnostico> caracteristicasDiagnosticoCollection;
    public static volatile SingularAttribute<Diagnostico, Long> idPatron;

}