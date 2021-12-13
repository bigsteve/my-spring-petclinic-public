package stefan.spring.petclinicdata.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import stefan.spring.petclinicdata.model.Pet;
import stefan.spring.petclinicdata.service.PetService;

/**
 * 
 * @author stefan
 *
 */
@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
