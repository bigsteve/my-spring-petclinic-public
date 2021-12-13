package stefan.spring.petclinicdata.service;

import org.springframework.stereotype.Service;

import stefan.spring.petclinicdata.model.Owner;

/**
 * 
 * @author stefan
 *
 */
@Service
public interface OwnerService extends CrudService<Owner, Long> {
    
    Owner findByLastName(String lastName);
    
}
