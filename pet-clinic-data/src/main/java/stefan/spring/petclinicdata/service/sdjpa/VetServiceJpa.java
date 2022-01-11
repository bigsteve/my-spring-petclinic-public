package stefan.spring.petclinicdata.service.sdjpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import stefan.spring.petclinicdata.model.Vet;
import stefan.spring.petclinicdata.repositories.VetRepository;
import stefan.spring.petclinicdata.service.VetService;

/**
 * @author stefan
 *
 */
@Service
@Profile("sdjpa")
public class VetServiceJpa implements VetService {
    
    private final VetRepository vetRepository;
    

    public VetServiceJpa(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>(); 
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);

    }

}
