package stefan.spring.petclinicdata.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import stefan.spring.petclinicdata.model.Vet;
import stefan.spring.petclinicdata.service.VetService;

/**
 * 
 * @author stefan
 *
 */
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Vet save(Vet object) {
        return super.save(object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
    
    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}