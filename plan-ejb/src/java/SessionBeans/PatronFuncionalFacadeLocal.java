/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entity.PatronFuncional;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Freddy
 */
@Local
public interface PatronFuncionalFacadeLocal {

    PatronFuncional find(Object id);

    List<PatronFuncional> findAll();
    
    int count();
    
    PatronFuncional findById(BigDecimal id);
}
