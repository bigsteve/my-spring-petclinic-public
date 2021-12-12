package stefan.spring.petclinicweb.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import stefan.spring.petclinicdata.model.Owner;
import stefan.spring.petclinicdata.model.Vet;
import stefan.spring.petclinicdata.service.OwnerService;
import stefan.spring.petclinicdata.service.VetService;

/**
 * 
 * @author stefan
 *
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Stefan");
        owner1.setLastName("Miller");
        ownerService.save(owner1);
        
        Owner owner2 = new Owner();
        owner2.setFirstName("Joe");
        owner2.setLastName("Doe");
        ownerService.save(owner2);
        
        System.out.println("Loaded owners...");
        
        Vet vet1 = new Vet();
        vet1.setFirstName("Mevet");
        vet1.setLastName("Lastvet");
        vetService.save(vet1);
        
        Vet vet2 = new Vet();
        vet2.setFirstName("Secondvet");
        vet2.setLastName("Secondlastnamevet");
        vetService.save(vet2);
        
        System.out.println("Loaded vets...");
        
        
        
    }
    

}
