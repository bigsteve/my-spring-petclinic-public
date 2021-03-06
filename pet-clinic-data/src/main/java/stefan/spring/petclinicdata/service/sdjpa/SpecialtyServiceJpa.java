package stefan.spring.petclinicdata.service.sdjpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import stefan.spring.petclinicdata.model.Specialty;
import stefan.spring.petclinicdata.repositories.SpecialtyRepository;
import stefan.spring.petclinicdata.service.SpecialtiesService;

/**
 * @author stefan
 *
 */
@Service
@Profile("sdjpa")
public class SpecialtyServiceJpa implements SpecialtiesService {

    private final SpecialtyRepository specialtyRepository;
    
    
    public SpecialtyServiceJpa(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }
    

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }

}
