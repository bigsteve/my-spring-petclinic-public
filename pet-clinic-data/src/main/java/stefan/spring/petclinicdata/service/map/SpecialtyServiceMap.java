package stefan.spring.petclinicdata.service.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import stefan.spring.petclinicdata.model.Specialty;
import stefan.spring.petclinicdata.service.SpecialtiesService;

/**
 * 
 * @author stefan
 *
 */
@Service
@Profile({"default", "map"})
public class SpecialtyServiceMap extends AbstractServiceMap<Specialty, Long> implements SpecialtiesService {

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

}
