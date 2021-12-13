package stefan.spring.petclinicdata.service.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import stefan.spring.petclinicdata.model.Owner;
import stefan.spring.petclinicdata.service.OwnerService;
/**
 * 
 * @author stefan
 *
 */
@Service
//@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner save(Owner object) {
        return super.save(object);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public Owner findByLastName(String lastName) {
        return null;
    }


}
