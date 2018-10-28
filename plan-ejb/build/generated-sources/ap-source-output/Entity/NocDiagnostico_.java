package Entity;

import Entity.Diagnostico;
import Entity.Noc;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-24T21:28:50")
@StaticMetamodel(NocDiagnostico.class)
public class NocDiagnostico_ { 

    public static volatile SingularAttribute<NocDiagnostico, Long> id;
    public static volatile SingularAttribute<NocDiagnostico, Long> valorActual;
    public static volatile SingularAttribute<NocDiagnostico, Diagnostico> idDiagnostico;
    public static volatile SingularAttribute<NocDiagnostico, Noc> idNoc;
    public static volatile SingularAttribute<NocDiagnostico, Long> valorDiana;

}