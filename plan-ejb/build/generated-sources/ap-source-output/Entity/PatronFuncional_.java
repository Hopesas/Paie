package Entity;

import Entity.NicDiagnostico;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-24T21:28:50")
@StaticMetamodel(PatronFuncional.class)
public class PatronFuncional_ { 

    public static volatile SingularAttribute<PatronFuncional, BigDecimal> id;
    public static volatile CollectionAttribute<PatronFuncional, NicDiagnostico> nicDiagnosticoCollection;
    public static volatile SingularAttribute<PatronFuncional, String> definicion;
    public static volatile SingularAttribute<PatronFuncional, String> descripcion;

}