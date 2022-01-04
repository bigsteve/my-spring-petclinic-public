package stefan.spring.petclinicweb.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import stefan.spring.petclinicdata.model.Owner;
import stefan.spring.petclinicdata.model.Pet;
import stefan.spring.petclinicdata.model.PetType;
import stefan.spring.petclinicdata.model.Specialty;
import stefan.spring.petclinicdata.model.Vet;
import stefan.spring.petclinicdata.model.Visit;
import stefan.spring.petclinicdata.service.OwnerService;
import stefan.spring.petclinicdata.service.PetTypeService;
import stefan.spring.petclinicdata.service.SpecialtiesService;
import stefan.spring.petclinicdata.service.VetService;
import stefan.spring.petclinicdata.service.VisitService;

/**
 * 
 * @author stefan
 *
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;
    private final VisitService visitService;
    
    
    
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
            SpecialtiesService specialtiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0) loadData();
    }

    public void loadData() {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType petTypeDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType petTypeCat = petTypeService.save(cat);

        Specialty spec1 = new Specialty();
        spec1.setDescription("Radiology");
        Specialty savedSpec1 = specialtiesService.save(spec1);

        Specialty spec2 = new Specialty();
        spec2.setDescription("Surgery");
        Specialty savedSpec2 = specialtiesService.save(spec2);

        Specialty spec3 = new Specialty();
        spec3.setDescription("Dentistry");
        Specialty savedSpec3 = specialtiesService.save(spec3);

        Owner owner1 = new Owner();
        owner1.setFirstName("Stefan");
        owner1.setLastName("Miller");
        owner1.setAddress("111 Street");
        owner1.setCity("Acity");
        owner1.setTelephone("1111111111");

        Pet ow1Pet1 = new Pet();
        ow1Pet1.setPetType(petTypeDog);
        ow1Pet1.setOwner(owner1);
        ow1Pet1.setBirthDate(LocalDate.of(2010, 10, 20));
        ow1Pet1.setName("Dogosco");
        owner1.getPets().add(ow1Pet1);
        

        Pet ow1Pet2 = new Pet();
        ow1Pet2.setPetType(petTypeCat);
        ow1Pet2.setOwner(owner1);
        ow1Pet2.setBirthDate(LocalDate.of(2020, 2, 20));
        ow1Pet2.setName("Catosco");
        owner1.getPets().add(ow1Pet2);

        ownerService.save(owner1);

        // set visit
        Visit ow1Visit1 = new Visit();
        ow1Visit1.setPet(ow1Pet1);
        ow1Visit1.setDate(LocalDate.now());
        ow1Visit1.setDescription("Sneezy dog of Owner 1");
        visitService.save(ow1Visit1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Joe");
        owner2.setLastName("Doe");
        owner2.setAddress("222 Street");
        owner2.setCity("Bcity");
        owner2.setTelephone("2222222222");

        Pet ow2Pet1 = new Pet();
        ow2Pet1.setPetType(petTypeCat);
        ow2Pet1.setOwner(owner2);
        ow2Pet1.setBirthDate(LocalDate.of(2019, 2, 2));
        ow2Pet1.setName("Cattwo");
        owner2.getPets().add(ow2Pet1);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Mevet");
        vet1.setLastName("Lastvet");
        vet1.getSpecialties().add(savedSpec1);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Secondvet");
        vet2.setLastName("Secondlastnamevet");
        vet2.getSpecialties().add(savedSpec2);
        vet2.getSpecialties().add(savedSpec3);
        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }

}
