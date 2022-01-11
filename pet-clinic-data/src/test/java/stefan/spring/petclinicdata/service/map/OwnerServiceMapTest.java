package stefan.spring.petclinicdata.service.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import stefan.spring.petclinicdata.model.Owner;

/**
 * @author stefan
 *
 */
class OwnerServiceMapTest {

    Long idLong = 1L;
    String lastName = "Gigimarga";
    OwnerServiceMap ownerServiceMap;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(),new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(idLong).lastName(lastName).build());
    }

    /**
     * Test method for {@link stefan.spring.petclinicdata.service.map.OwnerServiceMap#save(stefan.spring.petclinicdata.model.Owner)}.
     */
    @Test
    void testSaveOwner() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).lastName("Deni").build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertEquals(savedOwner.getId(), id);
        
    }

    /**
     * Test method for {@link stefan.spring.petclinicdata.service.map.OwnerServiceMap#findAll()}.
     */
    @Test
    void testFindAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(ownerSet.size(), 1);
    }

    /**
     * Test method for {@link stefan.spring.petclinicdata.service.map.OwnerServiceMap#findById(java.lang.Long)}.
     */
    @Test
    void testFindByIdLong() {
        Owner owner = ownerServiceMap.findById(idLong);
        assertEquals(owner.getId(), idLong);
    }

    /**
     * Test method for {@link stefan.spring.petclinicdata.service.map.OwnerServiceMap#findById(java.lang.Long)}.
     */
    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertEquals(savedOwner.getId(), id);

    }

    /**
     * Test method for {@link stefan.spring.petclinicdata.service.map.OwnerServiceMap#findById(java.lang.Long)}.
     */
    @Test
    void saveNoId() {
        Owner owner2 = Owner.builder().build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    /**
     * Test method for {@link stefan.spring.petclinicdata.service.map.OwnerServiceMap#delete(stefan.spring.petclinicdata.model.Owner)}.
     */
    @Test
    void testDeleteOwner() {
        ownerServiceMap.delete(ownerServiceMap.findById(idLong));
        assertEquals(ownerServiceMap.findAll().size(), 0);
    }

    /**
     * Test method for {@link stefan.spring.petclinicdata.service.map.OwnerServiceMap#deleteById(java.lang.Long)}.
     */
    @Test
    void testDeleteByIdLong() {
        ownerServiceMap.deleteById(idLong);
        assertEquals(ownerServiceMap.findAll().size(), 0);
    }

    /**
     * Test method for {@link stefan.spring.petclinicdata.service.map.OwnerServiceMap#findByLastName(java.lang.String)}.
     */
    @Test
    void testFindByLastName() {
        Owner owner = ownerServiceMap.findByLastName(lastName);
        assertEquals(owner.getLastName(), lastName);
    }

}
