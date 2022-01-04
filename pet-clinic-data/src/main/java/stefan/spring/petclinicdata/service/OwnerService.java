package stefan.spring.petclinicdata.service;

import java.util.List;

import stefan.spring.petclinicdata.model.Owner;

/**
 * 
 * @author stefan
 *
 */
public interface OwnerService extends CrudService<Owner, Long> {
    
    
    Owner findByLastName(String lastName);

    /**
     * @param string
     * @return
     */
    List<Owner> findAllByLastNameLike(String string);
    
}
