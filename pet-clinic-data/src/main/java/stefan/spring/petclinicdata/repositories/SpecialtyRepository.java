package stefan.spring.petclinicdata.repositories;

import org.springframework.data.repository.CrudRepository;

import stefan.spring.petclinicdata.model.Specialty;

/**
 * @author stefan
 *
 */
public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {

}
