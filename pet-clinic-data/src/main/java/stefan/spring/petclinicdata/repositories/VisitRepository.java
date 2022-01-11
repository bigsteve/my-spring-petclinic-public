package stefan.spring.petclinicdata.repositories;

import org.springframework.data.repository.CrudRepository;

import stefan.spring.petclinicdata.model.Visit;

/**
 * @author stefan
 *
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {

}
