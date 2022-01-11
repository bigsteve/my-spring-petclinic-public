package stefan.spring.petclinicdata.repositories;

import org.springframework.data.repository.CrudRepository;

import stefan.spring.petclinicdata.model.Vet;

/**
 * @author stefan
 *
 */
public interface VetRepository extends CrudRepository<Vet, Long> {

}
