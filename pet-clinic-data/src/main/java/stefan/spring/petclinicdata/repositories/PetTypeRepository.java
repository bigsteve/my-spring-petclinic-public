package stefan.spring.petclinicdata.repositories;

import org.springframework.data.repository.CrudRepository;

import stefan.spring.petclinicdata.model.PetType;

/**
 * @author stefan
 *
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
