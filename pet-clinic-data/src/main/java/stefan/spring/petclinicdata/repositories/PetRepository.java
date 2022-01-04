package stefan.spring.petclinicdata.repositories;

import org.springframework.data.repository.CrudRepository;

import stefan.spring.petclinicdata.model.Pet;

/**
 * @author stefan
 *
 */
public interface PetRepository extends CrudRepository<Pet, Long> {

}
