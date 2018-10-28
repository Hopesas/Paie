package Entity;

import Entity.Diagnostico;
import Entity.Nic;
import Entity.Noc;
import Entity.PatronFuncional;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-24T21:28:50")
@StaticMetamodel(NicDiagnostico.class)
public class NicDiagnostico_ { 

    public static volatile SingularAttribute<NicDiagnostico, Long> id;
    public static volatile SingularAttribute<NicDiagnostico, Nic> idNic;
    public static volatile SingularAttribute<NicDiagnostico, Diagnostico> idDiagnostico;
    public static volatile SingularAttribute<NicDiagnostico, Noc> idNoc;
    public static volatile SingularAttribute<NicDiagnostico, PatronFuncional> idPatron;

}