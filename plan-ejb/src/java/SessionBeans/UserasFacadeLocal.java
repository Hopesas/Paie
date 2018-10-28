/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entity.Useras;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Freddy
 */
@Local
public interface UserasFacadeLocal {

    void create(Useras useras);

    void edit(Useras useras);

    void remove(Useras useras);

    Useras find(Object id);

    List<Useras> findAll();

    List<Useras> findRange(int[] range);

    int count();

    Useras findByName(String username);

    public Useras findById(long idUseras);
    
}
