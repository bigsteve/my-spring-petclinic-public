package stefan.spring.petclinicdata.service.sdjpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import stefan.spring.petclinicdata.model.PetType;
import stefan.spring.petclinicdata.repositories.PetTypeRepository;
import stefan.spring.petclinicdata.service.PetTypeService;

/**
 * @author stefan
 *
 */
@Service
@Profile("sdjpa")
public class PetTypeServiceJpa implements PetTypeService {
    
    private final PetTypeRepository petTypeRepository;
    

    public PetTypeServiceJpa(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }


    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }


    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }


    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
        
    }


    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
        
    }

}
