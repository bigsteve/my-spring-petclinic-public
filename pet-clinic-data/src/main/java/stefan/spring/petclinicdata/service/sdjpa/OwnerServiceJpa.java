package stefan.spring.petclinicdata.service.sdjpa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import stefan.spring.petclinicdata.model.Owner;
import stefan.spring.petclinicdata.repositories.OwnerRepository;
import stefan.spring.petclinicdata.repositories.PetRepository;
import stefan.spring.petclinicdata.repositories.PetTypeRepository;
import stefan.spring.petclinicdata.service.OwnerService;

/**
 * @author stefan
 *
 */
@Service
@Profile("sdjpa")
public class OwnerServiceJpa implements OwnerService {
    
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;
    
    
    public OwnerServiceJpa(OwnerRepository ownerRepository, PetRepository petRepository,
            PetTypeRepository petTypeRepository) {
        super();
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
        System.out.println("SDJpa profile is working ==============================");
    }
    

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);

    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }


    @Override
    public List<Owner> findAllByLastNameLike(String string) {
        return (List<Owner>) ownerRepository.findAllByLastNameLike(string);

    }

}
