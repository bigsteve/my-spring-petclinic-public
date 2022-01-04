package stefan.spring.petclinicdata.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import stefan.spring.petclinicdata.model.Owner;

/**
 * @author stefan
 *
 */
public interface OwnerRepository extends CrudRepository<Owner, Long>{
    
    Owner findByLastName(String LastName);
    List<Owner> findAllByLastNameLike(String LastName);

}
