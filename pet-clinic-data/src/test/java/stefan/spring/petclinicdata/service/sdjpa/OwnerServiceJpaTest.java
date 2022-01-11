package stefan.spring.petclinicdata.service.sdjpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import stefan.spring.petclinicdata.model.Owner;
import stefan.spring.petclinicdata.repositories.OwnerRepository;
import stefan.spring.petclinicdata.repositories.PetRepository;
import stefan.spring.petclinicdata.repositories.PetTypeRepository;

/**
 * @author stefan
 *
 */
@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {

    @InjectMocks
    OwnerServiceJpa ownerService;
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;


    private final Long ID = 1L;
    private final String LAST_NAME = "Gigimarga";
    private Owner returnedOwner;
    
    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {

        returnedOwner = Owner.builder().id(ID).lastName(LAST_NAME).build();
//        ownerServiceJpa = new OwnerServiceJpa(new PetTypeServiceMap(),new PetServiceMap());
//        ownerService.save(Owner.builder().id(ID).build());
    }

    /**
     * Test method for
     * {@link stefan.spring.petclinicdata.service.sdjpa.OwnerServiceJpa#OwnerServiceJpa(stefan.spring.petclinicdata.repositories.OwnerRepository, stefan.spring.petclinicdata.repositories.PetRepository, stefan.spring.petclinicdata.repositories.PetTypeRepository)}.
     */
    @Test
    void testOwnerServiceJpa() {

    }

    /**
     * Test method for
     * {@link stefan.spring.petclinicdata.service.sdjpa.OwnerServiceJpa#findAll()}.
     */
    @Test
    void testFindAll() {
        Set<Owner> returnedOwnerSet = new HashSet<>();
        returnedOwnerSet.add(returnedOwner);
        returnedOwnerSet.add(Owner.builder().id(2L).lastName("Me").build());
        
        when(ownerRepository.findAll()).thenReturn(returnedOwnerSet);
        Set<Owner> owners = ownerService.findAll();
        assertNotNull(owners);
        assertEquals(owners.size(), 2);
    }

    /**
     * Test method for
     * {@link stefan.spring.petclinicdata.service.sdjpa.OwnerServiceJpa#findById(java.lang.Long)}.
     */
    @Test
    void testFindById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));
        Owner owner = ownerService.findById(1L);
        assertNotNull(owner);
    }

    /**
     * Test method for
     * {@link stefan.spring.petclinicdata.service.sdjpa.OwnerServiceJpa#findById(java.lang.Long)}.
     */
    @Test
    void testFindByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerService.findById(1L);
        assertNull(owner);
    }

    /**
     * Test method for
     * {@link stefan.spring.petclinicdata.service.sdjpa.OwnerServiceJpa#save(stefan.spring.petclinicdata.model.Owner)}.
     */
    @Test
    void testSave() {
        Owner saveOwner = Owner.builder().id(2L).build();
        when(ownerRepository.save(any())).thenReturn(returnedOwner);
        Owner savedOwner = ownerService.save(saveOwner);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    /**
     * Test method for
     * {@link stefan.spring.petclinicdata.service.sdjpa.OwnerServiceJpa#delete(stefan.spring.petclinicdata.model.Owner)}.
     */
    @Test
    void testDelete() {
        ownerService.delete(returnedOwner);
        verify(ownerRepository, times(1)).delete(any());
    }

    /**
     * Test method for
     * {@link stefan.spring.petclinicdata.service.sdjpa.OwnerServiceJpa#deleteById(java.lang.Long)}.
     */
    @Test
    void testDeleteById() {

        ownerService.deleteById(ID);
        verify(ownerRepository).deleteById(anyLong());
    }

    /**
     * Test method for
     * {@link stefan.spring.petclinicdata.service.sdjpa.OwnerServiceJpa#findByLastName(java.lang.String)}.
     */
    @Test
    void testFindByLastName() {
        
        when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);
        Owner owner = ownerService.findByLastName(LAST_NAME);
        assertEquals(owner.getLastName(), LAST_NAME);
        verify(ownerRepository).findByLastName(any());
    }

}
