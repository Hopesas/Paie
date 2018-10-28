package Entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-24T21:28:50")
@StaticMetamodel(Nanda.class)
public class Nanda_ { 

    public static volatile SingularAttribute<Nanda, BigDecimal> id;
    public static volatile SingularAttribute<Nanda, Long> codigo;
    public static volatile SingularAttribute<Nanda, Long> patron;
    public static volatile SingularAttribute<Nanda, String> descripcion;
    public static volatile SingularAttribute<Nanda, String> diagnostico;
    public static volatile SingularAttribute<Nanda, String> clases;
    public static volatile SingularAttribute<Nanda, Short> riesgo;
    public static volatile SingularAttribute<Nanda, String> dominio;

}