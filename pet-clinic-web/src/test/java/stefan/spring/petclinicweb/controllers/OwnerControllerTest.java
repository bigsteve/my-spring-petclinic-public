package stefan.spring.petclinicweb.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import stefan.spring.petclinicdata.model.Owner;
import stefan.spring.petclinicdata.service.OwnerService;

/**
 * @author stefan
 *
 */
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnerController ownerController;

    MockMvc mockMvc;

    Set<Owner> owners;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        owners = new HashSet<>();
        owners.add(Owner.builder()
                .id(3l)
                .address("111 street")
                .city("mycity")
                .telephone("1111111111")
                .build());
        owners.add(Owner.builder()
                .id(4l)
                .address("222 street")
                .city("mycity")
                .telephone("2222222222")
                .build());

        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    /**
     * Test method for
     * {@link stefan.spring.petclinicweb.controllers.OwnerController#findOwners()}.
     * @throws Exception 
     */
    @Test
    void testFindOwners() throws Exception {

        mockMvc.perform(get("/owners/find/"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().attributeExists("owner"));
        verifyNoInteractions(ownerService);
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find/"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().attributeExists("owner"));

        verifyNoInteractions(ownerService);
    }

    @Test
    void processFindFormReturnMany() throws Exception {
        when(ownerService.findAllByLastNameLike(anyString()))
                .thenReturn(Arrays.asList(Owner.builder().id(5l).build(),
                        Owner.builder().id(6l).build()));
        mockMvc.perform(get("/owners/"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("selections", hasSize(2)));
    }

    @Test
    void processFindFormEmptyReturnMany() throws Exception {
        when(ownerService.findAllByLastNameLike(anyString()))
                .thenReturn(Arrays.asList(Owner.builder().id(1l).build(),
                        Owner.builder().id(2l).build()));

        mockMvc.perform(get("/owners/")
                        .param("lastName",""))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("selections", hasSize(2)));;
    }
    
    /**
     * Test method for
     * {@link stefan.spring.petclinicweb.controllers.OwnerController#showOwner(Long)}.
     * @throws Exception 
     */
    @Test
    void testDisplayOwner() throws Exception {
        
        when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());
        mockMvc.perform(get("/owners/111/"))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/ownerDetails"))
        .andExpect(model().attribute("owner", hasProperty("id",is(1L))));
    }

    @Test
    void initCreationForm() throws Exception {
        mockMvc.perform(get("/owners/new/"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createUpdateOwner"))
                .andExpect(model().attributeExists("owner"));

        verifyNoInteractions(ownerService);
    }

    @Test
    void processCreationForm() throws Exception {
//        when(ownerService.save(ArgumentMatchers.any())).thenReturn(Owner.builder()
//                .id(7L)
//                .address("111 street")
//                .city("mycity")
//                .telephone("1111111111")
//                .build());
//
//        mockMvc.perform(post("/owners/new/"))
//        .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/owners/7/"))
//                .andExpect(model().attributeExists("owner"));
//
//        verify(ownerService).save(any());
        
    }

    @Test
    void initUpdateOwnerForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());

        mockMvc.perform(get("/owners/1/edit/"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createUpdateOwner"))
                .andExpect(model().attributeExists("owner"));

    }

    @Test
    void processUpdateOwnerForm() throws Exception {

//        when(ownerService.save(ArgumentMatchers.any())).thenReturn(Owner.builder().id(1L).build());

//        mockMvc.perform(post("/owners/1/edit/"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/owners/1/"))
//                .andExpect(model().attributeExists("owner"));
//
//        verify(ownerService).save(any());
        
    }

}
